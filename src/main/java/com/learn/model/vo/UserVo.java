package com.learn.model.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class UserVo {
    String id;
    String user;
    String password;
    String nickname;
    String sex;
    String birthday;
    String picture;
    Integer level;
    Integer parise;
    String background;
}
