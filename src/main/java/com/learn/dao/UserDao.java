package com.learn.dao;

import com.learn.model.ao.UserAo;
import com.learn.model.dto.UserDto;
import org.apache.ibatis.annotations.*;
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
    /**
     * 查
     * */
    @Select("SELECT * FROM user WHERE user_id = #{ao.id};")
    UserDto findById(UserAo ao);
    @Select("SELECT * FROM user WHERE password = #{ao.password} AND user = #{ao.user}")
    UserDto findByUser(UserAo dto);
    /**
     * 增加
     * */
    @Insert("INSERT INTO `learn_world`.`user`(`user`, `password`, `nickname`, `email`, `sex`, `birthday`, `picture`, `mobile`, `create_date`) VALUES (#{user}, #{password}, #{nickname}, #{email}, #{sex}, #{birthday}, #{picture}, #{mobile}, #{createDate});")
    Integer insertBaseUser(UserAo ao);
    /**
     * 改
     * */
    @Update("<script>" +
            "UPDATE user SET " +
            "create_date = #{dto.createDate}" +
            "<if test='dto.user != null and dto.user != \"\" '>, user = #{dto.user}</if>" +
            "<if test='dto.password != null and dto.password != \"\" '>, password = #{dto.password}</if>" +
            "<if test='dto.nickname != null and dto.nickname != \"\" '>, nickname = #{dto.nickname}</if>" +
            "<if test='dto.sex != null and dto.sex != \"\" '>, sex = #{dto.sex}</if>" +
            "<if test='dto.birthday != null and dto.birthday != \"\" '>, birthday = #{dto.birthday}</if>" +
            "<if test='dto.picture != null and dto.picture != \"\" '>, picture = #{dto.picture}</if>" +
            "<if test='dto.mobile != null and dto.mobile != \"\" '>, mobile = #{dto.mobile}</if>" +
            "<if test='dto.idCard != null and dto.idCard != \"\" '>, id_card = #{dto.idCard}</if>" +
            "<if test='dto.name != null and dto.name != \"\" '>, name = #{dto.name}</if>" +
            "<if test='dto.level != null and dto.level > 0 '>, level = #{dto.level}</if>" +
            "<if test='dto.parise != null and dto.parise > 0 '>, parise = #{dto.parise}</if>" +
            "<if test='dto.background != null and dto.background != \"\" '>, background = #{dto.background}</if>" +
            "<if test='dto.qq != null and dto.qq != \"\" '>, qq = #{dto.qq}</if>" +
            "<if test='dto.vx != null and dto.vx != \"\" '>, vx = #{dto.vx}</if>" +
            "<if test='dto.status != null and dto.status != \"\" '>, status = #{dto.status}</if>" +
            "WHERE user_id = #{dto.id}" +
            "</script>")
    Integer updateAllUser(UserDto dto);
    /**
     * 删
     * */
    @Update("UPDATE user SET status = 1 WHERE user_id = #{id};")
    Integer deleteBystatus(String id);
    @Delete("DELETE FROM user WHERE user_id = #{id}")
    Integer deleteByRecord(String id);
}
