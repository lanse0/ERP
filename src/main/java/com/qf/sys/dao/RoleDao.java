package com.qf.sys.dao;

import com.qf.sys.po.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    public List<Role> getRoleByDept(@Param("deptId") int deptId);
    public List<Role> getAllRoleByPage(Map params);
    public boolean addRole(Role role);
    public boolean updRole(Role role);
    public boolean updStatus(@Param("id") int id,@Param("status") String status );

    //权限操作 添加权限先将该角色所有权限删除再一次性添加
    public boolean delModuleList(@Param("roleId")int roleId);
    public boolean addModuleList(@Param("roleId")int roleId,@Param("array") int[] modules);

    //获取角色拥有的权限
    public int[] getModuleArray(@Param("roleId")int roleId);
}
