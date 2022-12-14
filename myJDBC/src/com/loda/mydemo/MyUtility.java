package com.loda.mydemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author loda
 * @Date 2022/10/15 18:00
 * @Description 工具类：读取配置文件，并将功能封装成方法
 * @Version 1.0
 */
public class MyUtility {
    private static Properties properties = new Properties();

    //静态代码块
    static {
        try {
            //加载配置文件
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            //加载驱动
            Class.forName(properties.getProperty("oracleDriven"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        try {
            return DriverManager.getConnection(properties.getProperty("oracleUrl"),
                    properties.getProperty("userName"), properties.getProperty("passwd"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn, Statement stmt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        close(conn, stmt);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
