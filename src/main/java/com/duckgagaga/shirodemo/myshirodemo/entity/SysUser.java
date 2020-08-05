package com.duckgagaga.shirodemo.myshirodemo.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable {
    private Long id;

    private String userName;

    private String passWord;

    private String phone;

    private String realName;

    private String sex;

    private Integer age;

    private Date registerTime;

    private Date updateDataTime;

    private Long creatorId;

    private String email;

    private Integer deleted;

    private Integer code;

    private static final long serialVersionUID = 1L;

    public SysUser(Long id, String userName, String passWord, String phone, String realName, String sex, Integer age, Date registerTime, Date updateDataTime, Long creatorId, String email, Integer deleted, Integer code) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.realName = realName;
        this.sex = sex;
        this.age = age;
        this.registerTime = registerTime;
        this.updateDataTime = updateDataTime;
        this.creatorId = creatorId;
        this.email = email;
        this.deleted = deleted;
        this.code = code;
    }

    public SysUser() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getUpdateDataTime() {
        return updateDataTime;
    }

    public void setUpdateDataTime(Date updateDataTime) {
        this.updateDataTime = updateDataTime;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", registerTime=" + registerTime +
                ", updateDataTime=" + updateDataTime +
                ", creatorId=" + creatorId +
                ", email='" + email + '\'' +
                ", deleted=" + deleted +
                ", code=" + code +
                '}';
    }
}