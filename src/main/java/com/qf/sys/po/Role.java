package com.qf.sys.po;

import java.util.Date;
import java.util.List;

/**
 * FileName: Role
 * Author: HWang
 * Date:2022/5/5 10:25
 * 角色(职位)
 */
public class Role {
    private int id;
    private String roleName;//职位名称
    private Department department; //所属部门
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String status;//状态
    private List<Module> moduleList; //角色拥有权限的模块

    public Role() {
    }

    public Role(int id) {
        this.id = id;
    }

    public Role(String roleName, Department department) {
        this.roleName = roleName;
        this.department = department;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", department=" + department +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status='" + status + '\'' +
                ", moduleList=" + moduleList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
