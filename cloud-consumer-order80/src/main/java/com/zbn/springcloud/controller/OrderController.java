package com.zbn.springcloud.controller;

import com.zbn.springcloud.entities.CommonResult;
import com.zbn.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    //定义服务端URL
//    public static final String URL_8001 = "http://localhost:8001";
    public static final String URL_8001 = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment) {
        log.info("80消费者/consumer/payment/create1");
        return restTemplate.postForObject(URL_8001+"/payment/create",payment,CommonResult.class);
    }


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        log.info("80消费者/consumer/payment/get/{id}");
        return restTemplate.getForObject(URL_8001+"/payment/get/"+id,CommonResult.class);
    }
}