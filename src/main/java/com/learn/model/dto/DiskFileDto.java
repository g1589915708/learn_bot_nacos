package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DiskFileDto {
    String id;
    UserDto user;
    String diskDir;
    CloudDiskDto cloudDisk;
    Integer shareType;
}
