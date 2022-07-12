package com.qf.sys.dao;

import com.qf.sys.po.Log;

import java.util.List;
import java.util.Map;

public interface LogDao {
    public List<Log> getAllLogByPage(Map params);

    public boolean add(Log log);//添加日志
}