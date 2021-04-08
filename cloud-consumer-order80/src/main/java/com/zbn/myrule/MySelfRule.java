package com.zbn.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MySelfRule
 * @description: 负载均衡配置类
 * @author: zbn
 * @Date 2021/4/1 21:41
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule MySelfRule(){
        return new RandomRule();
    }
}
