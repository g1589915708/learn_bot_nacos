package com.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.learn.dao")
//@ComponentScan(value="com.learn.*")
//@EnableWebMvc
//@EnableDiscoveryClient
public class RevelationApplication {

    public static void main(String[] args) {
        SpringApplication.run(RevelationApplication.class, args);
    }

}

