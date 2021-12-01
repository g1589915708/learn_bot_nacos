package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DiskFileDto {
    private String id;
    private UserDto user;
    private String diskDir;
    private CloudDiskDto cloudDisk;
    private Integer shareType;
}
