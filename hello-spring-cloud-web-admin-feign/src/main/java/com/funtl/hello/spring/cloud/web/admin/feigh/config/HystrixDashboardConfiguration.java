package com.funtl.hello.spring.cloud.web.admin.feigh.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wangmingzhen
 * @Date 21/8/13 15:32
 */
@Configuration
public class HystrixDashboardConfiguration {

    /**
     * Spring Boot 2.x 版本开启 Hystrix Dashboard 与 Spring Boot 1.x 的方式略有不同，需要增加一个 HystrixMetricsStreamServlet 的配置
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        //servlet
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        //servlet的注册bean
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        //设置servlet的属性
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
