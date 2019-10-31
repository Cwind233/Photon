package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import entity.User;

/**
 * 
 * 数据库帮助类DBUtil
 * @author HZC
 */
public class DBUtil {
    private static final String dataBase_url = "jdbc:mysql://localhost:3306/Photon?useSSL=false";
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String dataBase_userName = "root";
    private static final String dataBase_password = "admin";//根据自己的数据库密码修改
    public static Connection connection = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet resultSet = null;
    
    /**
     *  数据库初始化连接
     * @return Connection
     * @throws ClassNotFoundException 
     * @throws SQLException 
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        connection = DriverManager.getConnection(dataBase_url, dataBase_userName, dataBase_password);
        return connection;
    }
    /**
     *  关闭数据库连接流
     * @param resultSet
     * @param stmt
     * @param connection
     * 
     */
    public static void closeAll(ResultSet resultSet, Statement stmt, Connection connection) {
        try {
            if(resultSet != null) {
                resultSet.close();
            }
            if(stmt != null) {
                stmt.close();
            }
            if(connection != null) {
                connection.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 执行sql语句
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public static PreparedStatement createPreParedStatement(String sql, Object[] params, Connection connection) throws SQLException, ClassNotFoundException{
        pstmt = connection.prepareStatement(sql);
        if(params != null) {
            for(int i = 0; i < params.length; i++) {
                pstmt.setObject(i+1, params[i]);
            }
        }
        return pstmt;
    }
    
    /**
     *  增删改
     * @param sql 
     * @param params  params数组里面放入的是 preparestatement语句的？值
     * @return
     */
    public static boolean executeUpdate(String sql, Object[] params) {
        try {
            connection = getConnection();
            pstmt = createPreParedStatement(sql, params, connection);
            int count = pstmt.executeUpdate();
            if(count > 0) {//返回0没修改
                return true;
            }else {
                return false;
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(null, (Statement)pstmt, connection);
        }
        return false;
    }
    //查 返回Result对象
    public static ResultSet executeQuery(String sql, Object[] params) {
        User user = null;
        try {
            connection = getConnection();
            pstmt = createPreParedStatement(sql, params, connection);
            resultSet = pstmt.executeQuery();
            return resultSet;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            
        }
        return null;
    }
    //添加新用户
    public static boolean addUser(String sql1, String sql2, Object[] params1, Object[] params2) {
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            pstmt = createPreParedStatement(sql1, params1, connection);
            pstmt.executeUpdate();
            pstmt = createPreParedStatement(sql2, params2, connection);
            pstmt.executeUpdate();
            connection.commit();
            return true;
        }catch (Exception e) {
            try {
                connection.rollback();
                return false;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(null, (Statement)pstmt, connection);
        }
        return false;
    }

}
