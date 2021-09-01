package com.hp.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AdminInfo {
    private String adminName;
    private String adminPwd;
    private String adminPwdR;
    //因为前端传过来的参数是个字符串   所以这里要 做个类型转换
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date adminTime;
    private String adminSex;
    private String adminCity;
    private String open;
    private String hobby;

    @Override
    public String toString() {
        return "AdminInfo{" +
                "adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminPwdR='" + adminPwdR + '\'' +
                ", adminTime=" + adminTime +
                ", adminSex='" + adminSex + '\'' +
                ", adminCity='" + adminCity + '\'' +
                ", open='" + open + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminPwdR() {
        return adminPwdR;
    }

    public void setAdminPwdR(String adminPwdR) {
        this.adminPwdR = adminPwdR;
    }

    public Date getAdminTime() {
        return adminTime;
    }

    public void setAdminTime(Date adminTime) {
        this.adminTime = adminTime;
    }

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex;
    }

    public String getAdminCity() {
        return adminCity;
    }

    public void setAdminCity(String adminCity) {
        this.adminCity = adminCity;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
