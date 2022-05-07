package com.qf.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.qf.storage.utils.TableData;
import com.qf.sys.po.Department;
import com.qf.sys.po.Region;
import com.qf.sys.service.RegionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * FileName: RegionController
 * Author: HWang
 * Date:2022/5/7 0:46
 */
@Controller
@RequestMapping("/area")
public class RegionController {
    @Resource
    private RegionService regionService;

    @RequestMapping("/getCityByPId")//根据省份获取城市
    @ResponseBody
    public TableData getCityByPId(Integer id) throws IOException {
        List<Region> cityList = regionService.getCityByPId(id);
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(cityList.size());
        data.setData(cityList);
        return data;
    }
    @RequestMapping("/getProvince")//获取所有省份
    @ResponseBody
    public TableData getProvince(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Region> provinceList = regionService.getProvince();
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(provinceList.size());
        data.setData(provinceList);
        return data;
    }
}
