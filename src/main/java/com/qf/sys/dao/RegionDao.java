package com.qf.sys.dao;

import com.qf.sys.po.Emp;
import com.qf.sys.po.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RegionDao {

    List<Region> getAllRegionByPage(Map params);
    //获取省的所有城市
    public List<Region> getCityByPId(@Param("pId") int pId);
    //获取所有省份
    public List<Region> getProvince();
}
