package com.zbn.springcloud.controller;

import com.zbn.springcloud.entities.CommonResult;
import com.zbn.springcloud.entities.Payment;
import com.zbn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Autowired
    private EurekaDiscoveryClient discoveryClient;


    @Value("${server.port}")
    String serverPort;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("======插入数据结果："+result);
        return  (result > 0) ? new CommonResult(200,serverPort+"数据插入成功",result) :  new CommonResult(400,serverPort+"数据插入失败",null);
    }


    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("======查询数据结果：" + payment);
        return (Objects.nonNull(payment)) ? new CommonResult(200, serverPort + "查询成功", payment) : new CommonResult(400, serverPort + "查询失败", null);
    }


    @GetMapping(value = "/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(o->{ log.info("====="+o); });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(o->{
            log.info(o.getServiceId()+"\t"+
                    o.getHost()+"\t"+
                    o.getPort()+"\t"+
                    o.getUri()+"\t"+
                    o.getScheme()+"\t");
        });
        return this.discoveryClient;
    }


    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}