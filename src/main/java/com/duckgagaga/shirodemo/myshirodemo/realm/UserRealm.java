package com.duckgagaga.shirodemo.myshirodemo.realm;


import com.duckgagaga.shirodemo.myshirodemo.entity.SysRole;
import com.duckgagaga.shirodemo.myshirodemo.entity.SysUser;
import com.duckgagaga.shirodemo.myshirodemo.entityGroup.ActiveUser;
import com.duckgagaga.shirodemo.myshirodemo.service.SysRoleService;
import com.duckgagaga.shirodemo.myshirodemo.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;

    /*授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        ActiveUser activeUser= (ActiveUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> roles=activeUser.getRoles();
        /*赋予角色*/
        if(null!= roles && roles.size()>0) {
            info.addRoles(roles);
        }
        Set<String> permissins = activeUser.getPermissions();
        /*赋予权限*/
        if (permissins!=null&&permissins.size()>0)
        {
            info.addStringPermissions(permissins);
        }

        return info;
    }

    /*认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)  {
        /*获取服务*/
       /* SysUserService sysUserService  = (SysUserService) SpringUtil.getBean("sysUserService");
        SysRoleService sysRoleService  = (SysRoleService) SpringUtil.getBean("sysRoleService");
*/
        /*System.out.println(sysUserService);
        System.out.println(sysRoleService);
        System.out.println(sysUserService.findUserByUserName("admin"));*/


        String username =  token.getPrincipal().toString(); // 获取用户名
        SysUser sysUser = sysUserService.findUserByUserName(username);//获取SysUser对象





        if (null==sysUser){
            throw new UnknownAccountException();
        }else if (sysUser.getCode()==1){
            throw new LockedAccountException();
        }

        //查询该用户所拥有的角色
        List<SysRole> sysRoles=sysRoleService.findRolesByUserId(sysUser.getId());

        //用户所拥有的所有角色名
        List<String> roleNames=new ArrayList<>();

        //用户所拥有的所有角色Id值
        List<Integer> rolesId=new ArrayList<>();
        for (SysRole sysRole:sysRoles ) {
            roleNames.add(sysRole.getRole_name());
            rolesId.add(sysRole.getId());
        }


        //通过用户角色id值查找所有的权限及其子权限名

        Set<String> permissionSet=sysRoleService.findAllPermissNamesByRolesIds(rolesId);

   //     List<String> roles=sysRoleService.findRolesByUserId(user.getId());
    //    List<String> permission=permissionService.findPermissionByUserId(user.getId());
        System.out.println(permissionSet);

        ActiveUser activeUser= new ActiveUser(sysUser,roleNames,permissionSet);
        System.out.println(activeUser);
        ByteSource credentialsMatcher =ByteSource.Util.bytes(username+"k1u9a9i7l0a2i1s5h2o0p");
        SimpleAuthenticationInfo info =new SimpleAuthenticationInfo(activeUser,sysUser.getPassWord(),credentialsMatcher,getName());
        return info;
    }
}
