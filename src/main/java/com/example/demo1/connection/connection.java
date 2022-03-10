package com.example.demo1.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    数据库相关操作
 */
public class connection {


    public void connection1() {
        try {
        // 加载驱动类
            Class.forName("org.opengauss.Driver");
            System.out.println("jdbc加载成功");
            /* 创建数据库连接对象 */
            Connection conn= DriverManager.getConnection(
                    "jdbc:opengauss://121.36.60.12:5432/remote_db","remote_user","huawei+123"
            );
            System.out.println("数据库连接成功");
            conn.close();
        }catch (ClassNotFoundException notfound){
            notfound.printStackTrace();
        }catch (SQLException sql){
            sql.printStackTrace();
        }
    }

}
