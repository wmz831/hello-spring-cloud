package com.funtl.hello.spring.cloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wangmingzhen
 * @Date 21/8/12 8:24
 */
@Service
public class AdminService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHi(String message) {
        int r1, r2;
        r1 = r2 = 0;
        for (int i = 0; i < 10; i++) {
            String tmp = restTemplate.getForObject("http://hello-spring-cloud-service-admin/hi?message=hello", String.class);
            System.out.println(tmp);
            if (tmp.substring(tmp.length() - 4, tmp.length()).equals("8762")) {
                r1++;
            } else if (tmp.substring(tmp.length() - 4, tmp.length()).equals("8763")) {
                r2++;
            }
        }
        return "r1:" + r1 + " r2:" + r2;
    }

    public String hiError(String message){
        return String.format("Sorry! The server %s is unavailable", message);
    }

}
