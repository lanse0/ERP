package com.qf.sys.service.impl;

import com.qf.sys.dao.RoleDao;
import com.qf.sys.po.Role;
import com.qf.sys.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * FileName: RoleServiceImpl
 * Author: HWang
 * Date:2022/5/7 16:33
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    @Override
    public List<Role> getRoleByDept(int deptId) {
        return roleDao.getRoleByDept(deptId);
    }
}
