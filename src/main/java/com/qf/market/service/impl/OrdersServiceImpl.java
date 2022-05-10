package com.qf.market.service.impl;

import com.github.pagehelper.PageInfo;
import com.qf.market.dao.OrdersDao;
import com.qf.market.po.Orders;
import com.qf.market.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C),2017-2022
 * FileName: OrdersServiceImpl
 * Author: cc
 * Date:2022/5/8 14:29
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    @Override
    public PageInfo<Orders> findByOrdersPage(Map params) {
        List<Orders> ordersList=ordersDao.findByOrdersPage(params);
        PageInfo<Orders> pageInfo=new PageInfo<Orders>(ordersList);
        return pageInfo;
    }

    @Override
    public boolean addOrders(Orders orders) {
        return ordersDao.addOrders(orders);
    }

    @Override
    public boolean delOrders(Integer id) {
        return ordersDao.delOrders(id);
    }

    @Override
    public boolean updateOrders(Orders orders) {
        return ordersDao.updateOrders(orders);
    }

    @Override
    public Orders getOrdersById(int id) {
        return ordersDao.getOrdersById(id);
    }
}
