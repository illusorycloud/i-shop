package com.illusory.i.shop.service.redis.provider;

import com.alibaba.dubbo.container.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/8
 */
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class IShopServiceRedisProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(IShopServiceRedisProviderApplication.class, args);
        Main.main(args);
    }
}
