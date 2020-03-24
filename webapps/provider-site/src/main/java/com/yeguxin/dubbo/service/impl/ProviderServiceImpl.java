package com.yeguxin.dubbo.service.impl;


import com.yeguxin.dubbo.service.base.ProviderService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author: yeguxin
 * @date: 2020/3/5
 * @description:
 */
@Service
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String provideMethod1(String desc) {
        return "服务端测试方法1 -- desc = "+ desc;
    }
}
