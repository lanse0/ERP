package com.qf.sys.service.impl;

import com.github.pagehelper.PageInfo;
import com.qf.sys.dao.DepartmentDao;
import com.qf.sys.po.Department;
import com.qf.sys.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * FileName: DepartmentServiceImpl
 * Author: HWang
 * Date:2022/5/6 23:54
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao deptDao;

    @Override
    public PageInfo<Department> getAllDeptByPage(Map params) {
        List<Department> departments = deptDao.getAllDeptByPage(params);
        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        return pageInfo;
    }

    @Override
    //获取下拉框数据
    public List<Department> getSelectDept() {
        return deptDao.getSelectDept();
    }

    @Override
    public List<Department> getDeptByRegion(int regionId) {
        return deptDao.getDeptByRegion(regionId);
    }

    @Override
    public boolean addDept(Department dept) {
        boolean f;
        try {
            f = deptDao.addDept(dept);
        } catch (Exception e) {
            f = false;
            e.printStackTrace();
        }
        return f;
    }
}
