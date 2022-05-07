package com.qf.sys.dao;

import com.qf.sys.po.Department;

import java.util.List;

/**
 * FileName: DepartmentDao
 * Author: HWang
 * Date:2022/5/6 23:33
 */
public interface DepartmentDao {
    public List<Department> getSelectDept();//获取下拉框数据
    public List<Department> getDeptByRegion(int regionId);//根据地区获取部门
}
