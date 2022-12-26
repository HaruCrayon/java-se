package com.jdbc_;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author LiJing
 * @version 1.0
 */

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //前置工作： 在项目下创建一个文件夹比如 libs
        //将 mysql-connector-j-8.0.31.jar 拷贝到该目录下，点击 add as library 加入到项目中

        //1.注册驱动 new com.mysql.cj.jdbc.Driver()
        Driver driver = new Driver();

        //2.得到连接
        //(1) jdbc:mysql:// 规定好表示协议，通过jdbc的方式连接mysql
        //(2) localhost 主机，可以是ip地址
        //(3) 3306 表示mysql监听的端口
        //(4) lee_db01 连接到mysql dbms 的哪个数据库
        //(5) mysql的连接本质就是socket连接
        String url = "jdbc:mysql://localhost:3306/db_test01";
        //将用户名和密码放入到Properties对象
        Properties properties = new Properties();
        //user 和 password 是规定好，后面的值根据实际情况写
        properties.setProperty("user", "root");
        properties.setProperty("password", "jing");
        Connection connect = driver.connect(url, properties);

        //3.执行SQL
//        String sql = "insert into actor values(null,'周星驰','男','1960-08-23','17700208364')";
//        String sql = "insert into actor values(null,'林青霞','女','1970-09-11','14512340000')";
//        String sql = "insert into actor values(null,'刘德华','男','1969-05-14','18912640890')";
//        String sql = "update actor set name='jack' where id=1";
        String sql = "delete from actor where id=3";

        //statement 用于执行静态SQL语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);// 如果是 dml语句，返回的就是影响行数

        System.out.println(rows > 0 ? "成功" : "失败");

        //4.关闭连接资源
        statement.close();
        connect.close();

    }
}
