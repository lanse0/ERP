package com.qf.storage.service;

import com.github.pagehelper.PageInfo;
import com.qf.storage.po.Storehouse;
import com.qf.storage.po.Warehouse;

import java.util.List;
import java.util.Map;

public interface WarehouseService {
    public PageInfo<Warehouse> findByPage(Map params);//分页查询仓库列表
    boolean addStorehouse(Warehouse warehouse);//添加仓库
    boolean delStorehouse(Integer id);//删除仓库
    boolean updateStorehouse(Warehouse warehouse);//修改仓库
    Warehouse getStorehouseById(int id);//根据id获取仓库信息
    public PageInfo<Warehouse> findByPage2(Map params);//分页查询入库信息
}
