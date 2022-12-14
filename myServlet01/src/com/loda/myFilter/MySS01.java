package com.loda.myFilter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/29 16:38
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/ss01")
public class MySS01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ss01");
        String uname = req.getParameter("uname");
        System.out.println(uname);
    }
}
