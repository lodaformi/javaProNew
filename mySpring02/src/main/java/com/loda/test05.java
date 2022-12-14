package com.loda;

import com.loda.controller.ReportServlet;
import com.loda.service.ReportService;
import com.loda.service.RoleService;
import com.loda.util.PropertiesUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class test05 {
    public static void main( String[] args ) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring05.xml");

        ReportServlet reportServlet = (ReportServlet) ac.getBean("reportServlet");

        reportServlet.test();
//        PropertiesUtil propertiesUtil = (PropertiesUtil) ac.getBean("propertiesUtil");
//        propertiesUtil.test();
    }
}
