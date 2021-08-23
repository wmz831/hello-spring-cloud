package com.funtl.hello.spring.cloud.web.admin.feigh.service.hystrix;

import com.funtl.hello.spring.cloud.web.admin.feigh.service.AdminService;
import org.springframework.stereotype.Component;

/**
 * @Author wangmingzhen
 * @Date 21/8/13 15:18
 */
@Component
public class AdminServiceHystrix implements AdminService {

    @Override
    public String sayHi(String message) {
        return String.format("Sorry! The server %s is unavailable", message);
    }
}
