package com.qf.storage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.storage.po.ExWarehouse;
import com.qf.storage.po.Warehouse;
import com.qf.storage.service.ExWarehouseService;
import com.qf.storage.utils.TableData;
import com.qf.sys.po.Emp;
import com.qf.utils.LayUIOperate;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/exWarehouse")
public class ExWarehouseController {
    @Autowired
    private ExWarehouseService exWarehouseService;

    @RequestMapping("/findByPage")
    @ResponseBody
    public TableData findByPage(HttpServletRequest request){
        int pageSize =Integer.parseInt(request.getParameter("limit"));
        int pageNumber = Integer.parseInt(request.getParameter("page"));
        //HttpSession session=request.getSession();
        String name = request.getParameter("name");
        String status = request.getParameter("status");
        Map params = new HashMap();
        params.put("name", name);
        params.put("status", status);
        PageHelper.startPage(pageNumber, pageSize);
        PageInfo<ExWarehouse> data = exWarehouseService.findByPage(params);
        TableData tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(data.getTotal());//设置总条数
        tableData.setData(data.getList());//设置当前的数据
        return tableData;
    }
    @RequestMapping("/findByPage2")
    @ResponseBody
    public TableData findByPage2(HttpServletRequest request){
        int pageSize =Integer.parseInt(request.getParameter("limit"));
        int pageNumber = Integer.parseInt(request.getParameter("page"));
        //HttpSession session=request.getSession();
        String name = request.getParameter("name");
        String regionP = request.getParameter("regionP");
        String regionName = request.getParameter("regionName");
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
        Map params = new HashMap();
        params.put("name", name);
        params.put("regionName", regionName);
        params.put("regionP", regionP);
        params.put("beginTime", beginTime);
        params.put("endTime", endTime);
        PageHelper.startPage(pageNumber, pageSize);
        PageInfo<ExWarehouse> data = exWarehouseService.findByPage2(params);
        TableData tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(data.getTotal());//设置总条数
        tableData.setData(data.getList());//设置当前的数据
        return tableData;
    }

    @RequestMapping("/addExWarehouse")
    @ResponseBody
    public LayUIOperate addStorehouse(@RequestBody ExWarehouse ExWarehouse, HttpServletRequest request){

        HttpSession session=request.getSession();
//        Emp emp=(Emp)session.getAttribute("emp");
//        emp.setId(1);
       ExWarehouse.setUser(new Emp(3));
        LayUIOperate operate=new LayUIOperate();
        boolean f= exWarehouseService.addStorehouse(ExWarehouse);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("添加成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("添加失败");
        }
        return operate;
    }
    @RequestMapping("/delExWarehouse")
    @ResponseBody
    public LayUIOperate delStorehouse(Integer id){
        LayUIOperate operate=new LayUIOperate();
        boolean f= exWarehouseService.delStorehouse(id);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("删除成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("删除失败");
        }
        return operate;
    }
    @RequestMapping("/updateExWarehouse")
    @ResponseBody
    public LayUIOperate updateStorehouse(@RequestBody ExWarehouse ExWarehouse, HttpServletRequest request){
        LayUIOperate operate=new LayUIOperate();
        if(ExWarehouse.getStorehouse().getId()==0) ExWarehouse.setStatus("2");
        else ExWarehouse.setStatus("3");
        boolean f= exWarehouseService.updateStorehouse(ExWarehouse);
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
    public String getStorehouseById(int id){
        exWarehouseService.getStorehouseById(id);
        return "storehouseList2";
    }
    @RequestMapping("/fastJson")
    @ResponseBody
    public ExWarehouse getFastJson(ExWarehouse ExWarehouse){
        return ExWarehouse;
    }
    @RequestMapping("/dateTest")
    public void dateTest(ExWarehouse ExWarehouse){
        System.out.println(ExWarehouse);
    }
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile photoSource, ExWarehouse ExWarehouse, HttpServletRequest request) throws IOException {
        String fileName=photoSource.getOriginalFilename();
        String fileType=photoSource.getContentType();
        System.out.println(ExWarehouse.id);
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
