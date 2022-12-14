package com.loda.test;

import com.loda.controller.UserServlet;
import com.loda.po.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Author loda
 * @Date 2022/11/11 9:35
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        // create and configure beans
        //相对路径
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        //绝对路径
//        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\Develop\\myJavaProjects\\mySpring01\\src\\main\\resources\\spring.xml");

        //多配置文件
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml", "spring02.xml");

        //总的配置文件导入其他文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring00.xml");
        // retrieve configured instance
        UserService userService = (UserService) ac.getBean("userService");
        UserServlet userServlet = (UserServlet) ac.getBean("userServlet");

        // use configured instance
        userService.test();
        userServlet.test();
    }
}
