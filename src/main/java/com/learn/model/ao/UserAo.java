package com.learn.model.ao;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class UserAo {
    String id;
    String user;
    String password;
    String nickname;
    String sex;
    String birthday;
    String picture;
    String mobile;
    String idCard;
    String name;
    Integer level;
    Integer parise;
    String background;

    String qq;
    String vx;
}
