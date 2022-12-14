package com.loda.controller;

import com.loda.base.BaseController;
import com.loda.dao.UserMapper;
import com.loda.entity.po.LoginInfo;
import com.loda.entity.po.User;
import com.loda.entity.vo.ResultInfo;
import com.loda.entity.vo.UserFromInfo;
import com.loda.service.LoginInfoService;
import com.loda.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/12/6 15:16
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    @Resource
    private LoginInfoService loginInfoService;

    @PostMapping("login")
    @ResponseBody
    public ResultInfo login(User user, HttpServletRequest request) {
        User loginUser = userService.login(user);
//        System.out.println("ip addr: "+getIpAddr(request));
        //        System.out.println("ip addr: "+getClientIp(request));


        //获取用户ip
        Map<String, String> ipMap = getRequestHeadersInMap(request);
        String ip = ipMap.get("host");
        //设置返回对象
//        UserFromInfo userFromInfo = new UserFromInfo();
//        userFromInfo.setId(loginUser.getId());
//        userFromInfo.setUsername(loginUser.getUsername());
//        userFromInfo.setIp(ip);

        //设置时间格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeFormat  = LocalDateTime.now().format(dateTimeFormatter);
//        userFromInfo.setDate(timeFormat);
        System.out.println("timeFormat " + timeFormat);

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUserId(loginUser.getId());
        loginInfo.settLoginTime(LocalDateTime.now());
        loginInfo.settLoginIp(ip);
        recordLoginInfo(loginInfo);
        return success("登陆成功！", loginUser);
    }

//    @PostMapping("loginInfo")
//    @ResponseBody
    private ResultInfo recordLoginInfo(LoginInfo loginInfo) {
//        Cookie[] cookies = request.getCookies();
//        Integer userId = null;
//        //从cookie中获取用户id
//        for (Cookie cookie : cookies) {
//            if ("userId".equals(cookie.getName())) {
//                userId =  Integer.parseInt(cookie.getValue());
//            }
//        }
//        //查询用户
//        User user = null;
//        if (userId != null) {
//            user = userService.selectByPrimaryKey(userId);
//        }
//        if (user != null) {
//            loginInfo.setUserId(userId);
//            loginInfoService.insertSelective(loginInfo);
//        }
        loginInfoService.insertSelective(loginInfo);
        return success("存入数据成功！");
    }


    @PostMapping("checkName")
    @ResponseBody
    public ResultInfo checkName(String username) {
        User user = userService.checkName(username);
        return success("用户名可用！", user);
    }

    @PostMapping("register")
    @ResponseBody
    public ResultInfo register(User user) {
        userService.register(user);
        return success("注册成功！");
    }

    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null || ip.length() == 0 || " unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP ");
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP ");
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        return ip;
    }

    private static String getClientIp(HttpServletRequest request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }


    private Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {
        Map<String, String> result = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
//            String value = request.getHeader(key);
            if ("host".equals(key)) {
                String value = request.getHeader(key).split(":")[0];
                result.put(key, value);
            }
        }

        return result;
    }
}
