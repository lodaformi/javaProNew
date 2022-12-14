package com.loda.MySession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/29 10:51
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class Session01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession session = req.getSession();
        session.setAttribute("uname","tom");
        String uname = (String) session.getAttribute("uname");
        System.out.println("get name: "+ uname);

        session.removeAttribute("uname");
    }
}
