package com.loda.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author loda
 * @Date 2022/11/18 18:52
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    public String index(Model model) {
//        model.addAttribute("msg", "hello SpringBoot&FreeMarker");
        model.addAttribute("msg", "hello SpringBoot&thymeleaf");
        return "index";
    }
}
