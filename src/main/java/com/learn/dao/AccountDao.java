package com.learn.dao;

import com.learn.model.ao.AccountAo;
import com.learn.model.dto.AccountDto;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {
    @Results(id = "account",value = {
            @Result(id = true,column = "account_id",property = "id"),
            @Result(column = "user_id",property = "user" ,one = @One( select = "com.learn.dao.UserDao.findById",fetchType=FetchType.EAGER)),
            @Result(column = "account",property = "account"),
            @Result(column = "password",property = "password"),
            @Result(column = "a_flag",property = "a_flag"),
            @Result(column = "platform",property = "platform"),
            @Result(column = "role",property = "role"),
            @Result(column = "frequency",property = "frequency"),
            @Result(column = "url",property = "url"),
            @Result(column = "status",property = "status"),
            @Result(column = "create_date",property = "createDate"),
    })
    @Select("SELECT a.* FROM account a JOIN user u ON u.user_id = a.user_id WHERE account = #{account} AND platform = #{platform} AND a.user_id = #{user.id}")
    AccountDto findByaccount(AccountAo ao);
    @Select("SELECT a.* FROM account a JOIN user u ON u.user_id = a.user_id WHERE a.user_id = #{user.id}")
    List<AccountDto> findAll(AccountAo ao);
    @Insert("INSERT INTO `learn_world`.`account`(`user_id`,`account`, `password`, `a_flag`, `platform`, `role`, `frequency`, `url`, `status`, `create_date`) " +
            "VALUES (#{user.id},#{account}, #{password}, #{a_flag}, #{platform}, #{role}, #{frequency}, #{url}, #{status}, #{createDate});")
    Integer insertRecordFull(AccountDto dto);
    @Update("<script>" +
            "UPDATE account SET " +
            "create_date = #{dto.createDate}" +
            "<if test='dto.account != null and dto.account != \"\" '> ,account = #{dto.account} </if>" +
            "<if test='dto.password != null and dto.password != \"\" '> ,password = #{dto.password} </if>" +
            "<if test='dto.a_flag != null'> ,a_flag = #{dto.a_flag} </if>" +
            "<if test='dto.platform != null'> ,platform = #{dto.platform} </if>" +
            "<if test='dto.role != null'> ,role = #{dto.role} </if>" +
            "<if test='dto.frequency != null'> ,frequency = #{dto.frequency} </if>" +
            "<if test='dto.url != null'> ,url = #{dto.url} </if>" +
            "<if test='dto.status != null'> ,status = #{dto.status} </if>" +
            "WHERE account = #{a1} AND user_id = #{dto.user.id};" +
            "</script>")
    Integer updateRecord(AccountDto dto,String a1);
    /**
     *
     * */
    @Update("UPDATE account SET status = 1 WHERE account_id = #{id};")
    Integer deleteBystatus(AccountDto dto);
    @Delete("DELETE FROM account WHERE account_id = #{id}")
    Integer deleteRecord(AccountDto dto);
}
