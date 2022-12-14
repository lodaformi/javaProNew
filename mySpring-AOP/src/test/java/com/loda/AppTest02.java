package com.loda;

import com.loda.service.LogService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest02
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void logTest() {
        ApplicationContext ac =  new ClassPathXmlApplicationContext("spring02.xml");
        LogService logService = (LogService) ac.getBean("logService");
        logService.test();

    }
}
