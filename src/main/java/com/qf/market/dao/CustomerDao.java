package com.qf.market.dao;

import com.qf.market.po.Customer;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C),2017-2022
 * FileName: CustomerDao
 * Author: cc
 * Date:2022/5/6 12:22
 */
public interface CustomerDao {
    List<Customer> findByCustomerPage(Map params);//分页查询客户列表
    boolean addCustomer(Customer customer);//添加客户
    boolean delCustomer(Integer id);//删除客户
    boolean updateCustomer(Customer customer);//修改客户信息
    Customer getCustomerById(int id);//根据id获取客户信息
    boolean allocateCustomer(Customer customer);//分配客服人员
}
