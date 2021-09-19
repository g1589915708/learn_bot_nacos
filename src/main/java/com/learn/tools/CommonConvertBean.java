package com.learn.tools;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CommonConvertBean {

    public static<T,R> R SourceConvertTarget(T source,R r){
        BeanUtils.copyProperties(source,r);
        return r;
    }

    public static<T,R> ArrayList<R> ListSourceConvertTarget(List<T> source, Class<R> clazz) throws IllegalAccessException, InstantiationException {
        ArrayList<R> target = new ArrayList<>();
        if (!CollectionUtils.isEmpty(source)) {
            for (Object c : source) {
                R r = clazz.newInstance();
                R obj = SourceConvertTarget(c, r);
                target.add(obj);
            }
        }
        return target;
    }
}
