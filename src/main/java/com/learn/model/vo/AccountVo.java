package com.learn.model.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class AccountVo {
    UserVo user;
    String account;
    String password;
    char a_flag;
    String platform;
    String role;
    Integer frequency;
    String url;
    String status;
}
