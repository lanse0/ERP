package com.qf.sys.dao;

import com.qf.sys.po.Emp;
import com.qf.sys.po.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    public List<Role> getRoleByDept(@Param("deptId") int deptId);
    public List<Role> getAllRoleByPage(Map params);
    public boolean addRole(Role role);
    public boolean updRole(Role role);
    public boolean updStatus(@Param("id") int id);
}
