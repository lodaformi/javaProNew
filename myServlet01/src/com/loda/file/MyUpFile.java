package com.loda.file;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/29 11:50
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/upFile")
@MultipartConfig
public class MyUpFile extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("file upload...");
        req.setCharacterEncoding("utf-8");
        String uname = req.getParameter("uname");
        System.out.println("uname: " + uname);

        Part part = req.getPart("myfile");

        //为什么没有这个方法part.getSubmittedFileName();？？？？？
        String fileName = part.getName();
        System.out.println("file name: " + fileName);

        String realPath = req.getServletContext().getRealPath("/");
        System.out.println("file absolute path: " + realPath);
        part.write(realPath + "/" + fileName);

    }
}
