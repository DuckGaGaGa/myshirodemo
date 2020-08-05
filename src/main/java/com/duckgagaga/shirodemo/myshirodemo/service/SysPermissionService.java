package com.duckgagaga.shirodemo.myshirodemo.service;

import com.duckgagaga.shirodemo.myshirodemo.entity.SysPermission;

import java.util.List;

public interface SysPermissionService {

    List<SysPermission> findPermissionsByIds(List<Integer> ids);
}
