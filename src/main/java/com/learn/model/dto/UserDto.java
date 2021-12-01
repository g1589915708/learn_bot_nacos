package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
public class UserDto {
    private String id;
    private String user;
    private String password;
    private String nickname;
    private String sex;
    private String birthday;
    private String picture;
    private String mobile;
    private String idCard;
    private String name;
    private Integer level;
    private Integer parise;
    private String background;

    private String qq;
    private String vx;

    private String status;
    /**
     * Calendar
     * */
    private Date createDate;

    private List<RoleDto> role;

}
