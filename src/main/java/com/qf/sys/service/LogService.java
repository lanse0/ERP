package com.qf.sys.service;

import com.github.pagehelper.PageInfo;
import com.qf.sys.po.Emp;
import com.qf.sys.po.Log;

import java.util.List;
import java.util.Map;

public interface LogService {
    public PageInfo<Log> getAllLogByPage(Map params);
}
