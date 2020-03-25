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
- XML配置
    - consumer.xml配置示例
        ```xml
         <?xml version="1.0" encoding="UTF-8"?>
         <beans xmlns="http://www.springframework.org/schema/beans"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:dubbo="http://dubbo.apache.org/schema/dubbo"
                xsi:schemaLocation="http://www.springframework.org/schema/beans        http://www.springframework.org/schema/beans/spring-beans-4.3.xsd        http://dubbo.apache.org/schema/dubbo        http://dubbo.apache.org/schema/dubbo/dubbo.xsd">
         
         <!-- 消费方应用名，用于计算依赖关系，不是匹配条件，不要与提供方一样 -->
             <dubbo:application name="consumer-site"/>
         
             <!-- 使用zookeeper广播注册中心暴露发现服务地址 -->
             <dubbo:registry address="zookeeper://127.0.0.1:2181"/>
         
             <!-- 生成远程服务代理，可以和本地bean一样使用demoService -->
             <dubbo:reference id="providerService" check="false" interface="com.yeguxin.dubbo.service.base.ProviderService"/>
         </beans>
        ```        
    - 启动类需要添加的注解
        - @ImportResource(value = "classpath:consumer.xml")
        ```java
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
        @ImportResource(value = "classpath:consumer.xml")
        @SpringBootApplication
        public class ConsumerSiteApplication {
            public static void main(String[] args) {
                SpringApplication.run(ConsumerSiteApplication.class,args);
            }
        }

        ```    