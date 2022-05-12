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

    public int bid;
    public String brand;
    public String brandType;
    public String brandModel;
    public String price;
    public String number;
    public String auditContext;

    public Orders(){}
    public Orders(int id){     this.id = id;}

    public Orders(String status, Date auditTime, String auditContext) {
        this.status = status;
        this.auditTime = auditTime;
        this.auditContext = auditContext;
    }

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

    public Orders(int id, String ordersNo, Customer customer, Date orderTime, String amount, String status, Emp emp, Date auditTime, int bid, String brand, String brandType, String brandModel, String price, String number) {
        this.id = id;
        this.ordersNo = ordersNo;
        this.customer = customer;
        this.orderTime = orderTime;
        this.amount = amount;
        this.status = status;
        this.emp = emp;
        this.auditTime = auditTime;
        this.bid = bid;
        this.brand = brand;
        this.brandType = brandType;
        this.brandModel = brandModel;
        this.price = price;
        this.number = number;
    }

    public Orders(String ordersNo, Customer customer, Date orderTime, String amount, String status, Emp emp, Date auditTime, int bid, String brand, String brandType, String brandModel, String price, String number) {
        this.ordersNo = ordersNo;
        this.customer = customer;
        this.orderTime = orderTime;
        this.amount = amount;
        this.status = status;
        this.emp = emp;
        this.auditTime = auditTime;

        this.bid = bid;
        this.brand = brand;
        this.brandType = brandType;
        this.brandModel = brandModel;
        this.price = price;
        this.number = number;
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

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrandType() {
        return brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }

    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAuditContext() {
        return auditContext;
    }

    public void setAuditContext(String auditContext) {
        this.auditContext = auditContext;
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
                ", bid=" + bid +
                ", brand='" + brand + '\'' +
                ", brandType='" + brandType + '\'' +
                ", brandModel='" + brandModel + '\'' +
                ", price='" + price + '\'' +
                ", number='" + number + '\'' +
                ", auditContext='" + auditContext + '\'' +
                '}';
    }
}