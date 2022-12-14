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
@WebServlet("/loginServelet")
public class LoginServelet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login...");
        String uname = req.getParameter("uname");
        System.out.println("uname " + uname);
        if ("admin".equals(uname)) {
            req.getSession().setAttribute("user", uname);
            resp.sendRedirect("index.jsp");
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
