package com.qf.market.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.market.po.Customer;
import com.qf.market.service.CustomerService;

import com.qf.storage.utils.TableData;

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
 * Copyright (C),2017-2022
 * FileName: CustomerController
 * Author: cc
 * Date:2022/5/7 21:32
 */
@Controller
@RequestMapping("/market")
public class CustomerController {
    @Resource
    private CustomerService customerService;
    public void setCustomerService(CustomerService customerService){
        this.customerService=customerService;
    }
//查询客户信息
    @RequestMapping("/getAllCustomerList")
    @ResponseBody
    public TableData findByPage(HttpServletRequest request){
        int pageSize =Integer.parseInt(request.getParameter("limit"));
        int pageNumber = Integer.parseInt(request.getParameter("page"));

        String company = request.getParameter("company");
        String customerName = request.getParameter("customerName");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String status = request.getParameter("status");
        //模糊查询条件
        Map params = new HashMap();
        params.put("company",company);
        params.put("customerName",customerName);
       // params.put("deptName",deptName);
        params.put("status",status);
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo<Customer> data = customerService.findByCustomerPage(params);
        TableData tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(data.getTotal());//总记录数
        tableData.setData(data.getList());//设置当前数据

        return tableData;
    }

//添加客户信息
    @RequestMapping("/addCustomer")
    @ResponseBody
    public LayUIOperate addCustomer(@RequestBody Customer customer){
        LayUIOperate operate=new LayUIOperate();
        System.out.println("addCustomer -->"+customer);
        boolean f= customerService.addCustomer(customer);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("客户添加成功!");
        }else{
            operate.setSuccess(false);
            operate.setMessage("客户添加失败");
        }
        return operate;
    }
//修改客户信息
    @RequestMapping("/updateCustomer")
    @ResponseBody
    public LayUIOperate updateCustomer(@RequestBody Customer customer){
        LayUIOperate operate=new LayUIOperate();
        System.out.println("updateCustomer -->"+customer);

        boolean f= customerService.updateCustomer(customer);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("用户修改成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("用户修改失败");
        }
        return operate;
    }
//注销客户信息
    @RequestMapping("/delCustomer")
    @ResponseBody//离职
    public LayUIOperate delCustomer(Integer id){
        LayUIOperate operate=new LayUIOperate();
        boolean f= customerService.delCustomer(id);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("失败！");
        }
        return operate;
    }

    //分配客服人员
    @RequestMapping("/allocateCustomer")
    @ResponseBody
    public LayUIOperate allocateCustomer(@RequestBody Customer customer){
        LayUIOperate operate=new LayUIOperate();
        System.out.println("allocateCustomer -->"+customer);

        boolean f= customerService.allocateCustomer(customer);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("分配成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("分配失败");
        }
        return operate;
    }


    @RequestMapping("/getCustomerById")
    @ResponseBody
    public TableData getCustomerById(Integer id){
        Customer customerList = customerService.getCustomerById(id);
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(1);
        data.setData(customerList);
        return data;
    }
}
