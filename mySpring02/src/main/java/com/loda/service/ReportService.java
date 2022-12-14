package com.loda.service;

import com.loda.dao.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author loda
 * @Date 2022/11/12 9:52
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class ReportService {
    @Resource
    private ReportDao reportDao;

    public void test() {
        System.out.println("ReportService test...");
        reportDao.test();
    }
}
