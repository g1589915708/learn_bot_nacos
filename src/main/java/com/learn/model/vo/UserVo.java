package com.learn.model.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class UserVo {
    private String id;
    private String user;
    private String password;
    private String nickname;
    private String sex;
    private String birthday;
    private String picture;
    private Integer level;
    private Integer parise;
    private String background;
}
