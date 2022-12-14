package com.loda.service;

import com.loda.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author loda
 * @Date 2022/11/18 15:51
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public void test() {
        System.out.println("userService test...");
        userDao.test();
    }
}
