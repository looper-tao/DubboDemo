package com.yeguxin.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yeguxin.dubbo.service.base.ConsumerService;
import com.yeguxin.dubbo.service.base.ProviderService;
import org.springframework.stereotype.Component;

/**
 * @author: yeguxin
 * @date: 2020/3/24
 * @description:
 */
@Component
public class ConsumerServiceImpl implements ConsumerService {
    @Reference
    private ProviderService providerService;
    
    @Override
    public String consumerMethod1(String desc) {
        return providerService.provideMethod1(desc);
    }
}
