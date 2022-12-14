package com.loda.DBTest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author loda
 * @Date 2022/11/15 23:19
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
// 将测试运行在Spring测试环境中
@RunWith(SpringJUnit4ClassRunner.class)
// 设置要加载的配置文件
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class DBBase {
}
