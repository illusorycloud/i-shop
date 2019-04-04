package com.illusory.i.shop.service.user.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.container.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 消费者不用配数据源
 * exclude = DataSourceAutoConfiguration.class
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/2
 */
@SpringBootApplication(scanBasePackages = "com.illusory.i.shop", exclude = DataSourceAutoConfiguration.class)
@EnableHystrix
@EnableHystrixDashboard
public class IShopServiceUserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(IShopServiceUserConsumerApplication.class, args);
        Main.main(args);
    }
}
