package com.loda.controller;

import com.loda.entity.mo.MessageModel;
import com.loda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/11/3 16:58
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/loginSer")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        System.out.println("in servlet");
        MessageModel messageModel = userService.userLogin(uname, upwd);
        if (messageModel.getStatus() == 1) {
            req.getSession().setAttribute("user", messageModel.getObject());
            resp.sendRedirect("index.jsp");
        }else {
            req.setAttribute("messageModel", messageModel);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
