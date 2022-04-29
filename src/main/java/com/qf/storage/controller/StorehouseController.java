package com.qf.storage.controller;

import com.github.pagehelper.PageInfo;
import com.qf.storage.po.Storehouse;
import com.qf.storage.service.StorehouseService;
import com.qf.storage.utils.PageUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/storehouse")
public class StorehouseController {
    @Autowired
    private StorehouseService storehouseService;

    @RequestMapping("/findByPage")
    public String findByPage(PageUtils page, HttpServletRequest request){
        PageInfo<List<Storehouse>> pageInfo= storehouseService.findByPage(page.getPageNum(),page.getPageSize());
        request.setAttribute("pageInfo",pageInfo);
        return "storage/storehouse/storehouseList";
    }

    @RequestMapping("/addStorehouse")
    public String addStorehouse(Storehouse storehouse){
        storehouseService.addStorehouse(storehouse);
        return "storage/storehouse/storehouseList";
    }
    @RequestMapping("/delStorehouse")
    public String delStorehouse(Integer id){
        storehouseService.delStorehouse(id);
        return "storage/storehouse/storehouseList";
    }
    @RequestMapping("/updateStorehouse")
    public String updateStorehouse(Storehouse storehouse){
        storehouseService.updateStorehouse(storehouse);
        return "storage/storehouse/storehouseList";
    }
    @RequestMapping("/getStorehouseById")
    public String getStorehouseById(int id){
        storehouseService.getStorehouseById(id);
        return "storage/storehouse/storehouseList";
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
