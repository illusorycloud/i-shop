package com.illusory.i.shop.service.content.consumer;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication(scanBasePackages = "com.illusory.i.shop", exclude = DataSourceAutoConfiguration.class)
public class IShopServiceContentConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(IShopServiceContentConsumerApplication.class, args);
        Main.main(args);
    }
}
