package com.qf.storage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright (C),2017-2022
 * FileName: TestController
 * Author: cc
 * Date:2022/5/6 18:59
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String test(){
        return "market/customer/customerAdd";
    }
}
