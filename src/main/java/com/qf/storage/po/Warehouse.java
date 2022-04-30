package com.qf.storage.po;

import java.sql.Date;

public class Warehouse {
    public int id;//入库id 主键自增
    public int orderId;//订购单id
    public int userId;//入库人id
    public int storehouseId;//仓库id
    public String status;//入库状态
    public Date warehouseTime;//入库时间

    public Warehouse() {
    }

    public Warehouse(int id, int orderId, int userId, int storehouseId, String status, Date warehouseTime) {
        this.id = id;
        this.orderId = orderId;
        this.userId = userId;
        this.storehouseId = storehouseId;
        this.status = status;
        this.warehouseTime = warehouseTime;
    }

    public Warehouse(int orderId, int userId, int storehouseId, String status, Date warehouseTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.storehouseId = storehouseId;
        this.status = status;
        this.warehouseTime = warehouseTime;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(int storehouseId) {
        this.storehouseId = storehouseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getWarehouseTime() {
        return warehouseTime;
    }

    public void setWarehouseTime(Date warehouseTime) {
        this.warehouseTime = warehouseTime;
    }

    @Override
    public String toString() {
        return "ExWarehouse{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", storehouseId=" + storehouseId +
                ", status='" + status + '\'' +
                ", warehouseTime=" + warehouseTime +
                '}';
    }
}
