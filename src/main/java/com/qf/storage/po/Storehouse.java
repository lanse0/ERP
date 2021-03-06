package com.qf.storage.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.qf.sys.po.Emp;
import com.qf.sys.po.Region;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Storehouse {
    public int id;//仓库id 主键自增
    Emp user;  //用户表1 创建人
    Emp master;//用户表  负责人
    Region region;// 区域表
    public String address;//仓库地址
    public String name;//仓库名称
    public String tel;//仓库电话
    public String des;//仓库描述
    public String status;//仓库状态
    public Date createTime;//仓库创建时间
    int value;

    public Storehouse() {
    }
    public Storehouse(int id) {this.id = id; }
    public Storehouse(int id, Emp user, Emp master, Region region, String address, String name, String tel, String des, String status, Date createTime) {
        this.id = id;
        this.user = user;
        this.master = master;
        this.region = region;
        this.address = address;
        this.name = name;
        this.tel = tel;
        this.des = des;
        this.status = status;
        this.createTime = createTime;
    }

    public Storehouse(Emp user, Emp master, Region region, String address, String name, String tel, String des, String status, Date createTime) {
        this.user = user;
        this.master = master;
        this.region = region;
        this.address = address;
        this.name = name;
        this.tel = tel;
        this.des = des;
        this.status = status;
        this.createTime = createTime;
    }
    //数据库返回参数
    public String getMasterName(){
        if(master!=null)   return master.getEmpName();
        return "";
    }
    public String getUserName(){
        if(user!=null)  return user.getEmpName();
        return "";
    }
    public String getRegionName(){
        if(region!=null)    return region.getRegionName();
        return "";
    }
    public int getRegionId(){
        if(region!=null)  return region.getId();
        return 0;
    }
    public int getMasterId(){
        if(master!=null) return master.getId();
         return 0;}
    public int getParentId(){
        if(region!=null) return region.getParentId();
        return 0;}
    //传入参数给控制层
    public void setRegionId(int regionId) { this.region=new Region(regionId); }
    public void setMasterId(int masterId) { this.master=new Emp(masterId); }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Emp getUser() {
        return user;
    }

    public void setUser(Emp user) {
        this.user = user;
    }

    public Emp getMaster() {
        return master;
    }

    public void setMaster(Emp master) {
        this.master = master;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
                ", user=" + user +
                ", master=" + master +
                ", region=" + region +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", des='" + des + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", value=" + value +
                '}';
    }
}
