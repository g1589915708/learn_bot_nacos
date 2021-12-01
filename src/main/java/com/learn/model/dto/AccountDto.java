package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class AccountDto {
    private String id;
    private UserDto user;
    private String account;
    private String password;
    private char a_flag;
    private String platform;
    private String role;
    private Integer frequency;
    private String url;
    private String status;
    private Date createDate;
}
