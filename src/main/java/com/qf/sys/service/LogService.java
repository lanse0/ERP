package com.qf.sys.service;

import com.github.pagehelper.PageInfo;
import com.qf.sys.po.Log;

import java.util.Map;

public interface LogService {
    public PageInfo<Log> getAllLogByPage(Map params);

    public boolean add(Log log);//添加日志
}
