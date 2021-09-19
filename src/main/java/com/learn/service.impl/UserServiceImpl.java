package com.learn.service.impl;

import com.learn.dao.UserDao;
import com.learn.model.ao.TestAo;
import com.learn.model.dto.TestDto;
import com.learn.model.vo.TestVo;
import com.learn.service.IUserService;
import com.learn.tools.CommonConvertBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao dao;


    @Override
    public TestVo findById(TestAo ao) {
        TestDto dto = null;
        TestVo vo = new TestVo();
        dto = dao.findById(ao.getId());
        if(dto != null) {
            CommonConvertBean.SourceConvertTarget(dto, vo);
        }
        return vo;
    }
}
