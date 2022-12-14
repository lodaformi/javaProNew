package com.loda.test;

import com.loda.mapper.UserMapper;
import com.loda.entity.po.User;
import com.loda.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author loda
 * @Date 2022/11/3 16:26
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        // 获取sqlSession对象
        SqlSession session = GetSqlSession.createSqlSession();
        //得到对应Mapper
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //调用方法，返回用户对象
        User user = userMapper.queryUserByName("admin");
        System.out.println(user);
    }
}
