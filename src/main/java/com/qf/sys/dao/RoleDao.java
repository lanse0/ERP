package com.qf.sys.dao;

import com.qf.sys.po.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    public List<Role> getRoleByDept(@Param("deptId") int deptId);
}
