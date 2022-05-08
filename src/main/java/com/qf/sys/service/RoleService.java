package com.qf.sys.service;

import com.qf.sys.po.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getRoleByDept(int deptId);//根据部门获取职位
}
