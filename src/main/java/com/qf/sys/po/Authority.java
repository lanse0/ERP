package com.qf.sys.po;

/**
 * FileName: authority
 * Author: HWang
 * Date:2022/5/5 10:30
 * 权限
 */
public class Authority {
    private int roleId;
    private int moduleId;

    public Authority() {
    }

    public Authority(int roleId, int moduleId) {
        this.roleId = roleId;
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "roleId=" + roleId +
                ", moduleId=" + moduleId +
                '}';
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }
}
