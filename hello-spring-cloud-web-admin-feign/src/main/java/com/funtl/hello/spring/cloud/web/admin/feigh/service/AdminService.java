package com.funtl.hello.spring.cloud.web.admin.feigh.service;

import com.funtl.hello.spring.cloud.web.admin.feigh.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author wangmingzhen
 * @Date 21/8/12 10:10
 */
@FeignClient(value = "hello-spring-cloud-service-admin", fallback = AdminServiceHystrix.class)
public interface AdminService {

    @GetMapping("/hi")
    String sayHi(@RequestParam String message);

}
