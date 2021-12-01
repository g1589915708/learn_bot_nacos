package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RealmDto {
    private Integer id;
    private String realm;
    private String url;
}
