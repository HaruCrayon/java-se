package com.jdbc_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author LiJing
 * @version 1.0
 *  PreparedStatement 执行 select 语句
 */

@SuppressWarnings({"all"})
public class Jdbc04 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入名字:");//next(): 当接收到空格或者'就表示结束
        String admin_name = scanner.nextLine();//如果希望看到SQL注入，这里需要用nextLine
        System.out.print("请输入密码:");
        String admin_pwd = scanner.nextLine();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "select name,pwd from admin where name=? and pwd=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,admin_name);
        preparedStatement.setString(2,admin_pwd);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("失败");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
