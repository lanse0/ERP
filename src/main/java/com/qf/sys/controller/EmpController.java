package com.qf.sys.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.storage.utils.TableData;
import com.qf.sys.po.Department;
import com.qf.sys.po.Emp;
import com.qf.sys.service.EmpService;
import com.qf.utils.LayUIOperate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: EmpController
 * Author: HWang
 * Date:2022/5/6 10:33
 */
@Controller
@RequestMapping("/users")
public class EmpController {
    @Resource
    private EmpService empService;

    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }

    @RequestMapping("/getAllEmpList")
    @ResponseBody
    public TableData getAllEmpList(HttpServletRequest request){
        int pageSize =Integer.parseInt(request.getParameter("limit"));
        int pageNumber = Integer.parseInt(request.getParameter("page"));

        String empNoStr = request.getParameter("empNo");
        int empNo = empNoStr!=null&&!"".equals(empNoStr)?Integer.parseInt(empNoStr):0;
        String empName = request.getParameter("empName");
        String deptName = request.getParameter("deptName");
        String status = request.getParameter("status");
        //模糊查询条件
        Map params = new HashMap();
        params.put("empNo",empNo);
        params.put("empName",empName);
        params.put("deptName",deptName);
        params.put("status",status);
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo<Emp> data = empService.getAllEmpByPage(params);
        TableData tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(data.getTotal());//总记录数
        tableData.setData(data.getList());//设置当前数据
        return tableData;
    }

    @RequestMapping("/getEmpByRoleId")
    @ResponseBody
    public TableData getEmpByRoleId(Integer roleId){
        List<Emp> empList = empService.getEmpByRole(roleId);
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(empList.size());
        data.setData(empList);
        return data;
    }

    @RequestMapping("/addEmp")
    @ResponseBody
    public LayUIOperate addEmp(@RequestBody Emp emp){
        LayUIOperate operate=new LayUIOperate();
        System.out.println("addEmp -->"+emp);
        boolean f= empService.addEmp(emp);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("用户添加成功！牛逼");
        }else{
            operate.setSuccess(false);
            operate.setMessage("用户添加失败");
        }
        return operate;
    }
}
