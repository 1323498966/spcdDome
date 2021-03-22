package com.zbn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//表示这个服务是Eureka的注册中心
@EnableEurekaServer
public class EurekaMain7001{
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}