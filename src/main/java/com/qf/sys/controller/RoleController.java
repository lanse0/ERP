package com.qf.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.storage.utils.TableData;
import com.qf.sys.po.Role;
import com.qf.sys.service.RoleService;
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
 * FileName: RoleController
 * Author: HWang
 * Date:2022/5/7 16:36
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @RequestMapping("/getAllRoleList")
    @ResponseBody
    public TableData getAllRoleList(HttpServletRequest request){
        int pageSize =Integer.parseInt(request.getParameter("limit"));
        int pageNumber = Integer.parseInt(request.getParameter("page"));

        String roleName = request.getParameter("roleName");
        String deptNo = request.getParameter("deptNo");
        Map params = new HashMap();
        params.put("roleName",roleName);
        params.put("deptNo",deptNo);
        PageInfo<Role> pageInfo = roleService.getAllRoleByPage(params);
        PageHelper.startPage(pageNumber,pageSize);
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(pageInfo.getTotal());
        data.setData(pageInfo.getList());
        return data;
    }

    @RequestMapping("/getRoleByDept")
    @ResponseBody
    public TableData getRoleByDept(Integer deptId){
        List<Role> roleList = roleService.getRoleByDept(deptId);
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(roleList.size());
        data.setData(roleList);
        return data;
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public LayUIOperate addRole(@RequestBody Role role){
        LayUIOperate operate = new LayUIOperate();
        System.out.println("addDept-->" + role);
        boolean f = roleService.addRole(role);
        if (f){
            operate.setSuccess(true);
            operate.setMessage("添加成功!");
        }else {
            operate.setSuccess(false);
            operate.setMessage("添加失败!");
        }
        return operate;
    }

    @RequestMapping("/updRole")
    @ResponseBody
    public LayUIOperate updRole(@RequestBody Role role){
        LayUIOperate operate = new LayUIOperate();
        System.out.println("updDept-->" + role);
        boolean f = roleService.updRole(role);
        if (f){
            operate.setSuccess(true);
            operate.setMessage("添加成功!");
        }else {
            operate.setSuccess(false);
            operate.setMessage("添加失败!");
        }
        return operate;
    }
    @RequestMapping("/updStatus")
    @ResponseBody
    public LayUIOperate updStatus(Integer id){
        LayUIOperate operate = new LayUIOperate();
        System.out.println("updStatus-->" + id);
        boolean f = roleService.updStatus(id);
        if (f){
            operate.setSuccess(true);
            operate.setMessage("成功!");
        }else {
            operate.setSuccess(false);
            operate.setMessage("错误!");
        }
        return operate;
    }
}
