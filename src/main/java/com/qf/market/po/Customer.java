package com.qf.market.po;

import com.qf.sys.po.Emp;
import com.qf.sys.po.Region;

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
    public Region region;//客户所属区域
    public String status;//客户状态
    public Date createTime;//客户创建时间
    public String creator;//创建人
    public Date allocateTime;//分配时间
    public Emp emp;//客户服务人员
    public String description;//描述
    public String address;//详细地址

    public Customer() {
    }

    public Customer(int id, String customerName, String sex, String phone, String company, Region region, String status, Date createTime, String creator, Date allocateTime, Emp emp) {
        this.id = id;
        this.customerName = customerName;
        this.sex = sex;
        this.phone = phone;
        this.company = company;
        this.region = region;
        this.status = status;
        this.createTime = createTime;
        this.creator = creator;
        this.allocateTime = allocateTime;
        this.emp = emp;
    }

    public Customer(String customerName, String sex, String phone, String company, Region region, String status, Date createTime, String creator, Date allocateTime, Emp emp) {
        this.customerName = customerName;
        this.sex = sex;
        this.phone = phone;
        this.company = company;
        this.region = region;
        this.status = status;
        this.createTime = createTime;
        this.creator = creator;
        this.allocateTime = allocateTime;
        this.emp = emp;
    }

    public Customer(int id, String customerName, String sex, String phone, String company, Region region, String status, Date createTime, String creator, Date allocateTime, Emp emp, String description, String address) {
        this.id = id;
        this.customerName = customerName;
        this.sex = sex;
        this.phone = phone;
        this.company = company;
        this.region = region;
        this.status = status;
        this.createTime = createTime;
        this.creator = creator;
        this.allocateTime = allocateTime;
        this.emp = emp;
        this.description = description;
        this.address = address;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
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

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", region=" + region +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", allocateTime=" + allocateTime +
                ", emp=" + emp +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
