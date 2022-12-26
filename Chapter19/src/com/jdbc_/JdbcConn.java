package com.jdbc_;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author LiJing
 * @version 1.0
 * java获取数据库连接的5种方式
 */
public class JdbcConn {

    //方式1
    @Test
    public void connect01() throws SQLException {
        //1.注册驱动 new com.mysql.cj.jdbc.Driver()
        Driver driver = new Driver();

        //2.连接mysql
        String url = "jdbc:mysql://localhost:3306/db_test01";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "jing");

        Connection connect = driver.connect(url, properties);
        System.out.println("方式1 = " + connect);
    }

    //方式2
    @Test
    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类, 动态加载, 更加灵活, 减少依赖性
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/db_test01";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "jing");

        Connection connect = driver.connect(url, properties);
        System.out.println("方式2 = " + connect);
    }

    //方式3: 使用DriverManager 替代 driver 进行统一管理
    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/db_test01";
        String user = "root";
        String password = "jing";

        DriverManager.registerDriver(driver);//注册驱动
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式3 = " + connection);
    }

    //方式4: 使用Class.forName 自动完成注册驱动，简化代码
    //这种方式获取连接 使用的最多，推荐使用
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        //使用反射加载了 Driver类
        //在加载 Driver类时，完成注册
        /*
            源码: 1. 静态代码块，在类加载时，会执行一次.
            2. DriverManager.registerDriver(new Driver());
            3. 因此注册driver的工作已经完成
            static {
                try {
                    DriverManager.registerDriver(new Driver());
                } catch (SQLException var1) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
         */
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db_test01";
        String user = "root";
        String password = "jing";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式4 = " + connection);
    }

    //方式5: 在方式4的基础上改进，增加配置文件，让连接mysql更加灵活
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        //通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1.在加载Driver类时，完成注册驱动
        Class.forName(driver);
        //2.得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("方式5 = " + connection);
    }
}
