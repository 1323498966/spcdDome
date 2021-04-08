package com.zbn.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName LoadBalancer
 * @description: 自定义负载均衡算法接口类
 * @author: zbn
 * @Date 2021/4/4 20:36
 **/
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
