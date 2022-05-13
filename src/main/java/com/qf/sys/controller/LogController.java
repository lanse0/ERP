package com.qf.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.storage.utils.TableData;
import com.qf.sys.po.Emp;
import com.qf.sys.po.Log;
import com.qf.sys.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName: LogController
 * Author: HWang
 * Date:2022/5/13 13:40
 */
@Controller
@RequestMapping("/log")
public class LogController {
    @Resource
    private LogService logService;

    @RequestMapping("/getAllLogList")
    @ResponseBody
    public TableData getAllLogList(HttpServletRequest request) {
        int pageNumber = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));

        String empNoStr = request.getParameter("empNo");
        int empNo = empNoStr != null && !"".equals(empNoStr) ? Integer.parseInt(empNoStr) : 0;
        String empName = request.getParameter("empName");
        String moduleName = request.getParameter("moduleName");
        String minTime = request.getParameter("minTime");
        String maxTime = request.getParameter("maxTime");
        //模糊查询条件
        Map params = new HashMap();
        params.put("empNo", empNo);
        params.put("empName", empName);
        params.put("moduleName", moduleName);
        params.put("minTime", minTime);
        params.put("maxTime", maxTime);

        PageHelper.startPage(pageNumber, pageSize);
        PageInfo<Log> data = logService.getAllLogByPage(params);
        TableData tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(data.getTotal());//总记录数
        tableData.setData(data.getList());//设置当前数据
        return tableData;
    }
}
