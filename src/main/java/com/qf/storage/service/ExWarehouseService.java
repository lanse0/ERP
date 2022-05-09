package com.qf.storage.service;

import com.github.pagehelper.PageInfo;
import com.qf.storage.po.ExWarehouse;
import com.qf.storage.po.Warehouse;

import java.util.Map;

public interface ExWarehouseService {
    public PageInfo<ExWarehouse> findByPage(Map params);//分页查询仓库列表
    boolean addStorehouse(ExWarehouse exWarehouse);//添加仓库
    boolean delStorehouse(Integer id);//删除仓库
    boolean updateStorehouse(ExWarehouse exWarehouse);//修改仓库
    ExWarehouse getStorehouseById(int id);//根据id获取仓库信息
    public PageInfo<ExWarehouse> findByPage2(Map params);//分页查询入库信息

}
