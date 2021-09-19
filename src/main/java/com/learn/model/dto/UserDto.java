package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDto {
    private String id;
    private String username;
    private String password;
    private String nickname;
    private String name;
    private String mobile;
    private String portrait;
    private String idCard;
}
