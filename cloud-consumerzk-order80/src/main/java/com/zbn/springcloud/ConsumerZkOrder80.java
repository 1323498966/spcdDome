package com.zbn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName consumerZkOrder80
 * @description: 启动类
 * @author: zbn
 * @Date 2021/3/22 20:39
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZkOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZkOrder80.class, args);
    }
}
