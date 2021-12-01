package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CloudDirectoryDto {
    private String id;
    private String cloudDirectory;
}
