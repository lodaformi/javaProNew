package com.loda.filter;

import cn.hutool.core.util.StrUtil;
//import sun.nio.cs.UTF_8;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Author loda
 * @Date 2022/11/5 16:23
 * @Description 解决乱码过滤器
 * @Version 1.0
 */


@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //处理post请求乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String method = req.getMethod();
        System.out.println("encodeingFilter: "+ method);
        //处理get请求
        if ("get".equalsIgnoreCase(method)) {
            System.out.println("encodeingFilter in if--get");
            String serverInfo = req.getServletContext().getServerInfo(); // Apache Tomcat/7.0.79
            String version = serverInfo.substring(serverInfo.lastIndexOf("/")+1, serverInfo.indexOf("."));
            if (version != null &&  Integer.parseInt(version) < 8) {
                Mywrapper myrequest = new Mywrapper(req);
                chain.doFilter(myrequest, resp);
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    class Mywrapper extends HttpServletRequestWrapper {
        private HttpServletRequest request;
        /**
         * Constructs a request object wrapping the given request.
         *
         * @param request the {@link HttpServletRequest} to be wrapped.
         * @throws IllegalArgumentException if the request is null
         */
        public Mywrapper(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public String getParameter(String name) {
            String value = request.getParameter(name);
            if (StrUtil.isBlank(value)){
                return value;
            }
            try {
                // 通过new String()处理乱码
                value =  new String(value.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return value;
        }
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}
