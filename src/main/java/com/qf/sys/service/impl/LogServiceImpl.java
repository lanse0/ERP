package com.qf.sys.service.impl;

import com.github.pagehelper.PageInfo;
import com.qf.sys.dao.LogDao;
import com.qf.sys.po.Emp;
import com.qf.sys.po.Log;
import com.qf.sys.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * FileName: LogServiceImpl
 * Author: HWang
 * Date:2022/5/13 13:35
 */
@Service
public class LogServiceImpl implements LogService {
    @Resource
    private LogDao logDao;
    @Override
    public PageInfo<Log> getAllLogByPage(Map params) {
        List<Log> logs = logDao.getAllLogByPage(params);
        PageInfo<Log> pageInfo = new PageInfo<Log>(logs);
        return pageInfo;
    }

    @Override
    public boolean add(Log log) {
        return logDao.add(log);
    }
}
