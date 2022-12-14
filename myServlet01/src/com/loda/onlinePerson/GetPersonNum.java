package com.loda.onlinePerson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/31 9:03
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/pnum")
public class GetPersonNum extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");

        // 判断是否为空 (不为空，且值为logout则为退出操作)
        if (key != null && "logout".equals(key)) {
            //销毁会话
            req.getSession().invalidate();
            return;
        }
        HttpSession session = req.getSession();
//        Integer onlineNum = (Integer) session.getAttribute("onlineNum");

        Integer onlineNum = (Integer) session.getServletContext().getAttribute("onlineNum");
        resp.setContentType("text/html; charset=utf-8");
        //输出
        resp.getWriter().write("<h1>在线人数:"+onlineNum+"</h1>" +
                "<br><h4><a href='pnum?key=logout'>logout</a></h4>");
    }
}
