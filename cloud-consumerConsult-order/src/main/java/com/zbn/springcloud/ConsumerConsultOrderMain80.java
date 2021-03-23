package com.zbn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ConsumerConsultOrder80
 * @description: TODO
 * @author: zbn
 * @Date 2021/3/23 23:02
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsultOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsultOrderMain80.class, args);
    }
}
