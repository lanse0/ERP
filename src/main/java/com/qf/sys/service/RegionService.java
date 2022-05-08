package com.qf.sys.service;

import com.github.pagehelper.PageInfo;
import com.qf.sys.po.Emp;
import com.qf.sys.po.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RegionService {
    //获取省的所有城市
    public List<Region> getCityByPId(int pId);
    //获取所有省份
    public List<Region> getProvince();
    //分页模糊查询区域
    public PageInfo<Region> getAllRegionByPage(Map params);
}
