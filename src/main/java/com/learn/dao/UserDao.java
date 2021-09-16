package com.learn.dao;


import com.learn.model.dto.UserDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * @Results
     * id 当前results唯一的id值
     * value 值为Result[]数组
     *
     * @Result
     * ID id唯一标识
     * column database 列
     * property 对于类的属性名
     * javaType java数据类型
     * jdbcType jdbc数据类型
     *
     * one @One 一对一的配置
     * many @Many 一对多的配置
     *
     * @Many select 要执行的方法
     *
     * @ResultMap 引用已经配置好的@Results
     * value @Results的id值
     *
     * @Param 参数重命名
     * value 变的名字
     *
     * */
    @Results(id = "UserDtoResult",value = {
            @Result(id = true, column = "user_id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "nickname", property = "nickname"),
            @Result(column = "name", property = "name"),
            @Result(column = "password", property = "password"),
            @Result(column = "portrait", property = "portrait"),
            @Result(column = "mobile", property = "mobile"),
            @Result(column = "id_card", property = "idCard")
    })
    @Select("SELECT * FROM user WHERE id = #{id}; ")
    @ResultMap("UserDtoResult")
    UserDto findById(String id);
}
