package com.qf.sys.service.impl;

import com.github.pagehelper.PageInfo;
import com.qf.sys.dao.ModuleDao;
import com.qf.sys.po.Module;
import com.qf.sys.service.ModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * FileName: ModuleServiceImpl
 * Author: HWang
 * Date:2022/5/9 15:53
 */
@Service
public class ModuleServiceImpl implements ModuleService {
    @Resource
    private ModuleDao moduleDao;

    @Override
    public PageInfo<Module> getAllModuleByPage(String moduleName) {
        List<Module> modules = moduleDao.getAllModuleByPage(moduleName);
        PageInfo<Module> pageInfo = new PageInfo<>(modules);
        return pageInfo;
    }

    @Override
    public List<Module> getSelect() {
        return moduleDao.getSelect();
    }

    @Override
    public boolean addModule(Module module) {
        boolean f = true;
        try {
            f = moduleDao.addModule(module);
        } catch (Exception e) {
            f = false;
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean updModule(Module module) {
        boolean f = true;
        try {
            f = moduleDao.updModule(module);
        } catch (Exception e) {
            f = false;
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean updStatus(int id) {
        boolean f = true;
        try {
            f = moduleDao.updStatus(id);
        } catch (Exception e) {
            f = false;
            e.printStackTrace();
        }
        return f;
    }
}
