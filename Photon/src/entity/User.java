/**
 * 
 */
package entity;

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

    public User() {
        
    }
    public User(String userName) {
        this.userName = userName;
    }
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
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
    public User(String userName, String nickName, String password) {
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
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
    public void setPassword(String password) {
        this.password = password;
    }
}
