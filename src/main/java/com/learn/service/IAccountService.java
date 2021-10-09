package com.learn.service;

import com.learn.model.ao.AccountAo;
import com.learn.model.vo.AccountVo;
import com.learn.tools.Pager;

import java.util.Map;

public interface IAccountService {
    /**
     *
     *
     * @return
     * */
    AccountVo findAccount(AccountAo ao);
    /**
     *
     * */
    Pager<AccountVo> findAll(Map<String,Object> paramAo);
    /**
     *
     * */
    Integer insertRecordFull(AccountAo ao);
    /**
     *
     * */
    Integer updateRecord(AccountAo ao);
}
