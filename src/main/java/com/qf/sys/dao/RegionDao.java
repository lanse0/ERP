package com.qf.sys.dao;

import com.qf.sys.po.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegionDao {

    //获取省的所有城市
    public List<Region> getCityByPId(@Param("pId") int pId);
    //获取所有省份
    public List<Region> getProvince();
}
