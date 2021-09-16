package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value="com.learn.dao")
public class RevelationApplication {

    public static void main(String[] args) {
        SpringApplication.run(RevelationApplication.class, args);
    }

}
