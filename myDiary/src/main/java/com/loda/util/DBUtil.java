package com.loda.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author loda
 * @Date 2022/11/4 16:09
 * @Description 数据库工具类
 * @Version 1.0
 */
public class DBUtil {
    private static Properties properties = new Properties();

    /**
     * 静态代码块加载驱动，只需加载一次
     */
    static {
        try {
            // 加载配置文件（输入流）,通过load()方法将输入流的内容加载到配置文件对象中
//            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            // 通过配置文件对象的getProperty()方法获取驱动名，并加载驱动
            Class.forName(properties.getProperty("jdbcName"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("dbName"), properties.getProperty("dbPwd"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 关闭资源
     * @param connection  关闭数据库连接connection
     * @param rs            关闭ResultSet
     * @param ps            关闭PreparedStatement
     */
    public static void closeRes(Connection connection, ResultSet rs, PreparedStatement ps) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
