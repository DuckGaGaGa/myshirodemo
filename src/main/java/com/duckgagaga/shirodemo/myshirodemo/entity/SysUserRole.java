package com.duckgagaga.shirodemo.myshirodemo.entity;

import java.io.Serializable;

public class SysUserRole implements Serializable {
    private Integer id;

    private Integer user_id;

    private Integer role_id;

    private static final long serialVersionUID = 1L;

    public SysUserRole(Integer id, Integer user_id, Integer role_id) {
        this.id = id;
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public SysUserRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}