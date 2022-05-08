package com.qf.storage.service;

import com.github.pagehelper.PageInfo;
import com.qf.storage.po.Stock;

import java.util.Map;

public interface StockService {
    public PageInfo<Stock> findByPage(Map params);//分页查询仓库列表
    boolean addStorehouse(Stock stock);//添加仓库
    boolean delStorehouse(Integer id);//删除仓库
    boolean updateStorehouse(Stock stock);//修改仓库
    Stock getStorehouseById(int id);//根据id获取仓库信息
}
