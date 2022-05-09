package com.qf.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.storage.utils.TableData;
import com.qf.sys.po.Department;
import com.qf.sys.service.DepartmentService;
import com.qf.utils.LayUIOperate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: DeptController
 * Author: HWang
 * Date:2022/5/6 23:59
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Resource
    private DepartmentService deptService;

    @RequestMapping("/getAllDeptList")
    @ResponseBody
    public TableData getAllDeptList(HttpServletRequest request){
        int pageSize =Integer.parseInt(request.getParameter("limit"));
        int pageNumber = Integer.parseInt(request.getParameter("page"));

        String deptName = request.getParameter("deptName");
        String provinceId = request.getParameter("provinceId");
        String cityId = request.getParameter("cityId");
        //若城市不为空直接按城市搜索部门
        String regionId = cityId!=null&&!"".equals(cityId)?cityId:provinceId;
        Map params = new HashMap();
        params.put("deptName",deptName);
        params.put("regionId",regionId);
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo<Department> pageInfo = deptService.getAllDeptByPage(params);
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(pageInfo.getTotal());
        data.setData(pageInfo.getList());
        return data;

    }@RequestMapping("/getSelectDept")
    @ResponseBody
    public TableData getSelectDept(){
        List<Department> deptList = deptService.getSelectDept();
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(deptList.size());
        data.setData(deptList);
        return data;
    }
    @RequestMapping("/getDeptByRegion")
    @ResponseBody
    public TableData getDeptByRegion(Integer regionId) {
        List<Department> deptList = deptService.getDeptByRegion(regionId);
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(deptList.size());
        data.setData(deptList);
        return data;
    }
    @RequestMapping("/addDept")
    @ResponseBody
    public LayUIOperate addDept(@RequestBody Department dept){
        LayUIOperate operate = new LayUIOperate();
        System.out.println("addDept-->" + dept);
        boolean f = deptService.addDept(dept);
        if (f){
            operate.setSuccess(true);
            operate.setMessage("部门添加成功!");
        }else {
            operate.setSuccess(false);
            operate.setMessage("部门添加失败!");
        }
        return operate;
    }
}
