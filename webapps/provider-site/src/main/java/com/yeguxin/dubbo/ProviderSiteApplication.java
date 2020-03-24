package com.yeguxin.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yeguxin
 * @date: 2020/3/5
 * @description:
 */
@EnableDubbo
@RequestMapping("")
@RestController
@SpringBootApplication
@Configuration
public class ProviderSiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderSiteApplication.class,args);
    }
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        return "SUCCESS !!!";
    }
    
//    public static void main(String[] args) throws Exception {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"provider.xml"});
//        context.start();
//        System.in.read(); // 按任意键退出
//    }
}
