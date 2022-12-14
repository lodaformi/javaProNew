package com.loda.myspringsecurity01.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author loda
 * @Date 2022/12/10 17:26
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private String url;

    public MyAuthenticationSuccessHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        System.out.println("getRemoteAddr: "+request.getRemoteAddr());
        System.out.println("getRemoteUser: "+request.getRemoteUser());
        System.out.println("getRemotePort: "+request.getRemotePort());
        System.out.println("getRequestURL: "+request.getRequestURL());
        System.out.println("getRequestURI: "+request.getRequestURI());

        User user = (User) authentication.getPrincipal();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());
        response.sendRedirect(url);
    }
}
