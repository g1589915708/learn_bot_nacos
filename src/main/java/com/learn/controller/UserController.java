package com.learn.controller;

import com.learn.model.ao.UserAo;
import com.learn.model.vo.UserVo;
import com.learn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/find")
    public UserVo find(UserAo ao){
        System.out.println(ao);
        return userService.findById(ao);
    }
}
