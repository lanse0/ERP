package com.qf.sys.service.impl;

import com.github.pagehelper.PageInfo;
import com.qf.sys.dao.EmpDao;
import com.qf.sys.po.Emp;
import com.qf.sys.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * FileName: EmpServiceImpl
 * Author: HWang
 * Date:2022/5/6 11:30
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Resource //自动按照类型和名称注入
    private EmpDao empDao;

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    @Override
    public PageInfo<Emp> getAllEmpByPage(Map params) {
        List<Emp> empList = empDao.getAllEmpByPage(params);
        PageInfo<Emp> pageInfo = new PageInfo<Emp>(empList);
        return pageInfo;
    }
}
