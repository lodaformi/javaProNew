package com.loda.helloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/28 17:09
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet(value = "/myRed")
public class MyRedirect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Servlet myRedirect!");
//        resp.getWriter().write("Hello World myRedirect");
//        resp.sendRedirect("index.jsp");
        resp.sendRedirect("https://www.jd.com");
    }
}
