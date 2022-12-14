package com.loda.filter;

import com.loda.entity.po.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/11/5 17:33
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */

/**
 * * 非法访问拦截
 * *  拦截的资源：
 * *      所有的资源   /*
 * *
 * *      需要被放行的资源
 * *          1. 指定页面，放行 （用户无需登录的即可访问的页面；例如：登录页面login.jsp、注册页面register.jsp等）
 * *          2. 静态资源，放行 （存放在statics目录下的资源；例如：js、css、images等）
 * *          3. 指定行为，放行 （用户无需登录即可执行的操作；例如：登录操作actionName=login等）
 * *          4. 登录状态，放行 （判断session作用域中是否存在user对象；存在则放行，不存在，则拦截跳转到登录页面）
 * *
 * *  免登录（自动登录）
 * *      通过Cookie和Session对象实现
 * *
 * *      什么时候使用免登录：
 * *          当用户处于未登录状态，且去请求需要登录才能访问的资源时，调用自动登录功能
 * *
 * *      目的：
 * *          让用户处于登录状态（自动调用登录方法）
 * *
 * *      实现：
 * *          从Cookie对象中获取用户的姓名与密码，自动执行登录操作
 * *              1. 获取Cookie数组  request.getCookies()
 * *              2. 判断Cookie数组
 * *              3. 遍历Cookie数组，获取指定的Cookie对象 （name为user的cookie对象）
 * *              4. 得到对应的cookie对象的value （姓名与密码：userName-userPwd）
 * *              5. 通过split()方法将value字符串分割成数组
 * *              6. 从数组中分别得到对应的姓名与密码值
 * *              7. 请求转发到登录操作  user?actionName=login&userName=姓名&userPwd=密码
 * *              8. return
 * *
 * *     如果以上判断都不满足，则拦截跳转到登录页面
 */
@WebFilter("/*")
public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();  // 格式：项目路径/资源路径
        System.out.println("filter uri: "+ uri);
//        1. 指定页面，放行 （用户无需登录的即可访问的页面；例如：登录页面login.jsp、注册页面register.jsp等）
        if (uri.contains("login.jsp") || uri.contains("register.jsp") ) {
//            ||  uri.contains("note/list.jsp") || uri.contains("type/list.jsp") || uri.contains("user/list.jsp")) {
            chain.doFilter(req, resp);
            return;
        }

//        2. 静态资源，放行 （存放在statics目录下的资源；例如：js、css、images等）
        if (uri.contains("statics") ) {
            chain.doFilter(req, resp);
            return;
        }
//         3. 指定行为，放行（用户无需登录即可执行的操作；例如：登录操作actionName=login等）
        if (uri.contains("user")){
            String acName = req.getParameter("actionName");
            if ("login".equals(acName)) {
                chain.doFilter(req, resp);
                return;
            }
        }

//         4. 登录状态，放行 （判断session作用域中是否存在user对象；存在则放行，不存在，则拦截跳转到登录页面）
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            chain.doFilter(req, resp);
            return;
        }

        //5: 免登录
//        1. 获取Cookie数组  request.getCookies()
        Cookie[] cookies = req.getCookies();
//        2. 判断Cookie数组
        if (cookies != null && cookies.length > 0) {
//            3. 遍历Cookie数组，获取指定的Cookie对象 （name为user的cookie对象）
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
//                    4. 得到对应的cookie对象的value （姓名与密码：userName-userPwd）
                    String namePwd = cookie.getValue();
//                    5. 通过split()方法将value字符串分割成数组
                    String[] split = namePwd.split("-");
//                    6. 从数组中分别得到对应的姓名与密码值
                    String name = split[0];
                    String pwd = split[1];
//                    7. 请求转发到登录操作  user?actionName=login&rem=1&userName=姓名&userPwd=密码
                    String uri2 = "user?actionName=login&rem=1&userName=" + name + "&userPwd=" + pwd;
                    req.getRequestDispatcher(uri2).forward(req, resp);
//                    resp.sendRedirect(uri2);
//                     8. return
                    return;
                }
            }
        }
        //不是以上情况都跳转到登陆页面
        resp.sendRedirect("login.jsp");
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
    }
}
