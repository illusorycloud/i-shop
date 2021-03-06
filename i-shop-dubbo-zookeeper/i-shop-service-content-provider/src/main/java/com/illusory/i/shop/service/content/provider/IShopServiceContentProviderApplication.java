package com.illusory.i.shop.service.content.provider;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication(scanBasePackages = "com.illusory.i.shop")
@EnableTransactionManagement
@MapperScan(basePackages = "com.illusory.i.shop.commons.mapper")
public class IShopServiceContentProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(IShopServiceContentProviderApplication.class, args);
        Main.main(args);
    }
}
