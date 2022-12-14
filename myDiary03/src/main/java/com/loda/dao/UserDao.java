package com.loda.dao;

import com.loda.entity.po.User;

/**
 * @Author loda
 * @Date 2022/11/17 10:30
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public interface UserDao {
    //测试MyBatis是否可用
    public User queryUserByIdTest(Integer userId);
    //根据用户名查询对象
    public User queryUserByName(String userName);
    //根据用户ID更新用户（更新昵称nick、心情mood、照片head）
    Integer updateUser(User user);
}
