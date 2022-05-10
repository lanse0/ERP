package com.qf.market.service;

import com.github.pagehelper.PageInfo;
import com.qf.market.po.Customer;

import java.util.List;
import java.util.Map;


public interface CustomerService {
    public PageInfo<Customer> findByCustomerPage(Map params);//分页查询客户列表
    boolean addCustomer(Customer customer);//添加客户
    boolean delCustomer(Integer id);//删除客户
    boolean updateCustomer(Customer customer);//修改客户信息
    Customer getCustomerById(int id);//根据id获取客户信息
    boolean allocateCustomer(Customer customer);//分配客服人员
}
