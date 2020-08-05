package com.duckgagaga.shirodemo.myshirodemo.entity;

import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable {
    private Integer id;

    private String role_name;

    private String role_description;

    private Integer role_status;

    private Date create_time;

    private Date update_time;

    private static final long serialVersionUID = 1L;

    public SysRole(Integer id, String role_name, String role_description, Integer role_status, Date create_time, Date update_time) {
        this.id = id;
        this.role_name = role_name;
        this.role_description = role_description;
        this.role_status = role_status;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public SysRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    public Integer getRole_status() {
        return role_status;
    }

    public void setRole_status(Integer role_status) {
        this.role_status = role_status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", role_description='" + role_description + '\'' +
                ", role_status=" + role_status +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}