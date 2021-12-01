package com.learn.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class CloudDiskDto {
    private String id;
    private String cloudDisk;
    private String name;
    private String newname;
    private String type;
    private Integer size;
    private String ipAddr;
    private Date createDate;
}
