package com.qf.sys.controller;

import com.qf.storage.utils.TableData;
import com.qf.sys.po.Role;
import com.qf.sys.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
}
