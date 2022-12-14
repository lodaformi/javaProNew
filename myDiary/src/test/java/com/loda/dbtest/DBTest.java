package com.loda.dbtest;

import com.loda.dao.BaseDao;
import com.loda.dao.UserDao;
import com.loda.entity.po.User;
import com.loda.util.DBUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/4 16:23
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class DBTest {
    private Logger logger = LoggerFactory.getLogger(DBTest.class);

    @Test
    public void connectionTest() {
        System.out.println(DBUtil.getConnection());
        logger.info("db connection: " + DBUtil.getConnection());
        logger.info("db {} connection.", DBUtil.getConnection());
    }

    @Test
    public void getList() {
        String sql = "SELECT * from tb_user WHERE mood = ?";
        List<Object> list = new ArrayList<>();
        list.add("Hello");
//        System.out.println(BaseDao.queryRows(sql, list, User.class));
        BaseDao.queryRows(sql, list, User.class).stream().forEach(System.out::println);
    }
}
