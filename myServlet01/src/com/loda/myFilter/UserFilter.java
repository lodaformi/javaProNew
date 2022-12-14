package com.loda.myFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/30 22:25
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
/**
 * 非法访问拦截（当用户未登录时，拦截请求到登录页面）
 *      拦截的资源：
 *          拦截所有资源 /*
 *      需要被放行的资源：
 *          不需要登录即可访问的资源
 *              1、放行指定页面，不需要登录可以访问的页面（例如：登录页面、注册页面等）
 *              2、放行静态资源（例如：css、js、image等资源）
 *              3、放行指定操作，不需要登录即可执行的操作（例如：登录操作、注册操作等）
 *              4、登录状态放行 （如果存在指定sessuin对象，则为登录状态）
 */
//@WebFilter("/*")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI();
        System.out.println("request URI: "+ path);

        //1、放行指定页面，不需要登录可以访问的页面（例如：登录页面、注册页面等）
        if (path.contains("/login.jsp") || path.contains("/register.jsp")) {
            filterChain.doFilter(request, response);
            return;
        }
//        2、放行静态资源（例如：css、js、image等资源）
        if (path.contains("/js") || path.contains("/imgs") || path.contains("/css")) {
            filterChain.doFilter(request, response);
            return;
        }
//        3、放行指定操作，不需要登录即可执行的操作（例如：登录操作、注册操作等）
        if (path.contains("/loginServelet")) {
            filterChain.doFilter(request,response);
            return;
        }
//         4、登录状态放行 （如果存在指定sessuin对象，则为登录状态）
        String name = (String) request.getSession().getAttribute("user");
        System.out.println("filter get name: "+ name);
        if (name == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        if (name != null) {
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("after filterChain");
        response.sendRedirect("login.jsp");
//        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
