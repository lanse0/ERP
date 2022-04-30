package com.qf.storage.service;

import com.github.pagehelper.PageInfo;
import com.qf.storage.po.Storehouse;

import java.util.List;

public interface StorehouseService {
    public PageInfo<List<Storehouse>> findByPage(int pageNum,int pageSize);//分页查询仓库列表
    boolean addStorehouse(Storehouse storehouse);//添加仓库
    boolean delStorehouse(Integer id);//删除仓库
    boolean updateStorehouse(Storehouse storehouse);//修改仓库
    Storehouse getStorehouseById(int id);//根据id获取仓库信息
}
