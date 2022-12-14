package com.loda;

import com.loda.controller.RoleServlet;
import com.loda.service.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class test04 {
    public static void main( String[] args ) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring04.xml");
        RoleService roleService = (RoleService) ac.getBean("roleService");
        roleService.test();
    }
}
