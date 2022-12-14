package com.loda.myServelet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/31 17:31
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/loginServelet")
public class LoginSer extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");

        //获取表单提交的参数
        String name = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        //对参数进行判断
        if (name == null || "".equals(name.trim())) {
            req.setAttribute("msg","user name is null");
//            resp.getWriter().write("user name is null");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        if (pwd == null || "".equals(pwd.trim())) {
            req.setAttribute("msg","password is null");
//            resp.getWriter().write("password is null");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        if (!"admin".equals(name) || !"admin".equals(pwd)) {
            req.setAttribute("msg","login failed!");
//            resp.getWriter().write("login failed!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        //登陆成功
        req.setAttribute("uname", name);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
