package com.qf.storage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.storage.po.Storehouse;
import com.qf.storage.service.StorehouseService;
import com.qf.storage.utils.PageUtils;
import com.qf.storage.utils.TableData;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

        String _id = request.getParameter("id");
        int id = 0;
        if (_id != null && !"".equals(_id)) {
            id = Integer.parseInt(_id);
        }
        String name = request.getParameter("name");

        Map params = new HashMap();
        params.put("id", id);
        params.put("name", name);
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
    public String addStorehouse(Storehouse storehouse){
        storehouseService.addStorehouse(storehouse);
        return "storehouseList2";
    }
    @RequestMapping("/delStorehouse")
    public String delStorehouse(Integer id){
        storehouseService.delStorehouse(id);
        return "storehouseList2";
    }
    @RequestMapping("/updateStorehouse")
    public String updateStorehouse(Storehouse storehouse){
        storehouseService.updateStorehouse(storehouse);
        return "storehouseList2";
    }
    @RequestMapping("/getStorehouseById")
    public String getStorehouseById(int id){
        storehouseService.getStorehouseById(id);
        return "storehouseList2";
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
