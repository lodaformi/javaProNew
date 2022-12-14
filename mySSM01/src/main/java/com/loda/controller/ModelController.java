package com.loda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author loda
 * @Date 2022/11/15 17:54
 * @Description
 * 请求域对象设置 API
 *    ModelAndView
 *    Model
 *    ModelMap
 *    Map
 *    Request
 * @Version 1.0
 */

@Controller
public class ModelController {
    @RequestMapping("m01")
    public ModelAndView m01() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "hello SpringMVC");
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping("m02")
    public String m02(HttpServletRequest req) {
        req.setAttribute("hello", "tom02");
        // 返回视图名
        return "hello";
    }

    @RequestMapping("m03")
    public String m03(ModelMap modelMap) {
        modelMap.addAttribute("hello", "tom03");
        // 返回视图名
        return "hello";
    }

    @RequestMapping("m04")
    public String m04(Model model) {
        System.out.println("m04");

        model.addAttribute("hello", "tom04");
        // 返回视图名
        return "hello";
    }

    @RequestMapping("m05")
    public String m05(Map map) {
        System.out.println("m05");
        map.put("hello", "hello m05");
        // 返回视图名
        return "hello";
    }
}
