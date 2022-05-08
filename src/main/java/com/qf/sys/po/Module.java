package com.qf.sys.po;

import java.util.Date;

/**
 * FileName: Module
 * Author: HWang
 * Date:2022/5/5 10:28
 */
public class Module {
    private int id;
    private String moduleName; //模块名称
    private Module parent;//父模块
    private String url;//地址
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String status;//状态

    public Module() {
    }

    public Module(String moduleName, Module parent, String url) {
        this.moduleName = moduleName;
        this.parent = parent;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                ", parent=" + parent +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Module getParent() {
        return parent;
    }

    public void setParent(Module parent) {
        this.parent = parent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
