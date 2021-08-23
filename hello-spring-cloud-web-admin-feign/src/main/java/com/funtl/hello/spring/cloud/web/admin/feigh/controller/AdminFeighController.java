package com.funtl.hello.spring.cloud.web.admin.feigh.controller;

import com.funtl.hello.spring.cloud.web.admin.feigh.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangmingzhen
 * @Date 21/8/12 10:14
 */
@RestController
public class AdminFeighController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(required = false) String message){
        return adminService.sayHi(message);
    }

}
