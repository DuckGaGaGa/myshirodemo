package com.duckgagaga.shirodemo.myshirodemo.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUserHistoryemail implements Serializable {
    private Long id;

    private Long userId;

    private String email;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public SysUserHistoryemail(Long id, Long userId, String email, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.updateTime = updateTime;
    }

    public SysUserHistoryemail() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}