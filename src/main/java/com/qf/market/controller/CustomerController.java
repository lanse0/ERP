package com.qf.market.controller;

import com.github.pagehelper.PageInfo;
import com.qf.market.dao.CustomerDao;
import com.qf.storage.po.Storehouse;
import com.qf.storage.utils.PageUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Copyright (C),2017-2022
 * FileName: CustomerController
 * Author: cc
 * Date:2022/5/7 21:32
 */
public class CustomerController {
    @RequestMapping("/findByCustomerPage")
    public String findByPage(PageUtils page, HttpServletRequest request){


        return "storage/market/customerList";
    }
}
