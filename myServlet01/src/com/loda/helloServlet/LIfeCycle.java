package com.loda.helloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/29 8:33
 * @Description Servlet的生命周期
 * @Version 1.0
 */
@WebServlet("/liftCycle")
public class LIfeCycle extends HttpServlet {
    /**
     * 初始化方法
     * 当请求到达时容器（tomcat）时，容器检查是否有Servlet实例，若没有，则创建实例并初始化
     * 该方法只调用一次
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("init method...");
    }

    /**
     * 服务方法，可多次调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service method...");
    }

    /**
     * 销毁，由Servlet调用
     * 在程序结束或者容器关闭时执行，只调用一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy method...");
    }
}
