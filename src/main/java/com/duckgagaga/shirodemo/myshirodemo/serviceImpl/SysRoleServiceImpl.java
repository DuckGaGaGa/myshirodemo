package com.duckgagaga.shirodemo.myshirodemo.serviceImpl;


import com.duckgagaga.shirodemo.myshirodemo.dao.SysRoleMapper;
import com.duckgagaga.shirodemo.myshirodemo.dao.SysRolePermissionMapper;
import com.duckgagaga.shirodemo.myshirodemo.entity.SysPermission;
import com.duckgagaga.shirodemo.myshirodemo.entity.SysRole;
import com.duckgagaga.shirodemo.myshirodemo.entity.SysRolePermission;
import com.duckgagaga.shirodemo.myshirodemo.entity.SysRolePermissionExample;
import com.duckgagaga.shirodemo.myshirodemo.service.SysPermissionService;
import com.duckgagaga.shirodemo.myshirodemo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;
    @Autowired
    private SysPermissionService sysPermissionService;

    private Set<String> permissionNames=new HashSet<>();
    /**
     * 通过用户id查找用户所拥有的的角色名列表
     * @param id
     * @return 返回角色列表
     */
    @Override
    public List<SysRole> findRolesByUserId(Long id) {
        Integer b= id.intValue();
        List<SysRole> sysRoles=sysRoleMapper.selectUserRolesById(b);
       /* List<String> sysRolesNames=new ArrayList<>();
        for (SysRole sysRole:sysRoles ) {
            sysRolesNames.add(sysRole.getRole_name());

        }*/
        return sysRoles;

    }

    /**
     *通过角色Id列表查询其所拥有的所有权限（含子权限名）
     * @param rolesId
     * @return
     */
    @Override
    public Set<String> findAllPermissNamesByRolesIds(List rolesId) {
        SysRolePermissionExample sysRolePermissionExample=new SysRolePermissionExample();
        SysRolePermissionExample.Criteria criteria=sysRolePermissionExample.createCriteria();
        criteria.andIdIn(rolesId);
        //通过角色id查询所拥有的权限id

        List<SysRolePermission> list1= sysRolePermissionMapper.selectByExample(sysRolePermissionExample);
        //权限id集合
        List<Integer> permissionIds=new ArrayList<>();
        System.out.println("---------------输出权限id----------------------");
        System.out.println(list1);
        for (SysRolePermission entity:list1 ) {
            permissionIds.add(entity.getPermission_id());
        }


        //通过权限id集合查询权限
        List<SysPermission> permissions= sysPermissionService.findPermissionsByIds(permissionIds);
        System.out.println("---------------输出权限集合----------------------");
        System.out.println(permissions);
        permissionNames=new HashSet();
        //递归查询权限及其子权限
        for (int i=0;i<permissions.size();i++){
            permissionNames.add(permissions.get(i).getPermission_name());

                diguichaxun(permissions.get(i));
        }

        System.out.println("输出所有权限");
        for (String str:permissionNames
             )
        {
            System.out.println(str);
        }

        return permissionNames;
    }


    /**
     * 递归权限及其子权限。
     * @param permission
     * @return
     */
    public Set diguichaxun(SysPermission permission){
        List<SysPermission> list=permission.getChildrenPermission();
        System.out.println("list"+list);
        for (SysPermission sysPermission:list) {
            //如果有继续递归
            if (null!=sysPermission.getChildrenPermission()){
                diguichaxun(sysPermission);
            }
            //将权限塞入set里
            permissionNames.add(sysPermission.getPermission_name());
        }
        return permissionNames;
    }


}
