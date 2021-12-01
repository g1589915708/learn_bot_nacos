package com.learn.realm;

import com.learn.model.ao.UserAo;
import com.learn.model.dto.UserDto;
import com.learn.model.vo.UserVo;
import com.learn.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("============用户权限==============");
        //获取当前登录的用户信息
        Subject subject = SecurityUtils.getSubject();
        UserDto account = (UserDto) subject.getPrincipal();
        //设置角色
        Set<String> rolesset = new HashSet<>();
        rolesset.add(account.getRole().get(0).getRole());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(rolesset);
        //设置权限
        info.addStringPermission(account.getRole().get(0).getRealm().get(0).getRealm());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserAo ao = new UserAo();
        ao.setUser(token.getUsername());
        UserVo account = userService.login(ao);
        if(account != null){
            //若密码不正确则返回IncorrectCredentialsException异常
            return new SimpleAuthenticationInfo(account,account.getPassword(), getName());
        }
        //若用户名不存在则返回UnknownAccountException异常
        return null;
    }
}
