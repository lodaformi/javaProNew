package com.loda.myspringsecurity01.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author loda
 * @Date 2022/12/12 15:35
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public interface MyService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
