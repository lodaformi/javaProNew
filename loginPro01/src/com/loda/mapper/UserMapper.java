package com.loda.mapper;

import com.loda.entity.po.User;

/**
 * @Author loda
 * @Date 2022/11/3 16:16
 * @Description 接口
 * @Version 1.0
 */
public interface UserMapper {
    User queryUserByName(String userName);
}
