package com.qf.storage.po;

public class Stock {
    public int id; //库存id 主键自增
    public int storehouseId;//仓库id
    public int goodsId;//商品id
    public int firmId;//厂商id
    public int sum;//库房数量

    public Stock() {
    }

    public Stock(int id, int storehouseId, int goodsId, int firmId, int sum) {
        this.id = id;
        this.storehouseId = storehouseId;
        this.goodsId = goodsId;
        this.firmId = firmId;
        this.sum = sum;
    }

    public Stock(int storehouseId, int goodsId, int firmId, int sum) {
        this.storehouseId = storehouseId;
        this.goodsId = goodsId;
        this.firmId = firmId;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(int storehouseId) {
        this.storehouseId = storehouseId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getFirmId() {
        return firmId;
    }

    public void setFirmId(int firmId) {
        this.firmId = firmId;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", storehouseId=" + storehouseId +
                ", goodsId=" + goodsId +
                ", firmId=" + firmId +
                ", sum=" + sum +
                '}';
    }
}
