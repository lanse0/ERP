package com.qf.market.service.impl;

import com.alibaba.druid.filter.AutoLoad;
import com.github.pagehelper.PageInfo;
import com.qf.market.dao.CustomerDao;
import com.qf.market.po.Customer;
import com.qf.market.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C),2017-2022
 * FileName: CustomerServiceImpl
 * Author: cc
 * Date:2022/5/8 14:37
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerDao customerDao;


    @Override
    public PageInfo<Customer> findByCustomerPage(Map params) {
        List<Customer> customerList=customerDao.findByCustomerPage(params);
        PageInfo<Customer> pageInfo=new PageInfo<>(customerList);
        return pageInfo;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    @Override
    public boolean delCustomer(Integer id) {
        return customerDao.delCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public boolean allocateCustomer(Customer customer) {
        return customerDao.allocateCustomer(customer);
    }
}
