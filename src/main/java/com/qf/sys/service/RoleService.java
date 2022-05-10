package com.qf.sys.service;

import com.github.pagehelper.PageInfo;
import com.qf.sys.po.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    public List<Role> getRoleByDept(int deptId);//根据部门获取职位
    public PageInfo<Role> getAllRoleByPage(Map params);

    public boolean addRole(Role role);
    public boolean updRole(Role role);
    public boolean updStatus(int id);
}
