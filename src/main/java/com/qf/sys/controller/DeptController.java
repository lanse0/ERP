package com.qf.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.qf.storage.utils.TableData;
import com.qf.sys.po.Department;
import com.qf.sys.service.DepartmentService;
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
 * FileName: DeptController
 * Author: HWang
 * Date:2022/5/6 23:59
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Resource
    private DepartmentService deptService;

    @RequestMapping("/getSelectDept")
    @ResponseBody
    public TableData getSelectDept(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<Department> deptList = deptService.getSelectDept();
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(deptList.size());
        data.setData(deptList);
        return data;
    }
}
