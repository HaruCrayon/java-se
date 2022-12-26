package com.jdbc_.dbutils_;

import com.jdbc_.datasource.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author LiJing
 * @version 1.0
 * 使用 Apache-DBUtils工具类 + Druid数据库连接池 完成对表actor的crud操作
 */
public class DBUtils_use {

    //查询结果是多行记录
    @Test
    public void testQueryMany() throws SQLException {
        //1. 得到连接 (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();

        //组织 sql 语句
//        String sql = "select * from actor where id >= ?";
        //注意: sql 语句也可以查询部分列
        String sql = "select id, name, phone from actor where id >= ?";

        //2. 使用 DBUtils类和接口，先引入 DBUtils相关的jar包，加入到本Project
        //3. 创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 执行相关的方法，返回 ArrayList结果集
        List<Actor> list =
                queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);

        //(1) query 方法就是执行sql语句，得到resultSet ---封装到 ---> ArrayList 集合中
        //(2) 返回集合
        //(3) connection: 连接
        //(4) sql : 执行的sql语句
        //(5) new BeanListHandler<>(Actor.class): 将resultSet -> Actor 对象 -> 封装到 ArrayList
        //    底层使用反射机制 去获取Actor类的属性，然后进行封装
        //(6) 1 就是给 sql语句中的? 赋值，可以有多个值，因为是可变参数Object... params
        //(7) 底层得到的 resultSet 会在 query 关闭, 也会关闭 PreparedStatement

        for (Actor actor : list) {
            System.out.println(actor);
        }

        //释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }


    //查询结果是单行记录(单个对象)
    @Test
    public void testQuerySingle() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
//        String sql = "select * from actor where id = ?";
        String sql = "select id, name, phone from actor where id = ?";

        QueryRunner queryRunner = new QueryRunner();
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 4);
        System.out.println(actor);

        JDBCUtilsByDruid.close(null, null, connection);
    }

    //查询结果是单行单列-返回的就是object
    @Test
    public void testQueryScalar() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "select borndate from actor where id = ?";
        QueryRunner queryRunner = new QueryRunner();
        Object obj = queryRunner.query(connection, sql, new ScalarHandler<>(), 1);
        System.out.println(obj);

        JDBCUtilsByDruid.close(null, null, connection);
    }

    //dml (update, insert ,delete)
    @Test
    public void testDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
//        String sql = "update actor set name = ? where id = ?";
        String sql = "insert into actor values(null, ?, ?, ?, ?)";
//        String sql = "delete from actor where id = ?";

        QueryRunner queryRunner = new QueryRunner();
        int affectedRow = queryRunner.update(connection, sql, "林青霞", "女", "1990-02-07", "18900349654");
//        int affectedRow = queryRunner.update(connection, sql, 5);

        System.out.println(affectedRow > 0 ? "执行成功" : "执行没影响到表");

        JDBCUtilsByDruid.close(null, null, connection);
    }
}
