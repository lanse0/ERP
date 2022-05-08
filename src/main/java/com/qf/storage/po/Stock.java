package com.qf.storage.po;

public class Stock {
    public int id; //库存id 主键自增
    public Storehouse storehouse;//仓库id
    public int goodsId;//商品id
    public int firmId;//厂商id
    public int sum;//库房数量

    public Stock() {
    }

    public Stock(int id, Storehouse storehouse, int goodsId, int firmId, int sum) {
        this.id = id;
        this.storehouse = storehouse;
        this.goodsId = goodsId;
        this.firmId = firmId;
        this.sum = sum;
    }

    public Stock(Storehouse storehouse, int goodsId, int firmId, int sum) {
        this.storehouse = storehouse;
        this.goodsId = goodsId;
        this.firmId = firmId;
        this.sum = sum;
    }
    public String getSName() {
        if(storehouse!=null) return storehouse.getName();
        return "";
       }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Storehouse getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(Storehouse storehouse) {
        this.storehouse = storehouse;
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
                ", storehouse=" + storehouse +
                ", goodsId=" + goodsId +
                ", firmId=" + firmId +
                ", sum=" + sum +
                '}';
    }
}
