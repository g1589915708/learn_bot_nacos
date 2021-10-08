package com.learn.service;

import com.learn.model.ao.UserAo;
import com.learn.model.vo.UserVo;

public interface IUserService {
    UserVo findById(UserAo ao);

    UserVo login(UserAo ao);

    Integer register(UserAo ao);
}
