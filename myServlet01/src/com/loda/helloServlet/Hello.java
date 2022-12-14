package com.loda.helloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/28 11:43
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet(name="Servlet01", value = "/ser01")
public class Hello extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Servlet!");
        resp.getWriter().write("Hello World java function");
//        super.service(req, resp);
    }
}
