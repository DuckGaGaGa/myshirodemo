package com.duckgagaga.shirodemo.myshirodemo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.duckgagaga.shirodemo.myshirodemo.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //凭证匹配器
    @Bean
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
            hashedCredentialsMatcher.setHashAlgorithmName("md5");

            hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }

    //保证实现了Shiro内部lifecycle函数的bean执行
    @Bean
    public  LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    //将自己的验证方式加入容器
    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm=new UserRealm();
        userRealm.setCredentialsMatcher(credentialsMatcher()); //将凭证匹配器注入
        return userRealm;
    }

    // AOP 方法级别权限检察
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }


    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm( userRealm());
        return securityManager;
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /** anon:匿名拦截器，即不需要登录即可访问；一般用于静态资源过滤
            authc:如果没有登录会跳到相应的登录页面登录
            表示访问该地址用户【必须身份验证通过】（Subject. isAuthenticated()==true）
            user:用户拦截器，用户已经身份验证/记住我登录的都可
        */
        Map<String, String> map = new HashMap<>();
        //登出
        map.put("/logout", "logout");
        //对所有用户认证
        map.put("/login.html", "authc");
        map.put("/error.html", "authc");
        map.put("/index.html","authc");
        map.put("/index**","authc");
        map.put("/","authc");//拦截根
        //没有登录将跳转到login
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //登陆成功将跳转到index
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error.html");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /*方言*/
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
