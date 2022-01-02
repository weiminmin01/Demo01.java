package edu.xcdq;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Tools {
    private static   String url;
    private static String user;
    private static String password;
    private static String driver;
    public static  void  registerInfo() throws IOException {
        InputStream is=Demo01.class.getClassLoader().getResourceAsStream("database.properties");//读取配置文件
        Properties properties =new Properties();//属性
        properties. load(is);
         url=properties.getProperty("url");
         user= properties.getProperty("user");
        password=properties.getProperty("password");
       driver=properties.getProperty("driver" );

    }
    public  static void closeAll(ResultSet rs, Statement s, Connection con){
        if(rs !=null){
            try{
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            rs=null;
        }
        if(s!=null){
            try{
                s.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            s=null;
        }
        if(con!=null){
            try{
                con.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            s=null;
        }


    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDriver() {
        return driver;
    }
}
