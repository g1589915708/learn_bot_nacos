package com.learn.controller;

import com.learn.model.ao.UserAo;
import com.learn.model.vo.UserVo;
import com.learn.service.IUserService;
import com.learn.tools.ResultCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/find")
    public ResultCode find(UserAo ao){
        ResultCode resultCode = new ResultCode();
        UserVo vo = null;
        System.out.println(ao);
        vo = userService.findById(ao);
        System.out.println(vo);
        ResultCode.addData(resultCode,"account",vo);
        return resultCode;
    }
    @RequestMapping("/login")
    public ResultCode login(UserAo ao){
        Subject subject = SecurityUtils.getSubject();
        ResultCode resultCode = new ResultCode();
        UserVo vo = null;
        System.out.println(ao);
        vo = userService.login(ao);
        UsernamePasswordToken token = new UsernamePasswordToken(ao.getUser(),ao.getPassword());
        System.out.println(vo);
        subject.login(token);
        UserVo account = (UserVo) subject.getPrincipal();
        ResultCode.addData(resultCode,"account",vo);
        return resultCode;
    }
    @RequestMapping("/register")
    public ResultCode register(UserAo ao){
        ResultCode resultCode = new ResultCode();
        Integer vo = null;
        System.out.println(ao);
        vo = userService.register(ao);
        System.out.println(vo);
        ResultCode.addData(resultCode,"result","恭喜注册成功!");
        return resultCode;
    }

    @RequestMapping("/noAuthorize")
    public ResultCode noAuthorize(){
        ResultCode resultCode = new ResultCode();
        ResultCode.addData(resultCode,"Tips","您没有权限哦!");
        return resultCode;
    }
}
