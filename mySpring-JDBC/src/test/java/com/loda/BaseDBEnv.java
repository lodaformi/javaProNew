package com.loda;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author loda
 * @Date 2022/11/14 21:09
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)// 将测试运行在Spring测试环境中
@ContextConfiguration(locations = {"classpath:spring03.xml"})// 设置要加载的配置文件
public class BaseDBEnv {

}
