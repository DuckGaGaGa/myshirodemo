package com.duckgagaga.shirodemo.myshirodemo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysPermission implements Serializable {
    private Integer id;

    private String permission_name;

    private String permission_description;

    private String url;

    private String perms;

    private Integer parent_id;

    private Integer type;

    private Integer status;

    private Date create_time;

    private Date update_time;

    private List<SysPermission> childrenPermission;// 子权限
    private com.duckgagaga.shirodemo.myshirodemo.entity.SysPermission parentsPermission;// 父权限

    private static final long serialVersionUID = 1L;

    public SysPermission(Integer id, String permission_name, String permission_description, String url, String perms, Integer parent_id, Integer type, Integer status, Date create_time, Date update_time, List<SysPermission> childrenPermission, com.duckgagaga.shirodemo.myshirodemo.entity.SysPermission parentsPermission) {
        this.id = id;
        this.permission_name = permission_name;
        this.permission_description = permission_description;
        this.url = url;
        this.perms = perms;
        this.parent_id = parent_id;
        this.type = type;
        this.status = status;
        this.create_time = create_time;
        this.update_time = update_time;
        this.childrenPermission = childrenPermission;
        this.parentsPermission = parentsPermission;
    }

    public com.duckgagaga.shirodemo.myshirodemo.entity.SysPermission getParentsPermission() {
        return parentsPermission;
    }

    public void setParentsPermission(com.duckgagaga.shirodemo.myshirodemo.entity.SysPermission parentsPermission) {
        this.parentsPermission = parentsPermission;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public SysPermission() {
        super();
    }

    public List<SysPermission> getChildrenPermission() {
        return childrenPermission;
    }

    public void setChildrenPermission(List<SysPermission> childrenPermission) {
        this.childrenPermission = childrenPermission;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public String getPermission_description() {
        return permission_description;
    }

    public void setPermission_description(String permission_description) {
        this.permission_description = permission_description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "SysPermission{" +
                "id=" + id +
                ", permission_name='" + permission_name + '\'' +
                ", permission_description='" + permission_description + '\'' +
                ", url='" + url + '\'' +
                ", perms='" + perms + '\'' +
                ", parent_id=" + parent_id +
                ", type=" + type +
                ", status=" + status +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", childrenPermission=" + childrenPermission +
                ", parentsPermission=" + parentsPermission +
                '}';
    }
}