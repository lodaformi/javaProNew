package com.loda.factory;

import com.loda.dao.UserDao;

/**
 * @Author loda
 * @Date 2022/11/11 20:28
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class NormalFactory {
    public UserDao createUserDao() {
        return new UserDao();
    }
}
