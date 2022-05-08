package com.qf.sys.service;

import com.qf.sys.po.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegionService {
    //获取省的所有城市
    public List<Region> getCityByPId(int pId);
    //获取所有省份
    public List<Region> getProvince();

}
