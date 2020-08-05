package com.duckgagaga.shirodemo.myshirodemo.service;

import com.duckgagaga.shirodemo.myshirodemo.entity.SysUser;

public interface SysUserService {

	/**
	 * 通过系统用户用户名查询 系统用户
	 * @param userName
	 * @return  SysUser
	 */
	SysUser findUserByUserName(String userName);


}
