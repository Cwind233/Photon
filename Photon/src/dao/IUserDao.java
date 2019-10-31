package dao;

import entity.User;

/**
 * 
 *  最底层的增加删除修改查询
 * @author HZC
 */
public interface IUserDao {
    public boolean addUser(User user);
    public boolean deleteUser(User user);
    public boolean updateUser(User user);
    public boolean updateUserPassword(User user);
    public User queryPasswordByUserName(User user);
    public User queryUserByUserName(User user);
    public boolean queryUserByemail(User user);
}
