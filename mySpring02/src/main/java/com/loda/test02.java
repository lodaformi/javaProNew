package com.loda;

import com.loda.controller.TypeServlet;
import com.loda.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class test02 {
    public static void main( String[] args ) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring02.xml");

        TypeServlet typeServlet = (TypeServlet) ac.getBean("typeServlet");
        typeServlet.test();
    }
}
