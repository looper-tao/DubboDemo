package com.yeguxin.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: yeguxin
 * @date: 2020/3/24
 * @description:
 */
//@EnableDubbo
@ImportResource(value = "classpath:consumer.xml")
@SpringBootApplication
public class ConsumerSiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerSiteApplication.class,args);
    }
}
