package com.loda.helloServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author loda
 * @Date 2022/10/28 15:23
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet(name = "getinfo", value = "/info")
public class GetInfo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取客户端请求的完整URL （从http开始，到?前面结束）
        String url = req.getRequestURL().toString();
        System.out.println("get client's request full RUL: " + url);

        // 获取客户端请求的部分URL （从站点名开始，到?前面结束）
        String uri = req.getRequestURI();
        System.out.println("get client's request part RUL(URI): " + uri);

        // 获取请求行中的参数部分
        //parameter
        String queryStr = req.getQueryString();
        System.out.println("get parameters in request line: " + queryStr);

        // 获取客户端的请求方式
        String method = req.getMethod();
        System.out.println("get request method: " + method);

        // 获取HTTP版本号
        String protocol = req.getProtocol();
        System.out.println("get HTTP version: " + protocol);

        // 获取webapp名字 （站点名）
        String webapp = req.getContextPath();
        System.out.println("get web app name: " + webapp);

        //----------------------------------------------

        // 获取指定名称的参数，返回字符串
        String uname = req.getParameter("uname");
        System.out.println("uname value: " + uname);

        // 获取指定名称参数的所有参数值，返回数组
        String[] hobbys = req.getParameterValues("hobby");
        System.out.println("hobby value: " + Arrays.toString(hobbys));
    }
}
