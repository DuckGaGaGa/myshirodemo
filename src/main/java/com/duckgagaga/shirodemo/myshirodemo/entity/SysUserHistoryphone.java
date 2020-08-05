package com.duckgagaga.shirodemo.myshirodemo.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUserHistoryphone implements Serializable {
    private Long id;

    private Long userId;

    private String phone;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public SysUserHistoryphone(Long id, Long userId, String phone, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.phone = phone;
        this.updateTime = updateTime;
    }

    public SysUserHistoryphone() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}