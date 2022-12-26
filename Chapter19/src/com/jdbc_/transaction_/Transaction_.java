package com.jdbc_.transaction_;

import com.jdbc_.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author LiJing
 * @version 1.0
 */
public class Transaction_ {
    @Test
    public void noTransaction() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql1 = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";

        try {
            connection = JDBCUtils.getConnection();//在默认情况下，connection是默认自动提交
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

            int i = 1 / 0;
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("执行发生了异常");
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void useTransaction() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql1 = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";

        try {
            connection = JDBCUtils.getConnection();//在默认情况下，connection是默认自动提交
            //将connection 设置为不自动提交
            connection.setAutoCommit(false);//开启了事务

            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

//            int i = 1 / 0;
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            //这里提交事务
            connection.commit();
            System.out.println("已提交事务");

        } catch (Exception e) {
            System.out.println("执行发生了异常");
            try {
                connection.rollback();
                System.out.println("执行了回滚，撤销已执行的sql");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

}
