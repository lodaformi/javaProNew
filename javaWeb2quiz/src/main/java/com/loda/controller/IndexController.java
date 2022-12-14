package com.loda.controller;

import com.loda.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author loda
 * @Date 2022/12/06 14:52
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class IndexController extends BaseController {

    /**
     * 系统登录页
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    // 系统界面欢迎页
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }
    /**
     * 后端管理主页面
     * @return
     */
    @RequestMapping("main")
    public String main(){
        return "main";
    }

    @RequestMapping("register")
    public String register() {
        return "register";
    }
}
