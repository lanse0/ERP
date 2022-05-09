package com.qf.sys.service;

import com.github.pagehelper.PageInfo;
import com.qf.sys.po.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public PageInfo<Department> getAllDeptByPage(Map params);

    public List<Department> getSelectDept();
    public List<Department> getDeptByRegion(int regionId);//根据区域获取部门
    public boolean addDept(Department dept); //添加部门
}
