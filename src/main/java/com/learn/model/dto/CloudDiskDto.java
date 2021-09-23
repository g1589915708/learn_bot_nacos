package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class CloudDiskDto {
    String id;
    String cloudDisk;
    String name;
    String newname;
    String type;
    Integer size;
    String ipAddr;
    Date createDate;
}
