package com.loda.service;

import com.loda.Starter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author loda
 * @Date 2022/11/20 22:34
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Starter.class})
public class TestUserService {
    private Logger log = LoggerFactory.getLogger(TestUserService.class);

    @Autowired
    private UserService userService;

    @Before
    public void before() {
        log.info("单元测试开始...");
    }

    @After
    public void after() {
        log.info("单元测试结束...");
    }

    @Test
    public void testQueryUserByUserName() {
        System.out.println(userService);
        log.info(userService.queryUserByUserName("admin").toString());
    }
}
