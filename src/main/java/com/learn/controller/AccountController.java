package com.learn.controller;

import com.learn.model.ao.AccountAo;
import com.learn.model.vo.AccountVo;
import com.learn.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/find")
    public AccountVo findByAccount(AccountAo ao){
        System.out.println("======================================"+ao+"========================================");
        AccountVo vo = null;
        vo = accountService.findAccount(ao);
        System.out.println("======================================"+vo+"========================================");
        return vo;
    }
    @RequestMapping("/save")
    public Integer save(AccountAo ao){
        System.out.println("======================================"+ao+"========================================");
        Integer vo = null;
        vo = accountService.insertRecordFull(ao);
        System.out.println("======================================"+vo+"========================================");
        return vo;
    }
    @RequestMapping("/update")
    public Integer uodate(AccountAo ao){
        System.out.println("======================================"+ao+"========================================");
        Integer vo = null;
        vo = accountService.updateRecord(ao);
        System.out.println("======================================"+vo+"========================================");
        return vo;
    }
}
