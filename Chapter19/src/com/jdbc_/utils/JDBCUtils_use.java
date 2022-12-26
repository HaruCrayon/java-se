package com.jdbc_.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author LiJing
 * @version 1.0
 * 使用 JDBCUtils工具类，完成 dml和select
 */
@SuppressWarnings({"all"})
public class JDBCUtils_use {
    @Test
    public void testSelect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
//        String sql = "select * from actor where id = ?";
        String sql = "select * from actor";

        try {
            connection = JDBCUtils.getConnection();
            System.out.println(connection.getClass());//运行类型 com.mysql.cj.jdbc.ConnectionImpl
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
//            preparedStatement.setInt(1, 2);
            //执行，得到结果集
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date borndate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");

                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }

    @Test
    public void testDML() {//insert , update, delete
        Connection connection = null;
        PreparedStatement preparedStatement = null;
//        String sql = "update actor set name = ? where id = ?";
        String sql = "insert into actor(name,sex,borndate,phone) values(?,?,?,?)";

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1, "Tom");
            preparedStatement.setString(2, "男");
            preparedStatement.setString(3, "1990-05-17");
            preparedStatement.setString(4, "18735972234");
            //执行
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
