package com.learn.service.impl;

import com.learn.dao.UserDao;
import com.learn.model.ao.UserAo;
import com.learn.model.dto.UserDto;
import com.learn.model.vo.UserVo;
import com.learn.service.IUserService;
import com.learn.tools.CommonConvertBean;
import com.learn.tools.MD5Util;
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

    @Override
    public UserVo login(UserAo ao) {
        UserVo vo =  new UserVo();
        UserDto dto = null;
        ao.setPassword(MD5Util.encrypt(ao.getPassword()));
        dto = dao.findByUser(ao);
        if(dto != null) {
            CommonConvertBean.SourceConvertTarget(dto, vo);
            System.out.println("=======================ok==========================");
        }
        return null;
    }

    @Override
    public Integer register(UserAo ao) {
        UserVo vo =  new UserVo();
        Integer number = null;
        ao.setPassword(MD5Util.encrypt(ao.getPassword()));

        number = dao.insertBaseUser(ao);

        return number;
    }
}
