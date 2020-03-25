## 服务消费者

### 配置:

- 注解配置
    - 在项目配置文件中配置dubbo相关配置
        > application.yml 或者 application.properties 或者 dubbo-consumer.yml(自定义配置文件)
         ```yaml
            dubbo:
              application:
                name: consumer-site # 消费方应用信息，用于计算依赖关系
              registry:
                protocol: zookeeper # 使用zookeeper广播注册中心暴露服务地址
                address: 127.0.0.1:2181 # zookeeper 地址
              protocol:
                name: dubbo # 用dubbo协议
                port: 20880 # 在20880端口暴露服务
              scan:
                base-packages: com.yeguxin.dubbo.service #扫描注解包通过该设置将服务注册到zookeeper
        ```
    - 使用 Reference注解引用服务
        ```java
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
    
        ```