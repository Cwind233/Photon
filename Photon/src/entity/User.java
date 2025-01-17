/**
 * 
 */
package entity;

import util.MD5Util;

/**
 * @author HZC
 *   User对象实体
 */
public class User {
    
    private String userName = null;
    private String nickName = null;
    private String password = null;
    private String email = null;
    private String headImage = null;
    private int gameRound = 0;

    public User() {
        
    }
    public User(String userName) {
        this.userName = userName;
    }
    public User(String userName, String password) {
        this.userName = userName;
//        this.password = password;
        //MD5加密密码
        this.password = MD5Util.getMD5String(password);
    }
    public User(String userName, String nickName, String password) {
        this.userName = userName;
        this.nickName = nickName;
//      this.password = password;
      //MD5加密密码
      this.password = MD5Util.getMD5String(password);
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getHeadImage() {
        return headImage;
    }
    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPassword() {
        return password;
    }
    //用set方法设置的password没有经过加密
    public void setPassword(String password) {
        this.password = password;
    }
    public int getGameRound() {
        return gameRound;
    }
    public void setGameRound(int gameRound) {
        this.gameRound = gameRound;
    }
}
