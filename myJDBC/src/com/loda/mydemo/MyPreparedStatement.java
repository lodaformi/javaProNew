package com.loda.mydemo;

import java.sql.*;

/**
 * @Author loda
 * @Date 2022/10/15 17:43
 * @Description PreparedStatement 基本使用
 * @Version 1.0
 */
public class MyPreparedStatement {
    public static void main(String[] args) {
        preState("SMITH");
    }

    public static void preState(String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //创建连接
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "TIGER");
            //sql需求，将?占位符写在变量的位置，后续替换成变量
            String sql = "SELECT ENAME, EMPNO, JOB, SAL FROM EMP WHERE ENAME = ? OR ENAME = ?";
            //通过conn创建PreparedStatement，预处理sql
            pstmt = conn.prepareStatement(sql);
            //设置占位符为变量
            pstmt.setString(1, "SMITH");
            pstmt.setString(2, "KING");

            //执行sql
            rs =  pstmt.executeQuery();
            //解析结果集
            System.out.println("员工姓名\t员工编号\t工作\t\t薪水");
            while (rs.next()) {
                System.out.println(rs.getString(1)+"\t"+
                        rs.getInt(2)+"\t"+
                        rs.getString(3)+"\t"+
                        rs.getDouble(4));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally { //释放资源
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
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
        }

    }

}
