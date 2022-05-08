package com.qf.sys.service.impl;

import com.github.pagehelper.PageInfo;
import com.qf.sys.dao.RegionDao;
import com.qf.sys.po.Region;
import com.qf.sys.service.RegionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * FileName: RegionServiceImpl
 * Author: HWang
 * Date:2022/5/7 0:45
 */
@Service
public class RegionServiceImpl implements RegionService {
    @Resource
    private RegionDao regionDao;

    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    @Override
    public List<Region> getCityByPId(int pId) {
        return regionDao.getCityByPId(pId);
    }

    @Override
    public List<Region> getProvince() {
        return regionDao.getProvince();
    }

    @Override
    public PageInfo<Region> getAllRegionByPage(Map params) {
        List<Region> regionList = regionDao.getAllRegionByPage(params);
        PageInfo<Region> pageInfo = new PageInfo<Region>(regionList);
        return pageInfo;
    }
}
