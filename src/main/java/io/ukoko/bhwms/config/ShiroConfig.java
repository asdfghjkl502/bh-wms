package io.ukoko.bhwms.config;

import io.ukoko.bhwms.shiro.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Shiro的配置文件
 */
@Configuration
public class ShiroConfig {

    /**
     * 将ShiroReaml加入到IOC容器中
     */
    @Bean
    public ShiroRealm createShiroRealm(HashedCredentialsMatcher hashedCredentialsMatcher){
        //创建ShiroRealm实例
        ShiroRealm shiroRealm = new ShiroRealm();
        //设置加密规则
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return shiroRealm;
    }
    /**
     * 创建加密工具将其加入到IOC容器中
     */
    @Bean
    public HashedCredentialsMatcher createHashedCredentialsMatcher(){
        //创建加密的核心对象
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //设置加密方式
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    /**
     * 创建安全管理器
     */
    @Bean
    public SecurityManager createSecurityManager(ShiroRealm shiroRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //设置realm
        defaultWebSecurityManager.setRealm(shiroRealm);
        return defaultWebSecurityManager;
    }

    /**
     * 将ShiroFilter加入到IOC容器
     */
    @Bean
    public ShiroFilterFactoryBean createShiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        return shiroFilter;
    }
    /**
     * 配置AOP代理,否则注解不生效
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor createAuthorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    /**
     * 开启代理
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator createDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
}
