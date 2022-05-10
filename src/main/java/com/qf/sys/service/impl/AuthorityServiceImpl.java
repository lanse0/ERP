package com.qf.sys.service.impl;

import com.qf.sys.dao.AuthorityDao;
import com.qf.sys.po.Authority;
import com.qf.sys.service.AuthorityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * FileName: AuthorityServiceImpl
 * Author: HWang
 * Date:2022/5/10 20:26
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Resource
    private AuthorityDao authorityDao;

    @Override
    public List<Authority> getAllAuth() {
        return authorityDao.getAllAuth();
    }
}
