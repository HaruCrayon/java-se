package com.jdbc_.dbutils_;

import com.jdbc_.datasource.JDBCUtilsByDruid;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author LiJing
 * @version 1.0
 * ResultSet 封装 => ArrayList
 */
public class SelectToArrayList {
    @Test
    public void testSelectToArrayList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
//        String sql = "select * from actor where id = ?";
        String sql = "select * from actor";
        ArrayList<Actor> list = new ArrayList<>();

        try {
            connection = JDBCUtilsByDruid.getConnection();
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

                list.add(new Actor(id, name, sex, borndate, phone));
            }
//            System.out.println(list);
            for (Actor actor : list) {
                System.out.println("id=" + actor.getId() + "\t" + "name=" + actor.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
    }
}
