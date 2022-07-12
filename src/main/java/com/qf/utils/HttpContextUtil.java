package com.qf.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * FileName: HttpContextUtil
 * Author: HWang
 * Date:2022/6/11 0:13
 */
public class HttpContextUtil {

    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
