package com.qf.storage.po;

import com.qf.market.po.Orders;
import com.qf.sys.po.Emp;

import java.sql.Date;

public class ExWarehouse {
    public int id;//出库id 主键自增
    public Orders orders;//订购单id
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
    public String getOrderNo() {
        if(orders!=null) return orders.getOrdersNo();
        return "";
    }
    public String getAmount() {
        if(orders!=null) return orders.getAmount();
        return "";
    }
    public int getSId() {
        if(storehouse!=null) return storehouse.getId();
        return 0;
    }
    public String getRegionName() {
        if(storehouse!=null)
        { if(storehouse.region!=null) return storehouse.region.getRegionName();}
        return "";
    }
    public void setStorehouseId(int storehouseId) { this.storehouse=new Storehouse(storehouseId); }

    public Storehouse getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(Storehouse storehouse) {
        this.storehouse = storehouse;
    }

    public Orders getOrders() { return orders; }

    public void setOrders(Orders orders) { this.orders = orders; }

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
                ", orders=" + orders +
                ", status='" + status + '\'' +
                ", ExWarehouseTime=" + ExWarehouseTime +
                ", storehouse=" + storehouse +
                ", user=" + user +
                '}';
    }
}
