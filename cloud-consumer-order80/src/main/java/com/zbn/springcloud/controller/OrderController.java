package com.zbn.springcloud.controller;

import com.zbn.springcloud.entities.CommonResult;
import com.zbn.springcloud.entities.Payment;
import com.zbn.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    //定义服务端URL
//    public static final String URL = "http://localhost:8001";
    public static final String URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment) {
        log.info("80消费者/consumer/payment/create");
        return restTemplate.postForObject(URL + "/payment/create", payment, CommonResult.class);
    }


    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        log.info("80消费者/consumer/payment/get/{id}");
        return restTemplate.getForObject(URL + "/payment/get/" + id, CommonResult.class);
    }


    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (CollectionUtils.isEmpty(serviceInstances)){
            return null;
        }
        ServiceInstance instances = loadBalancer.instances(serviceInstances);
        URI uri = instances.getUri();
        return restTemplate.getForObject(uri+"/payment/lb", String.class);
    }

}