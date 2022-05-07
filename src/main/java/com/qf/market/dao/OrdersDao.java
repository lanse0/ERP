package com.qf.market.dao;


import com.qf.market.po.Orders;

import java.util.List;

/**
 * Copyright (C),2017-2022
 * FileName: OrdersDao
 * Author: cc
 * Date:2022/5/6 11:37
 */
public interface OrdersDao {
    List<Orders> findByPage();//分页查询订单列表
    boolean addOrders(Orders orders);//添加订单
    boolean delOrders(Integer id);//删除订单
    boolean updateOrders(Orders orders);//修改订单
    Orders getOrdersById(int id);//根据id获取订单信息
}
