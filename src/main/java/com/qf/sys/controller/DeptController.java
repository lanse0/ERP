package com.qf.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.qf.sys.po.Department;
import com.qf.sys.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public void getSelectDept(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Department> deptList = deptService.getSelectDept();
        PrintWriter out = response.getWriter();
        JSONObject jobj = new JSONObject();
        jobj.put("deptList",deptList);
        out.write(jobj.toJSONString());
        out.flush();
        out.close();
    }
}
