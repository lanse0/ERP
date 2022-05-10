package com.qf.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.storage.utils.TableData;
import com.qf.sys.po.Module;
import com.qf.sys.service.ModuleService;
import com.qf.utils.LayUIOperate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * FileName: ModuleController
 * Author: HWang
 * Date:2022/5/9 16:18
 */
@Controller
@RequestMapping("/modules")
public class ModuleController {
    @Resource
    private ModuleService moduleService;

    @RequestMapping("/getAllModulesList")
    @ResponseBody
    public TableData getAllModulesList(HttpServletRequest request){
        int pageSize =Integer.parseInt(request.getParameter("limit"));//每页大小
        int pageNumber = Integer.parseInt(request.getParameter("page"));//第几页

        String moduleName = request.getParameter("moduleName");
        PageInfo<Module> pageInfo = moduleService.getAllModuleByPage(moduleName);
        PageHelper.startPage(pageNumber,pageSize);
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(pageInfo.getTotal());
        data.setData(pageInfo.getList());
        return data;
    }
    @RequestMapping("/getSelect")//获取下拉框的父模块
    @ResponseBody
    public TableData getSelect(){
        List<Module> modules = moduleService.getSelect();
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(modules.size());
        data.setData(modules);
        return data;
    }
    @RequestMapping("/addModule")
    @ResponseBody
    public LayUIOperate addModule(@RequestBody Module module){
        LayUIOperate operate=new LayUIOperate();
        System.out.println("addModule -->"+module);
        boolean f= moduleService.addModule(module);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("成功！牛逼");
        }else{
            operate.setSuccess(false);
            operate.setMessage("失败");
        }
        return operate;
    }
    @RequestMapping("/updModule")
    @ResponseBody
    public LayUIOperate updModule(@RequestBody Module module){
        LayUIOperate operate=new LayUIOperate();
        System.out.println("updModule -->"+module);
        boolean f= moduleService.updModule(module);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("成功！牛逼");
        }else{
            operate.setSuccess(false);
            operate.setMessage("失败");
        }
        return operate;
    }
    @RequestMapping("/updStatus")
    @ResponseBody
    public LayUIOperate updStatus(Integer id,String status){
        LayUIOperate operate=new LayUIOperate();
        boolean f= moduleService.updStatus(id,status);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("成功！牛逼");
        }else{
            operate.setSuccess(false);
            operate.setMessage("失败");
        }
        return operate;
    }
}
