package com.clevermis.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @program: YouthWork
 * @description: 数据库基类
 * @author: Clevermis
 * @create: 2023-01-07 11:21
 * @since JDK 1.8
 **/
public class DataBaseDao {

    /**
    * @methodname  static initializer  的功能描述  TODO:静态代码块，在类加载的时候执行
    *
    * @Param:  * @param null
    * @return:
    * @throw:
    *
    * @Author: Clevermis
    * @version: V1.0.0
    * @Date: 2023/1/7 11:21
    */
    static {
        init();
    }
        private static String driver;
        private static String url;
        private static String username;
        private static String password;

        /**
        * @methodname  init  的功能描述 TODO:初始化连接参数,从配置文件里获得
        *
        * @Param:  * @param
        * @return: void
        * @throw:
        *
        * @Author: Clevermis
        * @version: V1.0.0
        * @Date: 2023/1/7 11:23
        */
    public static void init(){
        Properties properties = new Properties();
        String configFile = "db.properties";
        InputStream inputStream = DataBaseDao.class.getClassLoader().getResourceAsStream(configFile);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        username=properties.getProperty("username");
        password=properties.getProperty("password");
    }

    /**
    * @methodname  getConnection  的功能描述 TODO:获取数据库连接
    *
    * @Param:  * @param 
    * @return: java.sql.Connection
    * @throw: 
    *
    * @Author: Clevermis
    * @version: V1.0.0
    * @Date: 2023/1/7 11:33
    */
    public static Connection getConnection() {
        Connection connection =null;
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }

    /**
    * @methodname  execute  的功能描述 TODO:查询公共类
    *
    * @Param:  * @param connection
     * @param pstm
     * @param rs
     * @param sql
     * @param params
    * @return: java.sql.ResultSet
    * @throw: Exception
    *
    * @Author: Clevermis
    * @version: V1.0.0
    * @Date: 2023/1/7 11:34
    */
    public static ResultSet execute(Connection connection, PreparedStatement pstm, ResultSet rs, String sql, Object[] params)throws Exception{
        pstm = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i+1,params[i]);
        }
        rs=pstm.executeQuery();
        return rs;
    }

    /**
    * @methodname  execute  的功能描述  TODO:增删改公共类
    *
    * @Param:  * @param connection
     * @param pstm
     * @param sql
     * @param params
    * @return: int
    * @throw: Exception
    *
    * @Author: Clevermis
    * @version: V1.0.0
    * @Date: 2023/1/7 11:40
    */
    public static int execute(Connection connection, PreparedStatement pstm, String sql, Object[] params) throws Exception{
        int updateRows = 0;
        pstm = connection.prepareStatement(sql);

        for(int i = 0; i < params.length; i++){
            pstm.setObject(i+1, params[i]);
        }
        updateRows = pstm.executeUpdate();
        return updateRows;
    }

    /**
    * @methodname  closeResource  的功能描述 TODO:释放资源
    *
    * @Param:  * @param connection
     * @param pstm
     * @param rs
    * @return: boolean
    * @throw: SQLException
    *
    * @Author: Clevermis
    * @version: V1.0.0
    * @Date: 2023/1/7 12:11
    */
    public static boolean closeResource(Connection connection,PreparedStatement pstm,ResultSet rs){
        boolean flag = true;
        if(rs != null){
            try {
                rs.close();
                //GC回收
                rs = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        if(pstm != null){
            try {
                pstm.close();
                //GC回收
                pstm = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        if(connection != null){
            try {
                connection.close();
                //GC回收
                connection = null;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

}
