package com.loda.fieldObj;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/29 22:41
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/context")
public class MyServletContext extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletContext servletContext = req.getServletContext();
//        ServletContext servletContext = req.getSession().getServletContext();
//        ServletContext servletContext = getServletConfig().getServletContext();
        ServletContext servletContext = getServletContext();
        String realPath = servletContext.getRealPath("/");
        String serverInfo = servletContext.getServerInfo();

        System.out.println("realPath: "+ realPath);
        System.out.println("serverInfo: " + serverInfo);

        System.out.println("indexof / : "+serverInfo.indexOf("/"));
        System.out.println("indexof . : "+serverInfo.indexOf("."));
        System.out.println(serverInfo.substring(serverInfo.indexOf("/")+1, serverInfo.indexOf(".")));
    }
}
