package com.qf.storage.po;

import java.sql.Date;

public class ExWarehouse {
    public int id;//出库id 主键自增
    public int orderId;//订购单id
    public int userId;//出库人id
    public int storehouseId;//仓库id
    public String status;//出库状态
    public Date exWarehouseTime;//出库时间

    public ExWarehouse() {
    }

    public ExWarehouse(int id, int orderId, int userId, int storehouseId, String status, Date exWarehouseTime) {
        this.id = id;
        this.orderId = orderId;
        this.userId = userId;
        this.storehouseId = storehouseId;
        this.status = status;
        this.exWarehouseTime = exWarehouseTime;
    }

    public ExWarehouse(int orderId, int userId, int storehouseId, String status, Date exWarehouseTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.storehouseId = storehouseId;
        this.status = status;
        this.exWarehouseTime = exWarehouseTime;
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

    public Date getExWarehouseTime() {
        return exWarehouseTime;
    }

    public void setExWarehouseTime(Date exWarehouseTime) {
        this.exWarehouseTime = exWarehouseTime;
    }

    @Override
    public String toString() {
        return "ExWarehouse{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", storehouseId=" + storehouseId +
                ", status='" + status + '\'' +
                ", exWarehouseTime=" + exWarehouseTime +
                '}';
    }
}
