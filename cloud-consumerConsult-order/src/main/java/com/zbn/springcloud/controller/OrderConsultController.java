package com.zbn.springcloud.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderZkController
 * @description: zkController控制器
 * @author: zbn
 * @Date 2021/3/22 20:54
 **/
@RestController
@Log4j2
public class OrderConsultController {
    public static final String URL = "http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;


    @GetMapping(value = "/consumer/consult")
    public String restTemplateInfo() {
        return restTemplate.getForObject(URL + "/payment/consult", String.class);
    }


}
