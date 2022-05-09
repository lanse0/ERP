package com.qf.storage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.storage.po.Warehouse;
import com.qf.storage.service.WarehouseService;
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
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @RequestMapping("/findByPage")
    @ResponseBody
    public TableData findByPage(HttpServletRequest request){
        int pageSize =Integer.parseInt(request.getParameter("limit"));
        int pageNumber = Integer.parseInt(request.getParameter("page"));
        //HttpSession session=request.getSession();
        String name = request.getParameter("name");
        Map params = new HashMap();
        params.put("name", name);
        PageHelper.startPage(pageNumber, pageSize);
        PageInfo<Warehouse> data = warehouseService.findByPage(params);
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
        String regionName = request.getParameter("regionName");
        String beginTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
        Map params = new HashMap();
        params.put("name", name);
        params.put("regionName", regionName);
        params.put("beginTime", beginTime);
        params.put("endTime", endTime);
        PageHelper.startPage(pageNumber, pageSize);
        PageInfo<Warehouse> data = warehouseService.findByPage2(params);
        TableData tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(data.getTotal());//设置总条数
        tableData.setData(data.getList());//设置当前的数据
        return tableData;
    }

    @RequestMapping("/addWarehouse")
    @ResponseBody
    public LayUIOperate addStorehouse(@RequestBody Warehouse warehouse, HttpServletRequest request){

        HttpSession session=request.getSession();
//        Emp emp=(Emp)session.getAttribute("emp");
//        emp.setId(1);
       warehouse.setUser(new Emp(3));
        LayUIOperate operate=new LayUIOperate();
        boolean f= warehouseService.addStorehouse(warehouse);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("添加成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("添加失败");
        }
        return operate;
    }
    @RequestMapping("/delWarehouse")
    @ResponseBody
    public LayUIOperate delStorehouse(Integer id){
        LayUIOperate operate=new LayUIOperate();
        boolean f= warehouseService.delStorehouse(id);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("删除成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("删除失败");
        }
        return operate;
    }
    @RequestMapping("/updateWarehouse")
    @ResponseBody
    public LayUIOperate updateStorehouse(@RequestBody Warehouse warehouse, HttpServletRequest request){
        LayUIOperate operate=new LayUIOperate();
        if("0".equals(warehouse.getStatus())) warehouse.setStatus("1");
        else warehouse.setStatus("0");
        boolean f= warehouseService.updateStorehouse(warehouse);
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
        warehouseService.getStorehouseById(id);
        return "storehouseList2";
    }
    @RequestMapping("/fastJson")
    @ResponseBody
    public Warehouse getFastJson(Warehouse Warehouse){
        return Warehouse;
    }
    @RequestMapping("/dateTest")
    public void dateTest(Warehouse Warehouse){
        System.out.println(Warehouse);
    }
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile photoSource, Warehouse Warehouse, HttpServletRequest request) throws IOException {
        String fileName=photoSource.getOriginalFilename();
        String fileType=photoSource.getContentType();
        System.out.println(Warehouse.id);
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
