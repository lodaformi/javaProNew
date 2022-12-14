package com.loda.dbtest;

import com.loda.dao.UserDao;
import org.junit.Test;

/**
 * @Author loda
 * @Date 2022/11/4 17:16
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class userTest {
    @Test
    public void queryByNameTest() {
        UserDao ud = new UserDao();
        System.out.println(ud.queryByName("admin"));
    }
}
