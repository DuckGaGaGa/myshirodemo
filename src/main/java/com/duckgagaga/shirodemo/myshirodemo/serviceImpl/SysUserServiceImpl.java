package com.duckgagaga.shirodemo.myshirodemo.serviceImpl;

import com.duckgagaga.shirodemo.myshirodemo.dao.SysUserMapper;
import com.duckgagaga.shirodemo.myshirodemo.entity.SysUser;
import com.duckgagaga.shirodemo.myshirodemo.entity.SysUserExample;
import com.duckgagaga.shirodemo.myshirodemo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;


    public SysUser findUserByUserName(String userName) {
        System.out.println("进入");
        SysUserExample sysUserExample=new SysUserExample();
        SysUserExample.Criteria criteria= sysUserExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<SysUser> sysUsers=sysUserMapper.selectByExample(sysUserExample);
        if (sysUsers.isEmpty()){
            return null;
        }
        return sysUsers.get(0);
    }
}
