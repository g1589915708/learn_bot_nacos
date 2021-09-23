package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class DiskDirDto {
    String id;
    UserDto user;
    CloudDirectoryDto directoryDto;
    DiskDirDto diskDirDto;
    Date createDate;
}
