package com.qf.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/getAllRegionList")
    @ResponseBody
    public TableData getAllRegionList(HttpServletRequest request){
        int pageSize =Integer.parseInt(request.getParameter("limit"));
        int pageNumber = Integer.parseInt(request.getParameter("page"));

        String provinceName = request.getParameter("provinceName");
        String cityName = request.getParameter("cityName");
        Map params = new HashMap();
        params.put("provinceName",provinceName);
        params.put("cityName",cityName);
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo<Region> data = regionService.getAllRegionByPage(params);
        TableData tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(data.getTotal());//总记录数
        tableData.setData(data.getList());//设置当前数据
        return tableData;
    }

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
