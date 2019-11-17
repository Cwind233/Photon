package dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import dao.*;
import entity.User;
import util.DBUtil;
/**
 * 
 * @author HZC
 *
 */
public class UserDaoImpl implements IUserDao{
    private User user;
    
    //先写入个人信息表才能写入注册表
    public boolean addUser(User user) {
        String sql1 =  "insert into personalinformation(userName, nickName, email, headImage) values(?, ?, ?, ?)";
        Object[] params1 = {user.getUserName(), user.getNickName(), user.getEmail(), user.getHeadImage()};
        String sql2 = "insert into login(userName, password) values(?, ?)";
        Object[] params2 = {user.getUserName(), user.getPassword()};
        if(DBUtil.addUser(sql1, sql2, params1, params2)) {
            return true;
        }
        return false;
    }
    //更改游戏关卡记录
    public boolean updateUserGameRound(User user) {
        String sql = "update personalinformation set game rouond = ? where userName = ?";
        Object[] params = {user.getGameRound(), user.getUserName()};
        if(DBUtil.executeUpdate(sql, params)) {
            return true;
        }
        return false;
    }
    //TODO 更改个人信息 未完成
    public boolean updateUser(User user) {
        String sql = "update personalinformation set nickName  = ?, headImage = ? where userName = ?";
        Object[] params = {user.getNickName(), user.getHeadImage(), user.getUserName()};
        if(DBUtil.executeUpdate(sql, params)) {
            return true;
        }
        return false;
    }
    //TODO 更改密码 未完成
    public boolean updateUserPassword(User user) {
        String sql = "update login set password = ? where userName = ?";
        Object[] params = {user.getPassword(), user.getUserName()};
        if(DBUtil.executeUpdate(sql, params)) {
            return true;
        }
        return false;
    }
    //查 通过用户名查询用户信息
    public User queryUserByUserName(User user) {
        User queryUser = new User();
        String sql = "select * from personalinformation where userName = ?";
        String[] params = {user.getUserName()};
        ResultSet result = DBUtil.executeQuery(sql, params);
        try {
            while(result.next()) {
                 String userName = result.getString("userName");
                 String nickName = result.getString("nickName");
                 String headImage = result.getString("headImage");
                 String email = result.getString("email");
                 int gameRound = result.getInt("gameRound");
                 queryUser.setUserName(userName);
                 queryUser.setNickName(nickName);
                 queryUser.setEmail(email);
                 queryUser.setHeadImage(headImage);
                 queryUser.setGameRound(gameRound);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeAll(DBUtil.resultSet, (Statement)DBUtil.pstmt, DBUtil.connection);
            if(result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return queryUser;
    }
    //查 用用户名查密码
    public User queryPasswordByUserName(User user) {
        User queryUser = new User();
        String sql = "select * from login where userName = ?";
        String[] params = {user.getUserName()};
        ResultSet result = DBUtil.executeQuery(sql, params);
        try {
            while(result.next()) {
                 String userName = result.getString("userName");
                 String password = result.getString("password");
                 queryUser.setUserName(userName);
                 queryUser.setPassword(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeAll(DBUtil.resultSet, (Statement)DBUtil.pstmt, DBUtil.connection);
            if(result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return queryUser;
    }
    //查询用户关卡记录
    public User queryGameRoundByUserName(User user) {
        User queryUser = new User();
        String sql = "select gameRound from login where userName = ?";
        String[] params = {user.getUserName()};
        ResultSet result = DBUtil.executeQuery(sql, params);
        try {
            while(result.next()) {
                 int gameRound = result.getInt("gameRound");
                 queryUser.setGameRound(gameRound);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeAll(DBUtil.resultSet, (Statement)DBUtil.pstmt, DBUtil.connection);
            if(result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return queryUser;
    }
    //无用
    public boolean deleteUser(User user) {
        return false;
    }
    //无用
    public boolean queryUserByemail(User user) {
        return false;
    }



}
