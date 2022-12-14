package com.loda.interceptor;

import com.loda.entity.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author loda
 * @Date 2022/11/17 16:11
 * @Description 拦截器（非法登陆拦截到登录页面）
 * @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 格式：项目路径/资源路径
        String uri = request.getRequestURI();
        System.out.println("uri: " + uri);

//        1. 指定页面，放行 （用户无需登录的即可访问的页面；例如：登录页面login.jsp、注册页面register.jsp等）
        if (uri.contains("login.jsp") || uri.contains("register.jsp")) {
            return true;
        }

        //2. 静态资源，放行 （存放在statics目录下的资源；例如：js、css、images等）
        if (uri.contains("statics") ) {
            return true;
        }

        //3. 指定行为，放行（用户无需登录即可执行的操作；例如：登录操作actionName=login等）
        if (uri.contains("user.do")) {
            String acName = request.getParameter("actionName");
            if ("login".equals(acName)) {
                return true;
            }
        }
        //4.登录状态，放行 （判断session作用域中是否存在user对象；存在则放行，不存在，则拦截跳转到登录页面）
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
//            String url = "user.do?actionName=userCenter";
//            //重定向或者转发到登陆界面
//            response.sendRedirect(url);
            return true;
        }

        //5: 免登录
        //获取cookie
        Cookie[] cookies = request.getCookies();
        //如果cookie存在
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("userName".equals(cookie.getName())) {
                    String userInfo = cookie.getValue();
                    String name = userInfo.split("-")[0];
                    String pwd = userInfo.split("-")[1];
                    String url = "user.do?actionName=login&rem=1&userName="+name+"&userPwd="+pwd;
                    //重定向或者转发到登陆界面
                    response.sendRedirect(url);
                    return true;
                }
            }
        }
        //其他情况均拦截到登陆界面
//        response.sendRedirect(request.getContextPath()+"/login.jsp");
        response.sendRedirect("/login.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
