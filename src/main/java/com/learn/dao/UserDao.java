package com.learn.dao;

import com.learn.model.ao.UserAo;
import com.learn.model.dto.UserDto;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    @Results(id = "UserResult",value = {
            @Result(id = true,column = "user_id",property = "id",javaType = java.lang.String.class,jdbcType = JdbcType.CHAR),
            @Result(column = "user",property = "user"),
            @Result(column = "password",property = "password"),
            @Result(column = "nickname",property = "nickname"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "picture",property = "picture"),
            @Result(column = "mobile",property = "mobile"),
            @Result(column = "id_card",property = "idCard"),
            @Result(column = "name",property = "name"),
            @Result(column = "level",property = "level"),
            @Result(column = "parise",property = "parise"),
            @Result(column = "background",property = "background"),
            @Result(column = "qq",property = "qq"),
            @Result(column = "vx",property = "vx"),
            @Result(column = "status",property = "status"),
            @Result(column = "create_date",property = "createDate"),
//            @One(resultMap = "",select = "")
    })
    @Select("SELECT * FROM user WHERE user_id = #{user.id};")
    UserDto findById(UserAo user);
}
