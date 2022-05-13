package com.qf.sys.service;

import com.github.pagehelper.PageInfo;
import com.qf.sys.po.Module;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleService {
    public PageInfo<Module> getAllModuleByPage(String moduleName);
    public List<Module> getSelect();//父模块下拉框
    public boolean addModule(Module module);
    public boolean updModule(Module module);
    public boolean updStatus(int id,String status);
    public List<Module> getAllModuleAndChile();
    public List<Module> getEmpModules(int roleId);
}
