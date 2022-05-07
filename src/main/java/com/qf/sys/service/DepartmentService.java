package com.qf.sys.service;

import com.qf.sys.dao.DepartmentDao;
import com.qf.sys.po.Department;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    public List<Department> getSelectDept();

}
