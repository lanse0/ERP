package com.qf.sys.service;

import com.github.pagehelper.PageInfo;
import com.qf.sys.po.Emp;

import java.util.List;
import java.util.Map;

public interface EmpService {
    public Emp login(String userName);
    public PageInfo<Emp> getAllEmpByPage(Map params);
    public List<Emp> getEmpByRole(int roleId);//根据角色获取用户
    public boolean addEmp(Emp emp);//添加用户
    public boolean updEmp(Emp emp);//修改用户
    public boolean quitEmp(int id,String status);//离职
}
