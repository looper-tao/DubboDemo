package com.yeguxin.dubbo.controller;

import com.yeguxin.dubbo.service.base.ConsumerService;
import com.yeguxin.dubbo.service.impl.ConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yeguxin
 * @date: 2020/3/24
 * @description:
 */
@RestController
@RequestMapping("dubbo/demo")
public class ConsumerController {
    private final ConsumerService consumerService;
    
    @Autowired
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }
    
    @RequestMapping(value = "get/method1",method = RequestMethod.GET)
    public String getMethod1(@RequestParam("desc") String desc){
        return consumerService.consumerMethod1(desc);
    }
}
