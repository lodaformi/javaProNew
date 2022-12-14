package com.loda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author loda
 * @Date 2022/11/18 17:17
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */

//controller定义的方式有2种类型和3种实现
//2中类型:BeanName类型和@Controller类型
//3种实现：HttpRequestHandler，实现Controller，加@Controller

@Controller
public class HelloController {

    //handler --> controller
        /// /Spring MVC找Controller流程:
    ////1:扫描整个项目(Spring已经做了)定义一个Map集合//2:拿到所有加了@Controller注解的类
    /// /3:遍历类里面所有的方法对象
    ////4:判断方法是否加了ORequestMapping注解
    ////5:吧@RequestMapping注解的vlue作为 map集合的Key给put进去――吧method对象作为value放入map集合//6:根据用户发送的请求――拿到请求中的URI url:http://localhost:80/test.do uri:/test.do
    /// /7:使用请求的uri作为map的key去map里面get看看是否有返回值

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("print")
    @ResponseBody
    public String print() {
        return "hello world";
    }
}
