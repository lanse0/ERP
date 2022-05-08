package com.qf.storage.po;

import com.qf.sys.po.Emp;

import java.sql.Date;

public class ExWarehouse {
    public int id;//出库id 主键自增
    public int orderId;//订购单id
    public String status;//出库状态
    public Date ExWarehouseTime;//出库时间
    public Storehouse storehouse;
    public Emp user;

    public ExWarehouse() {
    }

    public String getUserName(){
        if(user!=null)  return user.getEmpName();
        return "";
    }
    public String getSName() {
        if(storehouse!=null) return storehouse.getName();
        return "";
    }
    public void setStorehouseId(int storehouseId) { this.storehouse=new Storehouse(storehouseId); }

    public Storehouse getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(Storehouse storehouse) {
        this.storehouse = storehouse;
    }

    public Emp getUser() {
        return user;
    }

    public void setUser(Emp user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getExWarehouseTime() {
        return ExWarehouseTime;
    }

    public void setExWarehouseTime(Date exWarehouseTime) {
        ExWarehouseTime = exWarehouseTime;
    }

    @Override
    public String toString() {
        return "ExWarehouse{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", status='" + status + '\'' +
                ", ExWarehouseTime=" + ExWarehouseTime +
                ", storehouse=" + storehouse +
                ", user=" + user +
                '}';
    }
}
