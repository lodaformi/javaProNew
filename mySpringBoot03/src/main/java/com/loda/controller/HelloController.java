package com.loda.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author loda
 * @Date 2022/11/18 18:52
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        return "Hello SpringBoot";
    }
}
