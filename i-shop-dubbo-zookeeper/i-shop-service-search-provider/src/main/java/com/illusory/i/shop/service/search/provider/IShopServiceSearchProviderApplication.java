package com.illusory.i.shop.service.search.provider;

import com.alibaba.dubbo.container.Main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/9
 */
@SpringBootApplication(scanBasePackages = "com.illusory.i.shop")
@EnableHystrix
@EnableHystrixDashboard
@MapperScan(basePackages = "com.illusory.i.shop.service.search.provider.mapper")
public class IShopServiceSearchProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(IShopServiceSearchProviderApplication.class, args);
        Main.main(args);
    }
}
