package DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author HZC
 *   数据库连接
 */
public class ConnectToDB {
    String dataBase_url = "jdbc:mysql://localhost:3306/数据库名字";
    String driverName = "com.mysql.jdbc.Driver";
    String dataBase_userName = "root";
    String dataBase_password = "admin";//根据自己的数据库密码修改
    
    
    public ConnectToDB() {
        try {
            Class.forName(driverName);
        } catch(ClassNotFoundException e) {
            System.out.println("提示信息");//提示信息ufinish
            e.printStackTrace();
        }
    }
    /**
     * 
     * @return Connection
     */
    public Connection getConnextion() {
        try {
            return DriverManager.getConnection(dataBase_url, dataBase_userName, dataBase_password);
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
        return null;
    }
    
    //测试用test
    public static void main(String[] args) {
        
    }
}
