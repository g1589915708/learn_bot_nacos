package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class DiskDirDto {
    private String id;
    private UserDto user;
    private CloudDirectoryDto directoryDto;
    private DiskDirDto diskDirDto;
    private Date createDate;
}
