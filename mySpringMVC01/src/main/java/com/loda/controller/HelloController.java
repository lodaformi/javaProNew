package com.loda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author loda
 * @Date 2022/11/15 16:04
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class HelloController {

    @RequestMapping("hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "hello springMVC");
        mv.setViewName("hello");
        return mv;
    }
}
