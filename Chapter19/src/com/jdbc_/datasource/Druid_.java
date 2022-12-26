package com.jdbc_.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author LiJing
 * @version 1.0
 */
public class Druid_ {

    @Test
    public void testDruid() throws Exception {
        //1. 加入jar包
        //2. 加入配置文件druid.properties , 将该文件拷贝到项目的src目录
        //3. 创建Properties对象, 读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        //4. 创建一个指定参数的数据库连接池, Druid 连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
//            System.out.println("连接OK~");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("Druid连接池 500000次耗时=" + (end - start));//Druid连接池 500000次耗时=686

    }
}
