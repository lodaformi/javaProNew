package com.loda.myFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/29 16:08
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
//@WebFilter("/ss01")
public class MyFilter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter01 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //在doFilter之前写表示对请求过滤
        System.out.println("filter01 is filtering request...");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);

        //在doFilter之后写表示对响应过滤
        System.out.println("filter01 is filtering response...");
    }

    @Override
    public void destroy() {
        System.out.println("filter01 destroy");
    }
}
