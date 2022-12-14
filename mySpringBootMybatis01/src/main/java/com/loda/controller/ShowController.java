package com.loda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author loda
 * @Date 2022/11/22 9:19
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class ShowController {
    @RequestMapping("index")
    public String show() {
        return "index";
    }
}
