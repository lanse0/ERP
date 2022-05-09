package com.qf.storage.dao;

import com.qf.storage.po.ExWarehouse;
import com.qf.storage.po.Warehouse;

import java.util.List;
import java.util.Map;

public interface ExWarehouseDao {
    List<ExWarehouse> findByPage(Map params);//分页查询仓库列表
    boolean addStorehouse(ExWarehouse exWarehouse);//添加仓库
    boolean delStorehouse(Integer id);//删除仓库
    boolean updateStorehouse(ExWarehouse exWarehouse);//修改仓库
    ExWarehouse getStorehouseById(int id);//根据id获取仓库信息
    List<ExWarehouse> findByPage2(Map params);//分页查询仓库列表
}
