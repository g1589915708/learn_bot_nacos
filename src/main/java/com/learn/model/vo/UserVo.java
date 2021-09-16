package com.learn.model.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVo {
    private String username;
    private String nickname;
    private String name;
    private String mobile;
    private String portrait;
}
