package com.loda;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author loda
 * @Date 2022/11/14 20:55
 * @Description 测试类
 * @Version 1.0
 */

public class Test02 {
    private JdbcTemplate jdbcTemplate;
    @Before
    public void before() {
        // 获取spring上下文环境
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        // 得到模板类 JdbcTemplate对象
        jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
    }

    @Test
    public void testDBEnv() {
        // 定义sql语句
        String sql = "select count(1) from tb_account";
        // 执行查询操作（无参数）
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class);

        System.out.println("total num: " + total);
    }

    @Test
    public void testDBEnv02() {
        // 定义sql语句
        String sql = "select count(1) from tb_account where user_id = ?";
        // 执行查询操作（有参数）
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class, 1);

        System.out.println("total num: " + total);
    }
}
