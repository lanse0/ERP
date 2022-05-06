package com.qf.sys.dao;

import com.qf.sys.po.Emp;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    public Emp login(String name);
    public List<Emp> getAllEmpByPage(Map params);
}
