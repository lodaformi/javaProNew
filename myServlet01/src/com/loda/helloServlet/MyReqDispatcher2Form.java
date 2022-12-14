package com.loda.helloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Author loda
 * @Date 2022/10/29 8:45
 * @Description 请求转发
 * @Version 1.0
 */
@WebServlet("/dispatcher2form")
public class MyReqDispatcher2Form extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Servlet dispatcher2form!");
        //乱码解决
        //方法一：该方法只针对post请求有效（必须在接收所有的数据之前设定）
        req.setCharacterEncoding("utf-8");
        //方法二：
        //借助String的编码处理方法，先用ISO-8859-1解码，在使用utf-8处理
        // 获取客户端请求的完整URL （从http开始，到?前面结束）
        String url = req.getRequestURL().toString();
        System.out.println("get client's request full RUL: " + url);

        // 获取客户端请求的部分URL （从站点名开始，到?前面结束）
        String uri = req.getRequestURI();
        System.out.println("get client's request part RUL(URI): " + uri);

        // 获取请求行中的参数部分
        //parameter
        String queryStr = req.getQueryString();
        System.out.println("get parameters in request line: " + queryStr);

        // 获取客户端的请求方式
        String method = req.getMethod();
        System.out.println("get request method: " + method);

        // 获取HTTP版本号
        String protocol = req.getProtocol();
        System.out.println("get HTTP version: " + protocol);

        // 获取webapp名字 （站点名）
        String webapp = req.getContextPath();
        System.out.println("get web app name: " + webapp);

        //----------------------------------------------

        // 获取指定名称的参数，返回字符串
        String uname = new String(req.getParameter("uname").getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("uname value: " + uname);

        String pwd = req.getParameter("password");
        System.out.println("password value: " + pwd);

        // 获取指定名称参数的所有参数值，返回数组
        String[] citys = req.getParameterValues("city");
        System.out.println("city value: " + Arrays.toString(citys));

        // 获取指定名称参数的所有参数值，返回数组
        String[] hobbys = req.getParameterValues("hobby");
        System.out.println("hobby value: " + Arrays.toString(hobbys));

        // 获取指定名称参数的所有参数值，返回数组
        String sex = new String(req.getParameter("sex").getBytes("ISO-8859-1"), "utf-8");
        System.out.println("sex value: " + sex);


        // 获取指定名称参数的所有参数值，返回数组
        String[] switch2 = req.getParameterValues("switch");
        System.out.println("switch value: " + Arrays.toString(switch2));

        // 获取指定名称参数的所有参数值，返回数组
        String[] desc = new String[]{new String(req.getParameter("desc").getBytes("ISO-8859-1"), "utf-8")};
        System.out.println("desc value: " + Arrays.toString(desc));
    }
}
