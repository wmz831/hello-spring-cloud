package com.funtl.hello.spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author wangmingzhen
 * @Date 21/8/12 5:04
 *
 * 注意：这里注解的用法
 * @EnableEurekaServer 注册中心，eureka服务器
 * @EnableEurekaClient / @EnableDiscoveryClient enableEurekaClient和enableDiscoveryClient的用法一样，一个是netflix提供的一个是spring提供的
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
