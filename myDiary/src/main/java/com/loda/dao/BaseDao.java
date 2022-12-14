package com.loda.dao;

/**
 * @Author loda
 * @Date 2022/11/4 20:56
 * @Description 数据库公用部分
 * @Version 1.0
 */

import com.loda.util.DBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 更新操作（增、删、改）
 * <p>
 * 查询操作
 * 结果为一个字段
 * 结果为一个对象集合
 * 结果为一个对象
 */
public class BaseDao {
    public static int updateOp(String sql, List<Object> list) {
        int row = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtil.getConnection();
            assert connection != null;
            ps = connection.prepareStatement(sql);
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    ps.setObject((i + 1), list.get(i));
                }
            }
            row = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeRes(connection, null, ps);
        }
        return row;
    }

    //查询：结果为一个字段
    public static Object querySingleValue(String sql, List<Object> list) {
        Object obj = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.getConnection();
            assert connection != null;
            ps = connection.prepareStatement(sql);
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    ps.setObject((i + 1), list.get(i));
                }
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeRes(connection, rs, ps);
        }
        return obj;
    }

    //    结果为一个对象集合
    public static List queryRows_1(String sql, List<Object> params, Class cls) {
        List list = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 得到数据库连接
            connection = DBUtil.getConnection();
            // 预编译
            preparedStatement = connection.prepareStatement(sql);
            // 如果有参数，则设置参数，下标从1开始
            if (params != null && params.size() > 0) {
                // 循环设置参数，设置参数类型为Object
                for (int i = 0; i < params.size(); i++) {
                    preparedStatement.setObject(i + 1, params.get(i));
                }
            }
            // 执行查询，返回结果集
            resultSet = preparedStatement.executeQuery();

            // 得到结果集的元数据对象（查询到的字段数量以及查询了哪些字段）
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            // 得到查询的字段数量
            int fieldNum = resultSetMetaData.getColumnCount();

            // 判断并分析结果集
            while (resultSet.next()) {
                // 实例化对象
                Object object = cls.newInstance();
                // 遍历查询的字段数量，得到数据库中查询的每一个列名
                for (int i = 1; i <= fieldNum; i++) {
                    // 得到查询的每一个列名
                    // getColumnLabel()：获取列名或别名
                    // getColumnName()：获取列名
                    String columnName = resultSetMetaData.getColumnLabel(i); // 如果是tb_user,userId字段
                    // 通过反射，使用列名得到对应的field对象
                    Field field = cls.getDeclaredField(columnName);
                    // 拼接set方法，得到字符串
                    String setMethod = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
                    // 通过反射，将set方法字符串反射成类中对应的set方法
                    Method method = cls.getDeclaredMethod(setMethod, field.getType());
                    // 得到查询的每一个字段对应的值
                    Object value = resultSet.getObject(columnName);
                    // 通过invoke方法调用set方法
                    method.invoke(object, value);
                }
                // 将Javabean设置到集合中
                list.add(object);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeRes(connection, resultSet, preparedStatement);
        }
        return list;
    }

    /**
     * 查询对象
     *
     * @param sql
     * @param params
     * @param cls
     * @return
     */
    public static Object queryRow(String sql, List<Object> params, Class cls) {
        List list = queryRows(sql, params, cls);
        Object object = null;
        // 如果集合不为空，则获取查询的第一条数据
        if (list != null && list.size() > 0) {
            object = list.get(0);
        }

        return object;
    }

    //结果为一个对象集合
    public static List queryRows(String sql, List<Object> params, Class cls) {
        //定义结果集合
        List list = new ArrayList<>();
        //获取数据库连接
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //定义sql
        //预编译
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
            //设置参数
            if (params != null && params.size() > 0) {
                for (int i = 0; i < params.size(); i++) {
                    ps.setObject((i + 1), params.get(i));
                }
            }
            //执行查询，得到结果
            rs = ps.executeQuery();
            //查询出的对象字段不确定，并且查询出的对象个数不确定
            //得到元数据，
            ResultSetMetaData metaData = rs.getMetaData();
            //得出查询出字段的个数
            int columnCount = metaData.getColumnCount();
            //判断结果是否为空
            while (rs.next()) {
                //创建对象
                // 通过反射给对应字段field设置值，思路：需拿到对应字段，拿到对应set方法，调用invoke
                Object instance = cls.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //通过元数据和索引得到查询出的字段名称
                    String columnLabel = metaData.getColumnLabel(i+1);
                    Field field = cls.getDeclaredField(columnLabel);
                    String methodName = "set" + columnLabel.substring(0,1).toUpperCase() + columnLabel.substring(1);
                    Method method = cls.getDeclaredMethod(methodName, field.getType());
                    method.invoke(instance, rs.getObject(columnLabel));
                }
                list.add(instance);
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeRes(connection, rs, ps);
        }
        return list;
    }

}
