package com.qf.sys.service;

import com.github.pagehelper.PageInfo;
import com.qf.sys.po.Emp;

import java.util.List;
import java.util.Map;

public interface EmpService {
    public PageInfo<Emp> getAllEmpByPage(Map params);
}
