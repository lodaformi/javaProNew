package com.loda.controller;

import com.loda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/11/2 10:42
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/user")
public class UserServelet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UserServelet Test...");
        UserService.testService();
    }
}
