package com.zbn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ConsulPaymentMain8006
 * @description: Consul8006服务端启动类
 * @author: zbn
 * @Date 2021/3/23 22:34
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPaymentMain8006.class, args);
    }

}
