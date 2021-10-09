package com.learn.controller;

import com.learn.model.ao.AccountAo;
import com.learn.model.vo.AccountVo;
import com.learn.service.IAccountService;
import com.learn.tools.Pager;
import com.learn.tools.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("/find")
    public ResultCode findByAccount(AccountAo ao){
        ResultCode resultCode = new ResultCode();
        System.out.println("======================================"+ao+"========================================");
        AccountVo vo = null;
        vo = accountService.findAccount(ao);
        System.out.println("======================================"+vo+"========================================");
        ResultCode.addData(resultCode,"account",vo);
        return resultCode;
    }
    @RequestMapping("/findPage")
    public ResultCode findPage(AccountAo ao, Pager pager){
        ResultCode resultCode = new ResultCode();
        System.out.println("======================================"+ao+"========================================");
        Pager<AccountVo> vo = null;
        Map<String,Object> param = new HashMap<>();
        param.put("ao",ao);
        param.put("page",(pager.getPage() - 1) * pager.getSize());
        param.put("size",pager.getSize());
        vo = accountService.findAll(param);
        System.out.println("======================================"+vo+"========================================");
        ResultCode.addData(resultCode,"account",vo);
        return resultCode;
    }
    @RequestMapping("/save")
    public ResultCode save(AccountAo ao){
        ResultCode resultCode = new ResultCode();
        System.out.println("======================================"+ao+"========================================");
        Integer vo = null;
        vo = accountService.insertRecordFull(ao);
        System.out.println("======================================"+vo+"========================================");
        ResultCode.addData(resultCode,"account",vo);
        return resultCode;
    }
    @RequestMapping("/update")
    public ResultCode uodate(AccountAo ao){
        ResultCode resultCode = new ResultCode();
        System.out.println("======================================"+ao+"========================================");
        Integer vo = null;
        vo = accountService.updateRecord(ao);
        System.out.println("======================================"+vo+"========================================");
        ResultCode.addData(resultCode,"account",vo);
        return resultCode;
    }
}
