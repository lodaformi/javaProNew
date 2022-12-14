package com.loda.controller;

import com.loda.Starter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

/**
 * @Author loda
 * @Date 2022/11/20 22:44
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Starter.class})
@AutoConfigureMockMvc
public class TestUserController {
    private Logger log = LoggerFactory.getLogger(TestUserController.class);

    @Resource
    private MockMvc mockMvc;

    @Before
    public void before() {
        log.info("单元测试开始...");
    }

    @After
    public void after() {
        log.info("单元测试结束...");
    }

    @Test
    public void testQueryUserByUserName() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/name/admin")).
                andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        log.info("响应状态:{}",mvcResult.getResponse().getStatus());
        log.info("响应内容:{}",mvcResult.getResponse().getContentAsString());
    }
}
