package com.learn.model.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class AccountVo {
    private UserVo user;
    private String account;
    private String password;
    private char a_flag;
    private String platform;
    private String role;
    private Integer frequency;
    private String url;
    private String status;
}
