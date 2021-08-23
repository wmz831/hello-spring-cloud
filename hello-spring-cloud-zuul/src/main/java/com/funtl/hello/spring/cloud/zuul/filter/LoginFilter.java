package com.funtl.hello.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author wangmingzhen
 * @Date 21/8/20 3:35
 */
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要过滤：true/false
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if( token ==null || !token.equals("access")){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().setContentType("text/html;charset=utf-8");
                context.getResponse().getWriter().write("token未通过");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return context;
    }
}
