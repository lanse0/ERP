package com.qf.market.dao;

import com.qf.market.po.Customer;

import java.util.List;

/**
 * Copyright (C),2017-2022
 * FileName: CustomerDao
 * Author: cc
 * Date:2022/5/6 12:22
 */
public interface CustomerDao {
    List<Customer> findByPage();//分页查询客户列表
    boolean addCustomer(Customer customer);//添加客户
    boolean delCustomer(Integer id);//删除客户
    boolean updateCustomer(Customer customer);//修改客户信息
    Customer getCustomerById(int id);//根据id获取客户信息
}
