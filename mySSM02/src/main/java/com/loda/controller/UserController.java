package com.loda.controller;

import com.loda.entity.po.User;
import com.loda.exceptions.BusinessException;
import com.loda.exceptions.ParamsException;
import com.loda.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Author loda
 * @Date 2022/11/16 17:54
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("getUser")
    public String getUser(Integer id, Model model) {
        System.out.println("in UserController getUser method...");
//        int a=1/0;
//        if(1==1){
////            throw  new ParamsException();
//            throw  new BusinessException();
//        }
        User user = userService.queryUserById(id);
        model.addAttribute("user", user);
        return "user";
    }
}
