package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class AccountDto {
    String id;
    String account;
    String password;
    char a_flag;
    String platform;
    String role;
    Integer frequency;
    String url;
    String status;
    Date createDate;
}
