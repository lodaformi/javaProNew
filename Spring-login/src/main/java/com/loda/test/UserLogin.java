package com.loda.test;

import com.loda.controller.UserServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author loda
 * @Date 2022/11/13 23:22
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class UserLogin {
    public static void main(String[] args) {
        String userName = "admin";
        String userPwd = "admin";

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        UserServlet userServlet = (UserServlet) ac.getBean("userServlet");
        userServlet.userLogin(userName, userPwd);
    }
}
