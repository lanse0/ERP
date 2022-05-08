package com.qf.storage.service.impl;

import com.github.pagehelper.PageInfo;
import com.qf.storage.dao.ExWarehouseDao;
import com.qf.storage.po.ExWarehouse;
import com.qf.storage.service.ExWarehouseService;
import com.qf.storage.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

@Service
public class ExWarehouseServiceImpl implements ExWarehouseService {
    @Autowired
    private ExWarehouseDao exWarehouseDao;
    @Override
    public PageInfo<ExWarehouse> findByPage(Map params) {
        List<ExWarehouse> storehouseList=exWarehouseDao.findByPage(params);
        PageInfo<ExWarehouse> pageInfo=new PageInfo<ExWarehouse>(storehouseList);
        return pageInfo;
    }

    @Override
    public boolean addStorehouse(ExWarehouse ExWarehouse) {
        return exWarehouseDao.addStorehouse(ExWarehouse);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delStorehouse(Integer id) {
        boolean b;
        try {
            b = exWarehouseDao.delStorehouse(id);
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
    public boolean updateStorehouse(ExWarehouse ExWarehouse) {
        return exWarehouseDao.updateStorehouse(ExWarehouse);
    }

    @Override
    public ExWarehouse getStorehouseById(int id) {
        return exWarehouseDao.getStorehouseById(id);
    }
}
