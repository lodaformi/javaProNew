package com.loda.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @Author loda
 * @Date 2022/11/18 15:51
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Repository
public class AccountDao {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String name;
    @Value("${jdbc.password}")
    private String pwd;

    public void printInfo() {
        test();
        System.out.println(driver + "--" + url + "--" + name + "--" + pwd);
    }

    public void test() {
        System.out.print("AccountDao test...");
    }
}
