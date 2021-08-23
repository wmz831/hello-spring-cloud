package com.funtl.hello.spring.cloud.web.admin.feigh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author wangmingzhen
 * @Date 21/8/12 9:55
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableHystrixDashboard
public class FeighApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeighApplication.class, args);
    }
}
