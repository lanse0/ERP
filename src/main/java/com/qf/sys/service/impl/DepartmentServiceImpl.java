package com.qf.sys.service.impl;

import com.qf.sys.dao.DepartmentDao;
import com.qf.sys.po.Department;
import com.qf.sys.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    //获取下拉框数据
    public List<Department> getSelectDept() {
        List<Department> departmentList = deptDao.getSelectDept();
        return departmentList;
    }
}
