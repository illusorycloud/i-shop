package com.illusory.i.shop.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/4
 */
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication(scanBasePackages = "com.illusory.i.shop", exclude = DataSourceAutoConfiguration.class)
public class IShopApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(IShopApiGatewayApplication.class, args);
    }
}
