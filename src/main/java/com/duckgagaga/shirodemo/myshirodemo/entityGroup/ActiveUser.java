package com.duckgagaga.shirodemo.myshirodemo.entityGroup;

import com.duckgagaga.shirodemo.myshirodemo.entity.SysUser;

import java.util.List;
import java.util.Set;

public class ActiveUser {
    private SysUser sysUser;
    private List<String> roles;//角色
    private Set<String> permissions;//权限

    public ActiveUser() {
    }

    public ActiveUser(SysUser sysUser, List<String> roles, Set<String> permissions) {
        this.sysUser = sysUser;
        this.roles = roles;
        this.permissions = permissions;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "ActiveUser{" +
                "sysUser=" + sysUser +
                ", roles=" + roles +
                ", permissions=" + permissions +
                '}';
    }
}
