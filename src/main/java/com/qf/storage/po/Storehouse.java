package com.qf.storage.po;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Storehouse {
    public int id;//仓库id 主键自增
    public int userId;//创建者id
    public int masterId;//负责人id
    public int provinceId;//省id
    public int cityId;//市id
    public String address;//仓库地址
    public String name;//仓库名称
    public String tel;//仓库电话
    public String des;//仓库描述
    public String status;//仓库状态
    public Date createTime;//仓库创建时间

    public Storehouse() {
    }

    public Storehouse(int id, int userId, int masterId, int provinceId,int cityId, String address, String name, String tel, String des, String status, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.masterId = masterId;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.address = address;
        this.name = name;
        this.tel = tel;
        this.des = des;
        this.status = status;
        this.createTime = createTime;
    }

    public Storehouse(int userId, int masterId, int provinceId, String address, String name, String tel, String des, String status) {
        this.userId = userId;
        this.masterId = masterId;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.address = address;
        this.name = name;
        this.tel = tel;
        this.des = des;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
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

    @Override
    public String toString() {
        return "Storehouse{" +
                "id=" + id +
                ", userId=" + userId +
                ", masterId=" + masterId +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", des='" + des + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
