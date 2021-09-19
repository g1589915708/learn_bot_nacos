package com.learn.controller;

import com.learn.model.ao.TestAo;
import com.learn.model.vo.TestVo;
import com.learn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired

    private IUserService userService;
    @RequestMapping("/find")
    public TestVo find(TestAo ao){
        System.out.println(ao);
        return userService.findById(ao);
    }
    @RequestMapping("/findById")
    public TestVo findById(@RequestParam("id")String id){
        TestAo ao = new TestAo();
        ao.setId(id);
        System.out.println(ao);
        return userService.findById(ao);
    }
}
