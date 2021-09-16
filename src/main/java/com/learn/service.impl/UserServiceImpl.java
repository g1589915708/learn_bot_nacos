package com.learn.service.impl;

import com.learn.dao.UserDao;
import com.learn.model.ao.UserAo;
import com.learn.model.dto.UserDto;
import com.learn.model.vo.UserVo;
import com.learn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao dao;


    @Override
    public UserVo findById(UserAo ao) {
        UserDto dto = null;
        UserVo vo = null;
        dto = dao.findById(ao.getId());

        return vo;
    }
}
