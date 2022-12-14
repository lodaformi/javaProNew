package com.loda.dao;

import com.loda.entity.po.User;
import org.springframework.stereotype.Repository;

/**
 * @Author loda
 * @Date 2022/11/13 22:59
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Repository
public class UserDao {
    private final String userName = "admin";
    private final String userPwd = "admin";

    /**
     通过用户名查询用户对象
           如果存在，返回对应的用户对象；如果不存在，返回null
     * @param name
     * @return
     */
    public User getUserByname(String name) {
        User user = null;

        if (!userName.equals(name)) {
            return user;  //user为null
        }

        user = new User();
        user.setName(userName);
        user.setPwd(userPwd);
       return user;
    }


}
