package com.loda.myCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author loda
 * @Date 2022/10/29 10:00
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/ck02")
public class MyCookie02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cks = req.getCookies();
        if (cks != null && cks.length != 0) {
            for (Cookie cookie : cks) {
                System.out.println(URLDecoder.decode(cookie.getName(), "utf-8")+"-@-"+URLDecoder.decode(cookie.getValue(), "utf-8"));
            }
            System.out.println("--------------------");
            for (int i = 0; i < cks.length; i++) {
                System.out.println(URLDecoder.decode(cks[i].getName(), "utf-8")+"====="+URLDecoder.decode(cks[i].getValue(), "utf-8"));
            }
        }

    }
}
