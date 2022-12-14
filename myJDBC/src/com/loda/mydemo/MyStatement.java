package com.loda.mydemo;

import java.sql.*;

/**
 * @Author loda
 * @Date 2022/10/15 15:17
 * @Description JDBC Statement测试类，bug（sql注入）原因与代码示例
 * @Version 1.0
 */
public class MyStatement {
    public static void main(String[] args) {
//        ori_method();
        //如果sql语句中使用的是字符串拼接，那么有可能造成sql注入这种不安全的问题
        //例如，正规的传入SMITH2，查不到数据
//        bug_method("SMITH2");
        //拼接一个恒等式，能插到所有的数据
        // 第一个单引号是为了匹配sql中第一个单引号，
        // 最后一个单引号是为了匹配sql中最后一个单引号
        bug_method("SMITH' OR 1 = '1");    //传入一个不存在的数据，能查到所有的数据，不合理
    }

    public static void bug_method(String name) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "TIGER");
            stmt = conn.createStatement();

            //java.sql.SQLSyntaxErrorException: ORA-00904: "SMITH": 标识符无效
            //不能直接拼接，因为sql语句中，字符串须使用单引号''引起来
//            String sql = "SELECT ENAME,EMPNO,JOB, SAL FROM EMP WHERE ENAME = " + name;
            //字符串须使用单引号''引起来，再拼上单引号
//            String sql = "SELECT ENAME,EMPNO,JOB, SAL FROM EMP WHERE ENAME = '" + name +"'";
            //造成的问题，此时拼接一个恒等式，不管传入的姓名是否存在，条件都成立，那么选出的就是所有的结果
//            String sql = "SELECT ENAME, EMPNO, JOB, SAL FROM EMP WHERE ENAME = '" + name+"'" + "OR 1 = 1";
            //
            String sql = "SELECT ENAME, EMPNO, JOB, SAL FROM EMP WHERE ENAME = '" + name + "'";

            rs = stmt.executeQuery(sql);
            System.out.println("员工姓名\t员工编号\t工作\t\t薪水");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" +
                        rs.getInt(2) + "\t" +
                        rs.getString(3) + "\t" +
                        rs.getDouble(4));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void ori_method() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //创建连接
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "TIGER");
            //通过conn创建Statement对象
            stmt = conn.createStatement();
            //sql需求
            String sql = "SELECT ENAME,EMPNO,JOB, SAL FROM EMP";
            //发送sql语句，执行查询，拿到结果集
            rs = stmt.executeQuery(sql);
            System.out.println("员工姓名\t员工编号\t工作\t\t薪水");
            //如果有结果集，解析结果集
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" +
                        rs.getInt(2) + "\t" +
                        rs.getString(3) + "\t" +
                        rs.getDouble(4));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {                 //释放资源
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
