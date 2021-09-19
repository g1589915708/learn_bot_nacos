package com.learn.model.ao;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestAo {
    private String id;
    private String username;
    private String password;
    private String mobile;
    private String ckCode;
}
