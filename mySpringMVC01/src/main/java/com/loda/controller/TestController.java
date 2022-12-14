package com.loda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author loda
 * @Date 2022/11/15 19:47
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class TestController {
    @RequestMapping("test")
    public void test(String a, String b) {
        System.out.println("TestController-->test: a " + a + ", b " + b);
    }
}
