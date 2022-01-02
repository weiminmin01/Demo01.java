package edu.xcdq;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
         Tools.registerInfo();

        //注册驱动
        Class.forName(Tools.getDriver());
        //获取连接
        Connection connection= DriverManager.getConnection(Tools.getUrl(),Tools.getUser(),Tools.getPassword());
        //创建传输器
        Statement statement =connection.createStatement();
        //执行语句
        ResultSet resultSet=statement.executeQuery("select * from book");
        //遍历结果
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+resultSet.getString(2)+
                    resultSet.getString(3)+resultSet.getString(4));
        }
        //关闭资源
        Tools.closeAll(resultSet,statement,connection);
}}
