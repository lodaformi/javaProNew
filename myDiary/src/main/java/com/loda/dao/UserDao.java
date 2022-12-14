package com.loda.dao;

import com.loda.entity.po.User;
import com.loda.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author loda
 * @Date 2022/11/4 16:53
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class UserDao {
    public User queryByName(String name) {
        User user = null;
        //
        Connection connection =null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 1. 获取数据库连接
            connection = DBUtil.getConnection();
            // 2. 定义sql语句
            String sql = "select * from tb_user where uname = ?";
            // 3. 预编译
            assert connection != null;
            ps = connection.prepareStatement(sql);
            // 4. 设置参数
            ps.setString(1, name);
            // 5. 执行查询，返回结果集
            rs = ps.executeQuery();
            // 6. 判断并分析结果集
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt(1));
                user.setUname(rs.getString(2));
                user.setUpwd(rs.getString(3));
                user.setNick(rs.getString(4));
                user.setHead(rs.getString(5));
                user.setMood(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7. 关闭资源
            DBUtil.closeRes(connection,rs, ps);
        }

        return user;
    }

    public User queryUserByNickAndUserId(String nick, Integer userId) {
//        1. 定义SQL语句
//                通过用户ID查询除了当前登录用户之外是否有其他用户使用了该昵称
//        指定昵称  nick （前台传递的参数）
//        当前用户  userId （session作用域中的user对象）
        String sql = "select * from tb_user where userid != ? and nick = ?";
//        2. 设置参数集合
        List<Object> list = new ArrayList<>();
        list.add(userId);
        list.add(nick);
//        3. 调用BaseDao的查询方法
        User user = (User) BaseDao.queryRow(sql, list, User.class);

        return user;
    }

    public int updateUser(User user) {
        // 1. 定义SQL语句
        String sql = "update tb_user set nick = ?, mood = ?, head = ? where userId = ? ";
        // 2. 设置参数集合
        List<Object> params = new ArrayList<>();
        params.add(user.getNick());
        params.add(user.getMood());
        params.add(user.getHead());
        params.add(user.getUserId());
        // 3. 调用BaseDao的更新方法，返回受影响的行数
        int row = BaseDao.updateOp(sql, params);
        return row;
    }
}
