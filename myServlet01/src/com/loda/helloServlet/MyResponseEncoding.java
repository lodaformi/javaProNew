package com.loda.helloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/10/28 19:33
 * @Description response 乱码与解决
 * @Version 1.0
 */
@WebServlet(value = "/myEncoding")
public class MyResponseEncoding extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getWriter()乱码和解决方法
        //方法一：
//        //声明服务端的编码方式
//        resp.setCharacterEncoding("utf-8");
//        //声明客户端的响应类型和编码方式
//        resp.setHeader("content-type", "text/html; charset=utf-8");
//        resp.getWriter().write("<h2>星期五1</h2>");

        //方法二
        //同时指定服务端和客户端的编码方式
//        resp.setContentType("text/html; charset=utf-8");
//        resp.getWriter().write("<h2>星期五2</h2>");

        //getOutputStream()乱码和解决方法
        //方法一：
        //声明客户端的响应类型和编码方式
//        resp.setHeader("content-type", "text/html; charset=utf-8");
//        //服务端对返回的内容使用utf-8编码处理
//        resp.getOutputStream().write("<h1>星期五3</h1>".getBytes("utf-8"));

        //方法二：
        //同时声明客户端和服务端的编码方式
        resp.setContentType("text/html; charset=utf-8");
        //实践发现上一行语句设置完之后，反倒是乱码了，服务端还是要指定编码方式
        resp.getOutputStream().write("<h1>星期五4ABChello</h1>".getBytes("utf-8"));
    }
}
