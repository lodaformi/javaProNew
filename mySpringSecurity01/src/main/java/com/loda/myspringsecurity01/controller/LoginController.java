package com.loda.myspringsecurity01.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author loda
 * @Date 2022/12/10 9:04
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public String login() {
        System.out.println("login method");
        return "redirect:main.html";
    }

    //@Secured 是专门用于判断是否具有角色的,能写在方法或类上。参数要以 ROLE_开头。
//    @Secured("ROLE_loda")
    //PreAuthorize的表达式允许ROLE_开头，也可以不以ROLE_开头，配置类不允许ROLE_开头
    @PreAuthorize("hasAnyRole(\"loda\")")
    @RequestMapping("toMain")
    public String toMain() {
        return "redirect:/main.html";
    }
    @RequestMapping("/toError")
    public String toError() {
        return "redirect:/error.html";
    }

    @RequestMapping("demo")
//    @ResponseBody
    public String demo() {
        return "demo";
    }
}
