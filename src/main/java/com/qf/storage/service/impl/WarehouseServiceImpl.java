package com.qf.storage.service.impl;

import com.github.pagehelper.PageInfo;
import com.qf.storage.dao.WarehouseDao;
import com.qf.storage.po.Warehouse;
import com.qf.storage.service.StockService;
import com.qf.storage.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseDao warehouseDao;
    @Override
    public PageInfo<Warehouse> findByPage(Map params) {
        List<Warehouse> storehouseList=warehouseDao.findByPage(params);
        PageInfo<Warehouse> pageInfo=new PageInfo<Warehouse>(storehouseList);
        return pageInfo;
    }

    @Override
    public boolean addStorehouse(Warehouse Warehouse) {
        return warehouseDao.addStorehouse(Warehouse);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delStorehouse(Integer id) {
        boolean b;
        try {
            b = warehouseDao.delStorehouse(id);
        } catch (Exception e) {
            b=false;
            System.out.println("删除操作撤销");
            //手工回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean updateStorehouse(Warehouse Warehouse) {
        return warehouseDao.updateStorehouse(Warehouse);
    }

    @Override
    public Warehouse getStorehouseById(int id) {
        return warehouseDao.getStorehouseById(id);
    }
}
