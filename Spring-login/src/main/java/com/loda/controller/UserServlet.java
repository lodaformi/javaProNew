package com.loda.controller;

import com.loda.entity.po.User;
import com.loda.entity.vo.ResultInfo;
import com.loda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * @Author loda
 * @Date 2022/11/13 22:59
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class UserServlet {
    @Autowired
    private UserService userService;

    public void userLogin(String name, String pwd) {
        //接收参数

        //调用service方法
        ResultInfo<User> resultInfo = userService.userLogin(name, pwd);

        //返回状态
        if (resultInfo.getCode() == 1) {
            System.out.println("欢迎: " + resultInfo.getRsObj().getName() + "登陆！");
        } else if (resultInfo.getCode() == 0) {
            System.out.println("登陆失败："+ resultInfo.getMsg());
        }
    }
}
