package com.loda.controller;

import com.loda.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @Author loda
 * @Date 2022/11/12 9:51
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Controller
public class ReportServlet {
    @Resource
    private ReportService reportService;

    public void test() {
        System.out.println("ReportServlet test...");
        reportService.test();
    }
}
