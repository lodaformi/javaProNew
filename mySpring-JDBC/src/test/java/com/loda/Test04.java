package com.loda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author loda
 * @Date 2022/11/14 20:55
 * @Description 测试类
 * @Version 1.0
 */

public class Test04 extends BaseDBEnv {
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
