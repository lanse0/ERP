package com.qf.storage.service.impl;

import com.github.pagehelper.PageInfo;
import com.qf.storage.dao.StockDao;
import com.qf.storage.po.Stock;
import com.qf.storage.service.StockService;
import com.qf.storage.service.StorehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockDao stockDao;
    @Override
    public PageInfo<Stock> findByPage(Map params) {
        List<Stock> storehouseList=stockDao.findByPage(params);
        PageInfo<Stock> pageInfo=new PageInfo<Stock>(storehouseList);
        return pageInfo;
    }

    @Override
    public boolean addStorehouse(Stock Stock) {
        return stockDao.addStorehouse(Stock);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean delStorehouse(Integer id) {
        boolean b;
        try {
            b = stockDao.delStorehouse(id);
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
    public boolean updateStorehouse(Stock Stock) {
        return stockDao.updateStorehouse(Stock);
    }

    @Override
    public Stock getStorehouseById(int id) {
        return stockDao.getStorehouseById(id);
    }
}
