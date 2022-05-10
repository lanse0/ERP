package com.qf.market.service;

import com.github.pagehelper.PageInfo;
import com.qf.market.po.Orders;

import java.util.Map;

/**
 * Copyright (C),2017-2022
 * FileName: OrdersService
 * Author: cc
 * Date:2022/5/8 14:25
 */
public interface OrdersService {
    public PageInfo<Orders> findByOrdersPage(Map params);//分页查询订单列表
    boolean addOrders(Orders orders);//添加订单
    boolean delOrders(Integer id);//删除订单
    boolean updateOrders(Orders orders);//修改订单
    Orders getOrdersById(int id);//根据id获取订单信息
}
