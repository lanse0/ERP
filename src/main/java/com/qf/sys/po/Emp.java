package com.qf.sys.po;

import java.util.Date;

/**
 * FileName: Emp
 * Author: HWang
 * Date:2022/5/4 20:53
 */
public class Emp {
    private int id;
    private int empNo;//员工编号
    private String empName;//员工姓名
    private String userName;//用户名 用于登陆
    private String password;//密码
    private String phone;//手机号
    private Department dept;//所属部门
    private Role role;//职位（角色）
    private String sex;
    private Date birthDay;
    private Date hireDate;//入职日期
    private Date termDate;//离职日期
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String status;//状态

    public Emp() {
    }

    public String getDeptName() {
        return dept.getDeptName();
    }

    public String getRoleName() {
        return role.getRoleName();
    }

    public String getSex() {
        if (sex.equals("1")){
            return "男";
        }
        return "女";
    }

    public int getAge() {
        int age=0;
        try {
            age = new Date().getYear()-birthDay.getYear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return age;
    }

    public String getStatus() {
        if (status.equals("1")){
            return "在职";
        }
        return "离职";
    }
    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", dept=" + dept +
                ", role=" + role +
                ", sex='" + sex + '\'' +
                ", birthDay=" + birthDay +
                ", hireDate=" + hireDate +
                ", termDate=" + termDate +
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

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getTermDate() {
        return termDate;
    }

    public void setTermDate(Date termDate) {
        this.termDate = termDate;
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

    public void setStatus(String status) {
        this.status = status;
    }
}
