package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class RoleDto {
    private Integer id;
    private String role;
    private List<RealmDto> realm;
}
