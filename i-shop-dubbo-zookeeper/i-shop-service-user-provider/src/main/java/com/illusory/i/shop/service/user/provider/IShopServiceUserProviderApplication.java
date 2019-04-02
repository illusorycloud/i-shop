package com.illusory.i.shop.service.user.provider;

import com.alibaba.dubbo.container.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * 为了扫描到其他项目(commons-dubbo)中配的Hystrix
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/2
 */
@SpringBootApplication(scanBasePackages = "com.illusory.i.shop")
@EnableHystrix
@EnableHystrixDashboard
@EnableTransactionManagement
@MapperScan(basePackages = "com.illusory.i.shop.commons.mapper")
public class IShopServiceUserProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(IShopServiceUserProviderApplication.class, args);
        Main.main(args);
    }
}
