package com.learn.model.ao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class AccountAo {
    private UserAo user;
    private String account;
    private String password;
    private char a_flag;
    private String platform;
    private String role;
    private Integer frequency;
    private String url;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
}
