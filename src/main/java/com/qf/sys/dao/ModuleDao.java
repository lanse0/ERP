package com.qf.sys.dao;

import com.qf.sys.po.Module;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleDao {
    public List<Module> getAllModuleByPage(@Param("moduleName") String moduleName);
    public List<Module> getSelect();//父模块下拉框
    public boolean addModule(Module module);
    public boolean updModule(Module module);
    public boolean updStatus(@Param("id") int id,@Param("status") String status );
    public List<Module> getAllModuleAndChile();
    public List<Module> getEmpModules(@Param("roleId") int roleId);//获取用户拥有权限的模块

}
