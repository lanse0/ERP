package com.qf.market.po;

import com.qf.sys.po.Emp;

import java.util.Date;

/**
 * Copyright (C),2017-2022
 * FileName: Orders
 * Author: cc
 * Date:2022/5/6 11:10
 */
public class Orders {
    public int id;//订单序号
    public String ordersNo;//订单编号
    public Customer customer;//客户
    public Date orderTime;//订购时间
    public String amount;//订购金额
    public String status;//订单状态
    public Emp emp;//订单审核人员
    public Date auditTime;//订单创建时间

    public Orders(){}
    public Orders(int id){     this.id = id;}
    public Orders(int id, String ordersNo, Customer customer, Date orderTime, String amount, String status, String auditor, Date auditTime) {
        this.id = id;
        this.ordersNo = ordersNo;
        this.customer = customer;
        this.orderTime = orderTime;
        this.amount = amount;
        this.status = status;
        this.emp = emp;
        this.auditTime = auditTime;
    }

    public Orders(String ordersNo, Customer customer, Date orderTime, String amount, String status, Emp emp, Date auditTime) {
        this.ordersNo = ordersNo;
        this.customer = customer;
        this.orderTime = orderTime;
        this.amount = amount;
        this.status = status;
        this.emp = emp;
        this.auditTime = auditTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdersNo() {
        return ordersNo;
    }

    public void setOrdersNo(String ordersNo) {
        this.ordersNo = ordersNo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", ordersNo='" + ordersNo + '\'' +
                ", customer=" + customer +
                ", orderTime=" + orderTime +
                ", amount='" + amount + '\'' +
                ", status='" + status + '\'' +
                ", emp=" + emp +
                ", auditTime=" + auditTime +
                '}';
    }
}