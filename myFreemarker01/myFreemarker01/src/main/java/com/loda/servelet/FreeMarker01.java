package com.loda.servelet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/11/2 20:21
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/fm01")
public class FreeMarker01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置数据 （给模板设置数据）
        req.setAttribute("msg", "hello Freemarker!!!O(∩_∩)O哈哈~");
        // 请求转发跳转到指定的模板页面   template/f01.ftl
        req.getRequestDispatcher("template/f01.ftl").forward(req, resp);
    }
}
