package com.illusory.i.shop.service.search.consumer;

import com.alibaba.dubbo.container.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/9
 */
@SpringBootApplication(scanBasePackages = "com.illusory.i.shop", exclude = DataSourceAutoConfiguration.class)
@EnableHystrix
@EnableHystrixDashboard
public class IShopServiceSearchConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(IShopServiceSearchConsumerApplication.class, args);
        Main.main(args);
    }
}
