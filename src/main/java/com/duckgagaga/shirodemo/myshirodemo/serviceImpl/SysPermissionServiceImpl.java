package com.duckgagaga.shirodemo.myshirodemo.serviceImpl;

import com.duckgagaga.shirodemo.myshirodemo.dao.SysPermissionMapper;
import com.duckgagaga.shirodemo.myshirodemo.entity.SysPermission;

import com.duckgagaga.shirodemo.myshirodemo.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;


    /**
     * 通过权限ID集合 查询权限，返回权限集合
     * @param ids
     * @return
     */
    @Override
    public List<SysPermission> findPermissionsByIds(List<Integer> ids) {
        List<SysPermission> permissions=new ArrayList<>();
        System.out.println("============== ids =================");
        /*通过权限id查询权限*/
        for (int i=0;i<ids.size();i++){
            SysPermission permission= sysPermissionMapper.selectOneTestById(ids.get(i));
            permissions.add(permission);
        }
        System.out.println("============== 查找后的权限集合 =================");
        return permissions;
    }
}
