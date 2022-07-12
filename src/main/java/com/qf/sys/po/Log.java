package com.qf.sys.po;

import java.util.Date;

/**
 * FileName: Log
 * Author: HWang
 * Date:2022/5/5 10:45
 */
public class Log {
    private int id;
    private Emp emp;//操作员工
    private Module module;//操作模块
    private String content;//日志内容
    private Date createTime=new Date();//创建时间
    private String status;

    public Log() {
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", emp=" + emp +
                ", module=" + module +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
