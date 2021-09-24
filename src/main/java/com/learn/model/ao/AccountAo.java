package com.learn.model.ao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class AccountAo {
    UserAo user;
    String account;
    String password;
    char a_flag;
    String platform;
    String role;
    Integer frequency;
    String url;
    String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createDate;
}
