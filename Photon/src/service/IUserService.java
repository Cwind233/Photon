package service;

import entity.User;

/**
 * 
 * 逻辑层的增删改查
 * @author HZC
 */
public interface IUserService {

    public int addUser(User user);
    public int deleteUser(User user);
    public int updateUser(User user);
    public int queryUserPassword(User user);
    public User queryUserByUserName(User user);
    public int queryUserByemail(User user);
    public int updateUserGameRound(User user);
}
