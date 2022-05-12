package com.qf.storage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.storage.dao.StorehouseDao;
import com.qf.storage.po.Storehouse;
import com.qf.storage.service.StorehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

@Service
public class StorehouseServiceImpl implements StorehouseService {
    @Autowired
    private StorehouseDao storehouseDao;
    @Override
    public PageInfo<Storehouse> findByPage(Map params) {
        List<Storehouse> storehouseList=storehouseDao.findByPage(params);
        PageInfo<Storehouse> pageInfo=new PageInfo<Storehouse>(storehouseList);
        return pageInfo;
    }

    @Override
    public boolean addStorehouse(Storehouse storehouse) {
        return storehouseDao.addStorehouse(storehouse);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delStorehouse(Integer id) {
        boolean b;
        try {
            b = storehouseDao.delStorehouse(id);
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
    public boolean updateStorehouse(Storehouse storehouse) {
        return storehouseDao.updateStorehouse(storehouse);
    }

    @Override
    public Storehouse getStorehouseById(int id) {
        return storehouseDao.getStorehouseById(id);
    }

    @Override
    public List<Storehouse> findAllStorehouse() { return storehouseDao.findAllStorehouse(); }

    @Override
    public List<Storehouse> getEchartsPie() {
        return storehouseDao.getEchartsPie();
    }
    @Override
    public List<Storehouse> getStorehouseByM(Integer id) {
        return storehouseDao.getStorehouseByM(id);
    }
}
