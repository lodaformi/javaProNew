package com.loda.event;

import com.loda.mydemo.MyUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author loda
 * @Date 2022/10/15 22:46
 * @Description 模拟转账
 * @Version 1.0
 */
public class Transaction {
    public static void main(String[] args) throws SQLException {
        System.out.println(test("SMITH", "KING", 100));
    }


    public void test2() {


    }

    public static boolean test(String source, String dst, double money) {
        boolean flag = false;
        Connection conn = MyUtility.getConn();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "UPDATE EMP SET SAL = SAL + ? WHERE ENAME = ?";

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, -money);
            pstmt.setString(2, source);

            int rowNum1 = pstmt.executeUpdate();

//            int i = 1 / 0;

            pstmt.setDouble(1, money);
            pstmt.setString(2, dst);
            int rowNum2 = pstmt.executeUpdate();

            System.out.println("rownum1: " + rowNum1 + " ,rownum2: " + rowNum2);

            if (rowNum1 > 0 && rowNum2 > 0) {
                conn.commit();
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        MyUtility.close(conn, pstmt);
        return flag;
    }


}
