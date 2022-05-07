package com.qf.market.po;

import java.util.Date;

/**
 * Copyright (C),2017-2022
 * FileName: Customer
 * Author: cc
 * Date:2022/5/6 11:12
 */
public class Customer {
    public int id;//客户编号
    public String customerName;//客户姓名
    public String sex;//客户性别
    public String phone;//客户联系电话
    public String company;//客户所属公司
    public int regionId;//客户所属区域Id
    public String status;//客户状态
    public Date createTime;//客户创建时间
    public String creator;//创建人
    public Date allocateTime;//分配时间
    public String customerStaff;//客户服务人员

    public Customer(int id, String customerName, String sex, String phone, String company, int regionId, String status, Date createTime, String creator, Date allocateTime, String customerStaff) {
        this.id = id;
        this.customerName = customerName;
        this.sex = sex;
        this.phone = phone;
        this.company = company;
        this.regionId = regionId;
        this.status = status;
        this.createTime = createTime;
        this.creator = creator;
        this.allocateTime = allocateTime;
        this.customerStaff = customerStaff;
    }

    public Customer(String customerName, String sex, String phone, String company, int regionId, String status, Date createTime, String creator, Date allocateTime, String customerStaff) {
        this.customerName = customerName;
        this.sex = sex;
        this.phone = phone;
        this.company = company;
        this.regionId = regionId;
        this.status = status;
        this.createTime = createTime;
        this.creator = creator;
        this.allocateTime = allocateTime;
        this.customerStaff = customerStaff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getAllocateTime() {
        return allocateTime;
    }

    public void setAllocateTime(Date allocateTime) {
        this.allocateTime = allocateTime;
    }

    public String getCustomerStaff() {
        return customerStaff;
    }

    public void setCustomerStaff(String customerStaff) {
        this.customerStaff = customerStaff;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", regionId=" + regionId +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", allocateTime=" + allocateTime +
                ", customerStaff='" + customerStaff + '\'' +
                '}';
    }
}
