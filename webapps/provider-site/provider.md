## 服务提供者

### 配置:

- 注解配置:
    - 在项目配置文件中配置dubbo相关配置
        > application.yml 或者 application.properties 或者 dubbo-provider.yml(自定义配置文件)
        ```yaml
          dubbo:
            application:
              name: provider-site # 提供方应用信息，用于计算依赖关系
            registry:
              protocol: zookeeper # 使用zookeeper广播注册中心暴露服务地址
              address: 127.0.0.1:2181 # zookeeper 地址
            protocol:
              name: dubbo # 用dubbo协议
              port: 20880 # 在20880端口暴露服务
            scan:
              base-packages: com.yeguxin.dubbo.service #扫描注解包通过该设置将服务注册到zookeeper
        ```
    - 如果使用 dubbo-provider.yml 的话需要在启动类中添加 @PropertySource注解 查找配置文件
        ```java
        package com.yeguxin.dubbo;
        
        import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.PropertySource;
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
        @SpringBootApplication
        @PropertySource("classpath:dubbo-provider.yml")
        public class ProviderSiteApplication {
            public static void main(String[] args) {
                SpringApplication.run(ProviderSiteApplication.class,args);
            }
        }

        ```   
    - Service注解暴露服务
        ```java
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
        ```