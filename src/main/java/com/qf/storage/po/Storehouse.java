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

    public Storehouse() {
    }

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
    public String getMasterName() {
        return master.getEmpName();
    }
    public String getUserName() {
        return user.getEmpName();
    }
    public String getRegionName() {
        return region.getRegionName();
    }
    public int getRegionId() { return region.getId(); }
    public int getMasterId() { return master.getId(); }
    public int getParentId() {return region.getParentId();}
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
                '}';
    }
}
