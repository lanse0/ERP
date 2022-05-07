package com.qf.sys.dao;

import com.qf.sys.po.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    public Emp login(String name);
    public List<Emp> getAllEmpByPage(Map params);
    public List<Emp> getEmpByRole(@Param("roleId") int roleId);//根据角色获取用户
}
