package com.qf.sys.po;

import java.util.Date;

/**
 * FileName: Department
 * Author: HWang
 * Date:2022/5/5 10:18
 */
public class Department {
    private int id;
    private String deptNo;//部门编号
    private String deptName;//部门名称
    private Region region;//部门所在地区
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String status;//状态

    public Department() {
    }

    public Department(String deptNo, String deptName, Region region, Date createTime, Date updateTime) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.region = region;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptNo='" + deptNo + '\'' +
                ", deptName='" + deptName + '\'' +
                ", region=" + region +
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

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
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
