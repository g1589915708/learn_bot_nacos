package com.learn.service;

import com.learn.model.ao.AccountAo;
import com.learn.model.vo.AccountVo;

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
    Integer insertRecordFull(AccountAo ao);
    /**
     *
     * */
    Integer updateRecord(AccountAo ao);
}
