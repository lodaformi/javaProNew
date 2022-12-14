package com.loda.dao;

import com.loda.entity.po.User;

/**
 * @Author loda
 * @Date 2022/11/16 17:48
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public interface UserDao {
    public User queryUserById(Integer userId);
}
