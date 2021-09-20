package com.learn.service;

import com.learn.model.ao.TestAo;
import com.learn.model.vo.TestVo;

public interface ITestService {
    TestVo findById(TestAo ao);
}
