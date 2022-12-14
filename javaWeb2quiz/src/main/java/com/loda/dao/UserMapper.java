package com.loda.dao;

import com.loda.base.BaseMapper;
import com.loda.entity.po.User;
import com.loda.util.AssertUtil;

public interface UserMapper extends BaseMapper<User, Integer> {



    User queryUserByName(String username);

}