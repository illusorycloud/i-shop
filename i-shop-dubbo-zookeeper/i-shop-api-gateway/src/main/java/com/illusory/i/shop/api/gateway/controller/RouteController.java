package com.illusory.i.shop.api.gateway.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.illusory.i.shop.service.content.api.ContentConsumerService;
import com.illusory.i.shop.service.user.api.UserConsumerService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 手动实现的一个简单路由
 *
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/4
 */
@Controller
@RequestMapping(value = "router")
public class RouteController {
    @Reference(version = "${services.versions.user.v1}")
    private UserConsumerService userConsumerService;
    @Reference(version = "${services.versions.user.v1}")
    private ContentConsumerService contentConsumerService;
    private String userPort = "8601";
    private String contentPort = "8602";

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String user(String path) {
        //1.远程调用
        userConsumerService.info();
        //2.判断本端是否为消费端
        return getRouter(userPort, path);
    }

    private String getRouter(String port, String path) {
        boolean consumerSide = RpcContext.getContext().isConsumerSide();
        if (consumerSide) {
            String serverIP = RpcContext.getContext().getRemoteHost();
            return String.format("redirect:http://%s:%s%s", serverIP, port, path);
        }
        return null;
    }

    @RequestMapping(value = "content", method = RequestMethod.GET)
    public String content(String path) {
        //1.远程调用
        contentConsumerService.info();
        //2.判断本端是否为消费端
        return getRouter(contentPort, path);
    }
}
