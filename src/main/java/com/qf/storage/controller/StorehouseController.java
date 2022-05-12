package com.qf.storage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.storage.po.Storehouse;
import com.qf.storage.service.StorehouseService;
import com.qf.storage.utils.PageUtils;
import com.qf.storage.utils.TableData;
import com.qf.sys.po.Emp;
import com.qf.sys.po.Region;
import com.qf.utils.LayUIOperate;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/storehouse")
public class StorehouseController {
    @Autowired
    private StorehouseService storehouseService;

    @RequestMapping("/findByPage")
    @ResponseBody
    public TableData findByPage(HttpServletRequest request){
        int pageSize =Integer.parseInt(request.getParameter("limit"));
        int pageNumber = Integer.parseInt(request.getParameter("page"));
        //HttpSession session=request.getSession();
        Emp e=new Emp(6);
        String regionName = request.getParameter("regionName");
        String name = request.getParameter("name");
        String regionP = request.getParameter("regionP");
        Map params = new HashMap();
        params.put("regionName", regionName);
        params.put("name", name);
        params.put("regionP", regionP);
        if(e.getId()!=6) params.put("masterId", e.getId());
        PageHelper.startPage(pageNumber, pageSize);
        PageInfo<Storehouse> data = storehouseService.findByPage(params);
        TableData tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(data.getTotal());//设置总条数
        tableData.setData(data.getList());//设置当前的数据
        return tableData;
    }

    @RequestMapping("/addStorehouse")
    @ResponseBody
    public LayUIOperate addStorehouse(@RequestBody Storehouse storehouse, HttpServletRequest request){

        HttpSession session=request.getSession();
//        Emp emp=(Emp)session.getAttribute("emp");
//        emp.setId(1);
        LayUIOperate operate=new LayUIOperate();
        storehouse.setUser(new Emp(1));
        System.out.println(storehouse);
        boolean f= storehouseService.addStorehouse(storehouse);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("添加成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("添加失败");
        }
        return operate;
    }
    @RequestMapping("/delStorehouse")
    @ResponseBody
    public LayUIOperate delStorehouse(Integer id){
        LayUIOperate operate=new LayUIOperate();
        boolean f= storehouseService.delStorehouse(id);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("删除成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("删除失败");
        }
        return operate;
    }
    @RequestMapping("/updateStorehouse")
    @ResponseBody
    public LayUIOperate updateStorehouse(@RequestBody Storehouse storehouse, HttpServletRequest request){
        LayUIOperate operate=new LayUIOperate();
        storehouse.setUser(new Emp(1));
        boolean f= storehouseService.updateStorehouse(storehouse);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("更新成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("更新失败");
        }
        return operate;
    }
    @RequestMapping("/getStorehouseById")
    @ResponseBody
    public TableData getStorehouseById(Integer id){
        Storehouse empList = storehouseService.getStorehouseById(id);
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(1);
        data.setData(empList);
        return data;
    }
    @RequestMapping("/getAllStorehouse")
    @ResponseBody
    public TableData getAllStorehouse(){
        List<Storehouse> empList = storehouseService.findAllStorehouse();
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(empList.size());
        data.setData(empList);
        return data;
    }
    @RequestMapping("/getEchartsPie")
    @ResponseBody
    public TableData getEchartsPie(){
        List<Storehouse> empList = storehouseService.getEchartsPie();
        for(Storehouse s:empList){
            List<Storehouse> list2=storehouseService.getStorehouseByM(s.getMaster().getId());
            String st=s.getMaster().getEmpName()+"(";
            for(Storehouse ss:list2){
                st+=ss.getName()+",";
            }
            st=st.substring(0,st.length()-1);
            st+=")";
            s.setAddress(st);
        }
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(empList.size());
        data.setData(empList);
        return data;
    }
    @RequestMapping("/fastJson")
    @ResponseBody
    public Storehouse getFastJson(Storehouse storehouse){
        return storehouse;
    }
    @RequestMapping("/dateTest")
    public void dateTest(Storehouse storehouse){
        System.out.println(storehouse);
    }
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile photoSource, Storehouse storehouse, HttpServletRequest request) throws IOException {
        String fileName=photoSource.getOriginalFilename();
        String fileType=photoSource.getContentType();
        System.out.println(storehouse.id);
        System.out.println(fileName+"&"+fileType);
        String newfileName= UUID.randomUUID().toString();
        String ext= FilenameUtils.getExtension(fileName);
        String parentDir=request.getSession().getServletContext().getRealPath("/uploadFiles");
        String newFile=newfileName+"."+ext;
        File file=new File(parentDir,newFile);
        photoSource.transferTo(file);
        return "success";
    }
}
