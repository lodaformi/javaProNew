package com.loda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Author loda
 * @Date 2022/11/15 19:33
 * @Description
 *      转发与重定向
 *      转发是默认行文
 *      重定向可以到页面，也可以重定向到其他视图
 * @Version 1.0
 */
@Controller
public class ForwardAndRedirect {
    // 页面重定向
    @RequestMapping("queryView1")
    public String queryView1() {
        return "redirect:v1.jsp";
    }

    // 重定向参数携带
    @RequestMapping("queryView2")
    public String queryView2() {
        return "redirect:v1.jsp?a=admin&b=123456";
    }

    // 重定向参数携带，中文乱码
    @RequestMapping("queryView3")
    public String queryView3() {
        return "redirect:v1.jsp?a=张三&b=123456";
    }

    // 重定向参数携带，乱码解决
    // 通过声明 RedirectAttributes 类型参数 携带重定向参数
    @RequestMapping("queryView4")
    public String queryView4(RedirectAttributes ra) {
        ra.addAttribute("a", "张三");
        ra.addAttribute("b","123456");
        return "redirect:v1.jsp";
    }

    // 重定向参数携带，乱码解决
    // 使用ModelAndview
    @RequestMapping("queryView5")
    public ModelAndView queryView5() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("a","奥利给");
        mv.addObject("b", "123456");
        mv.setViewName("redirect:v1.jsp");
        return mv;
    }

    /**
     * 转发到视图，不带参
     * @return
     */
    @RequestMapping("queryView6")
    public ModelAndView queryView6() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forward:test.do");
        return mv;
    }

    /**
     * 转发到视图，带参
     * @return
     */
    @RequestMapping("queryView7")
    public ModelAndView queryView7() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forward:test.do?a=admIn&b=123qwe");
        return mv;
    }

    /**
     * ModelAndView forward转发不能使用addObject赋值，其他视图获取不到值
     * @return
     */
    @RequestMapping("queryView8")
    public ModelAndView queryView8() {
        ModelAndView mv = new ModelAndView();
//        forward转发不能使用addObject赋值，其他动作获取不到值
//        mv.addObject("a","奥利给88");
//        mv.addObject("b", "12345688");
        mv.setViewName("forward:test.do?a=奥利给88&b=12345688");
        return mv;
    }

    /**
     * 重定向可以使用addObject传递变量
     * @return
     */
    @RequestMapping("queryView9")
    public ModelAndView queryView9() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("a","奥利给99");
        mv.addObject("b", "12345699");
        mv.setViewName("redirect:test.do");
        return mv;
    }
}
