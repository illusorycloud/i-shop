package com.illusory.i.shop.service.user.consumer.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.illusory.i.shop.service.user.api.UserConsumerService;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/4
 */
@Service(version = "${services.versions.user.v1}")
public class UserConsumerServiceImpl implements UserConsumerService {
    @Override
    public void info() {

    }
}
