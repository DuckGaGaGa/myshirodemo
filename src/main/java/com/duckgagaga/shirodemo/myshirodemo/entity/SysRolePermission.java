package com.duckgagaga.shirodemo.myshirodemo.entity;

import java.io.Serializable;

public class SysRolePermission implements Serializable {
    private Integer id;

    private Integer role_id;

    private Integer permission_id;

    private static final long serialVersionUID = 1L;

    public SysRolePermission(Integer id, Integer role_id, Integer permission_id) {
        this.id = id;
        this.role_id = role_id;
        this.permission_id = permission_id;
    }

    public SysRolePermission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }

    @Override
    public String toString() {
        return "SysRolePermission{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", permission_id=" + permission_id +
                '}';
    }

}