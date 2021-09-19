package com.learn.tools;

import org.springframework.beans.BeanUtils;

public class CommonDtoConvertVo {
    public static<T,R> R DtoConvertVo(T t,R r){
        BeanUtils.copyProperties(t,r);
        return r;
    }
}
