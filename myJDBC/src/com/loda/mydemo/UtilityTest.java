package com.loda.mydemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author loda
 * @Date 2022/10/15 22:34
 * @Description MyUtility 测试类
 * @Version 1.0
 */
public class UtilityTest {
    public static void main(String[] args) throws SQLException {
        //获取数据库连接
        Connection conn = MyUtility.getConn();
//        System.out.println(conn);

        //sql需求
        String sql = "SELECT ENAME, EMPNO, JOB, SAL FROM EMP WHERE ENAME = ? OR ENAME = ?";
        //预编译sql语句
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置占位符
        pstmt.setString(1, "SMITH");
        pstmt.setString(2, "KING");
        //执行查询
        ResultSet rs = pstmt.executeQuery();
        //解析结果集
        System.out.println("员工姓名\t员工编号\t工作\t\t薪水");
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" +
                    rs.getInt(2) + "\t" +
                    rs.getString(3) + "\t" +
                    rs.getDouble(4));
        }

        MyUtility.close(conn, pstmt, rs);
    }
}
