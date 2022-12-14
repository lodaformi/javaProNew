package com.loda.DBTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author loda
 * @Date 2022/11/15 23:25
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class SpDBTest01 extends DBBase {
    @Autowired
    private  JdbcTemplate jdbcTemplate;
//    @Before
//    public void dbInit() {
//        // 获取spring上下文环境
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//        // 得到模板类 JdbcTemplate对象
//        jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
//    }

    @Test
    public void test01() {
        //定义sql
        String sql = "select count(1) from tb_user";
        // 执行查询操作（无参数）
        Integer totalUser = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("totalUser is: " + totalUser);
    }
}
