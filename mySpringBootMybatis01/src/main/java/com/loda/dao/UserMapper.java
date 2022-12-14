package com.loda.dao;

import com.loda.entity.po.User;
import com.loda.query.UserQuery;

import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/19 16:40
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public interface UserMapper {
    public User queryUserByUserName(String userName);

    public User queryUserById(Integer id);
    public int addUser(User user);
    public int updateUser(User user);
    public List<User> selectUsersByParams(UserQuery userQuery);
    public int delete(Integer id);
}
