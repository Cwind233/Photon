package service.impl;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.IUserService;
/**
 * 
 * @author HZC
 *
 */
public class UserServiceImpl implements IUserService {
    int flag = 0;
    IUserDao userDao = new UserDaoImpl();
    
    //增加新用户 = 查(存在)+增加
    //0失败 1成功 2已存在
    public int addUser(User user) {
        User queryUser = userDao.queryUserByUserName(user);
        System.out.println("addUser "+queryUser.getUserName()+"\n "+user.getUserName());
        if(user.getUserName().equals(queryUser.getUserName())) {
            flag = 2;
        }else {
            if(userDao.addUser(user)) {
                System.out.println("addUser "+"添加成功");//test
                flag = 1;
            }else {
                System.out.println("addUser "+"添加失败");//test
                flag = 0;
            }
        }
        return flag;
    }
    //更新用户信息 = 查(存在) + 改
    //   0 1更新成功     2不存在该用户
    public int updateUser(User user) {
        User queryUser = userDao.queryUserByUserName(user);
        if(queryUser.getUserName() == null) {
            flag = 2;
        }else if(user.getUserName().equals(queryUser.getUserName())) {
            if(userDao.updateUser(user)) {
                flag = 1;
            }
            else {
                flag = 2;
            }
        }
        return flag;
    }
    //校验密码   查询存在+比对密码
    //0校验失败 1校验成功 2用户不存在
    public int queryUserPassword(User user) {
        User queryUser = userDao.queryPasswordByUserName(user);
        //如果不存在返回2  存在 继续判断正确性
        if(queryUser.getUserName() == null) {
            flag = 2;
        }else if(queryUser.getPassword().equals(user.getPassword())) {
            flag = 1;
        }else {
            flag = 0;
        }
        return flag;
    }
    //直接查
    public User queryUserByUserName(User user) {
        User queryUser = userDao.queryUserByUserName(user);
        return queryUser;
    }
    //更改游戏关卡记录，先判断关卡大小，只有关卡数大于数据库中的关卡数才更新
    //1更改成功 0更改失败 2无需更改
    public int updateUserGameRound(User user) {
        int newGameRound = user.getGameRound();
        int oldGameRound = userDao.queryGameRoundByUserName(user).getGameRound();
        if(newGameRound > oldGameRound) {
            if(userDao.updateUserGameRound(user)) {
                flag = 1;
            }else {
                flag = 0;
            }
        }else {
            flag = 2;
        }
        return flag;
    }
    
    
    
    //直接查
    public int queryUserByemail(User user) {
        return flag;
    }
    //删除 = 查（存在）+删  无用
    public int deleteUser(User user) {
        return flag;
    }

    
}
