package com.duckgagaga.shirodemo.myshirodemo.controller;



import com.duckgagaga.shirodemo.myshirodemo.entity.SysUser;
import com.duckgagaga.shirodemo.myshirodemo.entityGroup.ActiveUser;
import com.duckgagaga.shirodemo.myshirodemo.entityGroup.HttpResult;
import com.duckgagaga.shirodemo.myshirodemo.service.SysPermissionService;
import com.duckgagaga.shirodemo.myshirodemo.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
public class LoginController {
	/*@Autowired*/


	/**
	 *由于Dubbo和shiro先后顺序冲突导致realm里注入服务失败。使用以下方法、
	 * 猜测是由于shiro 比dubbo先启动，导致注入bean时没有获取到dubbo服务，
	 * 参考链接https://www.cnblogs.com/harking/p/9673547.html
	 * 通过dubbo注入服务，将服务转换成Springbean。然后在自定义Realm里 调用自定义bean工厂获取Bean对象
	 */
	@Autowired
	private SysUserService sysUserService;


	@Autowired
	private SysPermissionService sysPermissionService;





/*

	@RequestMapping({"/common/login.do"})
	public HttpResult loginSys(SysUser sysUser, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		System.out.println("进入");

			//验证码正确,将验证码删除

			//得到主体
			Subject subject= SecurityUtils.getSubject();
			*/
/*封装用户名和密码*//*

			UsernamePasswordToken token=new UsernamePasswordToken(sysUser.getUserName(),sysUser.getPassWord());
			try{
				//、登录，即身份验证
				subject.login(token);

				ActiveUser activeUser= (ActiveUser) subject.getPrincipal();
				session.setAttribute("user",activeUser.getSysUser());
				System.out.println("成功");

				return new HttpResult(true,"登陆成功");
			}catch (UnknownAccountException e){
				*/
/*验证失败*//*

				System.out.println("未知的账号异常");
				return new HttpResult(false,"用户名或密码不正确");

			}catch (ExcessiveAttemptsException e){
				System.out.println("认证超过次数异常");
				return new HttpResult(false,"认证超过次数异常");

			}catch (LockedAccountException e){
				System.out.println("账号被锁定异常");
				return new HttpResult(false,"账号被锁定异常");

			}catch (DisabledAccountException e){
				System.out.println("禁用的账号异常");
				return new HttpResult(false,"账号已被禁用异常");

			}catch (IncorrectCredentialsException e){
				System.out.println("不正确的凭证异常");
				return new HttpResult(false,"用户名或密码错误");

			}catch (Exception e){
				System.out.println("其他异常");
				e.printStackTrace();
				return new HttpResult(false,"其他异常");

			}

		}

*/



	@RequestMapping({"/common/login.do"})
	public ModelAndView loginSys(SysUser sysUser, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		System.out.println("进入");
		ModelAndView mv=new ModelAndView();

		//验证码正确,将验证码删除

		//得到主体
		Subject subject= SecurityUtils.getSubject();
		/*封装用户名和密码*/
		UsernamePasswordToken token=new UsernamePasswordToken(sysUser.getUserName(),sysUser.getPassWord());
		try{
			//、登录，即身份验证
			subject.login(token);

			ActiveUser activeUser= (ActiveUser) subject.getPrincipal();
			session.setAttribute("user",activeUser.getSysUser());
			mv.setViewName("index");
			return mv;
			//return new HttpResult(true,"登陆成功");
		}catch (UnknownAccountException e){
			/*验证失败*/
			System.out.println("未知的账号异常");
			//return new HttpResult(false,"用户名或密码不正确");

		}catch (ExcessiveAttemptsException e){
			System.out.println("认证超过次数异常");
			//return new HttpResult(false,"认证超过次数异常");

		}catch (LockedAccountException e){
			System.out.println("账号被锁定异常");
			//return new HttpResult(false,"账号被锁定异常");

		}catch (DisabledAccountException e){
			System.out.println("禁用的账号异常");
			//return new HttpResult(false,"账号已被禁用异常");

		}catch (IncorrectCredentialsException e){
			System.out.println("不正确的凭证异常");
			//return new HttpResult(false,"用户名或密码错误");

		}catch (Exception e){
			System.out.println("其他异常");
			e.printStackTrace();
			//return new HttpResult(false,"其他异常");

		}
		return null;
	}




}
