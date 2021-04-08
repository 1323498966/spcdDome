package com.zbn.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyLB
 * @description: 自定义负载均衡接口实现类
 * @author: zbn
 * @Date 2021/4/4 20:39
 **/

@Component
public class MyLB implements LoadBalancer{

    //原子类整型，初始值为0
    private AtomicInteger atomicInteger = new AtomicInteger(0);



    //自定义算法--轮询算法
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("****第几次访问，次数next："+next);
        return next;
    }



    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
