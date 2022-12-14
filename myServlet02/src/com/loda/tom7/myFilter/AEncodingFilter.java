package com.loda.tom7.myFilter;

/**
 * @Author loda
 * @Date 2022/10/29 22:55
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 字符乱码处理
 * 乱码情况：
 *                  Tomcat8及以上版本             Tomcat7及以下版本
 *      POST请求       乱码，需要处理                 乱码，需要处理
 *                  request.setCharacterEncoding("UTF-8");
 *      GET请求
 *                  不会乱码，不需要处理              乱码，需要处理
 *
 *              new String(request.getParameter("参数名").getBytes("ISO-8859-1"),"UTF-8");
 *
 * 如何处理：
 * 1、处理POST请求
 *          request.setCharacterEncoding("UTF-8");
 * 2、处理GET请求且服务器版本在Tomcat8以下的
             * 1> 得到请求类型 （GET请求）
             * 2> 得到服务器的版本的信息
             * 3> 判断是GET请求且Tomcat版本小于8
             * 4> 处理乱码
             * new String(request.getParameter("参数名").getBytes("ISO-8859-1"),"UTF-8");
 */
@WebFilter("/*")
public class AEncodingFilter implements Filter {
    public AEncodingFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //处理post请求
        request.setCharacterEncoding("utf-8");

        String method = request.getMethod();
        if ("GET".equalsIgnoreCase(method)) {
            String serverInfo = request.getServletContext().getServerInfo();
            String versionStr = serverInfo.substring(serverInfo.indexOf("/") + 1, serverInfo.indexOf("."));

            if (Integer.parseInt(versionStr) < 8) {
                HttpServletRequest myRequest = new MyWapper(request);
                filterChain.doFilter(myRequest, response);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    class MyWapper extends HttpServletRequestWrapper {
        private HttpServletRequest request;

        public MyWapper(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public String getParameter(String name) {
            String value = request.getParameter(name);
            if (value != null && !"".equals(value.trim())) {
                try {
                    value = new String(value.getBytes("ISO-8859-1"), "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return value;
        }
    }
}
