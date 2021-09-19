package com.learn.service.impl;

import com.learn.dao.UserDao;
import com.learn.model.ao.UserAo;
import com.learn.model.dto.UserDto;
import com.learn.model.vo.UserVo;
import com.learn.service.IUserService;
import com.learn.tools.CommonDtoConvertVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao dao;


    @Override
    public UserVo findById(UserAo ao) {
        UserDto dto = null;
        UserVo vo = new UserVo();
        dto = dao.findById(ao.getId());
        if(dto != null) {
            CommonDtoConvertVo.DtoConvertVo(dto, vo);
        }
        return vo;
    }
}
