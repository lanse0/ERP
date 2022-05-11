package com.qf.sys.service.impl;

import com.github.pagehelper.PageInfo;
import com.qf.sys.dao.RoleDao;
import com.qf.sys.po.Role;
import com.qf.sys.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public PageInfo<Role> getAllRoleByPage(Map params) {
        List<Role> roleList = roleDao.getAllRoleByPage(params);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    @Override
    public boolean addRole(Role role) {
        boolean f = true;
        try {
            f = roleDao.addRole(role);
        } catch (Exception e) {
            f = false;
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean updRole(Role role) {
        boolean f = true;
        try {
            f = roleDao.updRole(role);
        } catch (Exception e) {
            f = false;
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean updStatus(int id,String status) {
        boolean f = true;
        try {
            f = roleDao.updStatus(id,status);
        } catch (Exception e) {
            f = false;
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean delModuleList(int roleId) {
        boolean f = true;
        try {
            f = roleDao.delModuleList(roleId);
        } catch (Exception e) {
            f = false;
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean addModuleList(int roleId, int[] modules) {
        boolean f = true;
        try {
            f = roleDao.addModuleList(roleId,modules);
        } catch (Exception e) {
            f = false;
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public int[] getModuleArray(int roleId) {
        return roleDao.getModuleArray(roleId);
    }
}
