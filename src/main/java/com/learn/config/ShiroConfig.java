package com.learn.config;

import java.util.HashMap;
import java.util.Map;

import com.learn.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**import com.blu.realm.AccountRealm;*/

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig {
    /**
     anon:表示可以匿名使用。
     authc:表示需要认证(登录)才能使用，没有参数
     roles：参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，
     当有多个参数时，例如admins/user/**=roles[“admin,guest”],每个参数通过才算通过，相当于hasAllRoles()方法。
     perms：参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，
     例如/admins/user/**=perms[“user:add:,user:modify:”]，当有多个参数时必须每个参数都通过才通过，想当于isPermitedAll()方法。
     rest：根据请求的方法，相当于/admins/user/**=perms[user:method] ,其中method为post，get，delete等。
     port：当请求的url的端口不是8081是跳转到schemal://serverName:8081?queryString,
     其中schmal是协议http或https等，serverName是你访问的host,8081是url配置里port的端口，queryString是你访问的url里的？后面的参数。
     authcBasic：没有参数表示httpBasic认证
     ssl:表示安全的url请求，协议为https
     user:当登入操作时不做检查
     也可以自定一个filter加入到过滤链中.
     * */
    /**
     * 创建shiro的过滤器,定义过滤规则
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<String, String>();
        /** 游客不拦截 */
        map.put("/guest/**", "anon");
        /** 只允许user权限的访问 */
        map.put("/user/**", "roles[user]");
        /** 只允许admin权限的访问 */
        map.put("/admin/**", "roles[admin]");
        /** 登录页面不可以拦截, */
        map.put("/login", "anon");
        /** 最后在写剩下的所有全部拦截,否则会造成拦截所有的url */
        map.put("/**", "authc");
        factoryBean.setFilterChainDefinitionMap(map);
        System.out.println("---------------shirofactory创建成功");
        /** 拦截到没有登录后跳到哪里去登录 */
        factoryBean.setLoginUrl("/login");
         /** 拦截没有权限的用户跳到哪里去 */
        factoryBean.setUnauthorizedUrl("/noAuthorize");
        return factoryBean;
    }
    /**
     * 创建安全管理
     * 注意创建实现了web的对象
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }
    /**
     * 创建自定义的验证规则
     * @return
     */
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
//    @Bean
//    public ShiroDialect shiroDialect(){
//        return new ShiroDialect();
//    }
}
