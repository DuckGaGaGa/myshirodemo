package com.duckgagaga.shirodemo.myshirodemo.service;

import com.duckgagaga.shirodemo.myshirodemo.entity.SysRole;

import java.util.List;
import java.util.Set;

public interface SysRoleService {



    List<SysRole> findRolesByUserId(Long id);

    Set<String> findAllPermissNamesByRolesIds(List rolesId);


}
