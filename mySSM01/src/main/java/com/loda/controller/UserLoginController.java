package com.loda.controller;

import com.loda.entity.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @Author loda
 * @Date 2022/11/16 15:14
 * @Description 用户操作
 * @Version 1.0
 */
@Controller
public class UserLoginController {
    @RequestMapping("/user/login")
    public ModelAndView userLogin(HttpSession session) {
        System.out.println("用户登陆...");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        User user = new User(23,"tom",2345.12);
        session.setAttribute("user", user);
        return mv;
    }

    @RequestMapping("/user/add")
    public ModelAndView userAdd(HttpSession session) {
        System.out.println("增加用户...");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        User user = new User(23,"tom",2345.12);
        session.setAttribute("user", user);
        return mv;
    }
}
