package com.loda.factory;

import com.loda.service.UserService;

/**
 * @Author loda
 * @Date 2022/11/11 20:11
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class StaticFactory {
    public static UserService createUserService() {
        return new UserService();
    }
}
