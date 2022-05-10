package com.qf.market.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.market.po.Orders;
import com.qf.market.service.OrdersService;
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
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private OrdersService ordersService;
    //查询订单信息
    @RequestMapping("/findByOrdersPage")
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
        PageInfo<Orders> data = ordersService.findByOrdersPage(params);
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
    public LayUIOperate addCustomer(@RequestBody Orders Orders){
        LayUIOperate operate=new LayUIOperate();
        System.out.println("addCustomer -->"+Orders);
        boolean f= ordersService.addOrders(Orders);
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
    public LayUIOperate updateCustomer(@RequestBody Orders Orders){
        LayUIOperate operate=new LayUIOperate();
        System.out.println("updateCustomer -->"+Orders);

        boolean f= ordersService.updateOrders(Orders);
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
        boolean f= ordersService.delOrders(id);
        if(f){
            operate.setSuccess(true);
            operate.setMessage("成功！");
        }else{
            operate.setSuccess(false);
            operate.setMessage("失败！");
        }
        return operate;
    }

    @RequestMapping("/getCustomerById")
    @ResponseBody
    public TableData getCustomerById(Integer id){
        Orders customerList = ordersService.getOrdersById(id);
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(1);
        data.setData(customerList);
        return data;
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public TableData getAll(){
        List<Orders> customerList = ordersService.getAll();
        TableData data = new TableData();
        data.setCode(0);
        data.setCount(1);
        data.setData(customerList);
        return data;
    }
}
