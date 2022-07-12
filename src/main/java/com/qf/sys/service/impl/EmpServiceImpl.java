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

    @Override
    public Emp login(String userName) {
        return empDao.login(userName);
    }

    @Override
    public PageInfo<Emp> getAllEmpByPage(Map params) {
        List<Emp> empList = empDao.getAllEmpByPage(params);
        PageInfo<Emp> pageInfo = new PageInfo<Emp>(empList);
        return pageInfo;
    }

    @Override
    public List<Emp> getEmpByRole(int roleId) {//根据角色获取用户
        return empDao.getEmpByRole(roleId);
    }

    @Override
    public boolean addEmp(Emp emp) {
        boolean f;
        try {
            f = empDao.addEmp(emp);
        } catch (Exception e) {
            f = false;
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean updEmp(Emp emp) {
        boolean f;
        try {
            f = empDao.updEmp(emp);
        } catch (Exception e) {
            f = false;
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean quitEmp(int id, String status) {
        boolean f;
        try {
            f = empDao.quitEmp(id, status);
        } catch (Exception e) {
            f = false;
            e.printStackTrace();
        }
        return f;
    }
}
