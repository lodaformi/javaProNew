package com.loda;

import com.loda.controller.NoteServlet;
import com.loda.controller.RoleServlet;
import com.loda.controller.TypeServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class test03 {
    public static void main( String[] args ) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring03.xml");

//        NoteServlet noteServlet = (NoteServlet) ac.getBean("noteServlet");
//        noteServlet.test();

        RoleServlet roleServlet = (RoleServlet) ac.getBean("roleServlet");
        roleServlet.test();
    }
}
