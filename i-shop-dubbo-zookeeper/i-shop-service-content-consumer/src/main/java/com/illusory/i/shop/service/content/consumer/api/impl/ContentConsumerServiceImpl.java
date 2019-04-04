package com.illusory.i.shop.service.content.consumer.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.illusory.i.shop.service.content.api.ContentConsumerService;

@Service(version = "${services.versions.content.v1}")
public class ContentConsumerServiceImpl implements ContentConsumerService {
    @Override
    public void info() {

    }
}
