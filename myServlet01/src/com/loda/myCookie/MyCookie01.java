package com.loda.myCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @Author loda
 * @Date 2022/10/29 9:56
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@WebServlet("/ck01")
public class MyCookie01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = URLEncoder.encode("来宪龙", "utf-8");
        String uname2 = URLEncoder.encode("来宪龙得到", "utf-8");
        Cookie ck4 = new Cookie(uname, uname2);
//        Cookie ck1 = new Cookie("来宪龙", "tom");
        Cookie ck2 = new Cookie("age", "18");
        Cookie ck3 = new Cookie("add", "cs");
//        ck1.setMaxAge(-1);
        ck2.setMaxAge(15);
        ck3.setMaxAge(0);

//        resp.addCookie(ck1);
        resp.addCookie(ck2);
        resp.addCookie(ck3);
        resp.addCookie(ck4);
    }
}
