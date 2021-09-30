package com.learn.service.impl;

import com.learn.dao.UserDao;
import com.learn.model.ao.UserAo;
import com.learn.model.dto.UserDto;
import com.learn.model.vo.UserVo;
import com.learn.service.IUserService;
import com.learn.tools.CommonConvertBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServerImpl implements IUserService {
    @Autowired
    private UserDao dao;

    @Override
    public UserVo findById(UserAo ao) {
        UserVo vo =  new UserVo();
        UserDto dto = null;
        dto = dao.findById(ao);
        if(dto != null) { CommonConvertBean.SourceConvertTarget(dto, vo); }
        return vo;
    }
}
