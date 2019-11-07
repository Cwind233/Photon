/**
 * 
 */
package service.impl;

import service.ICheckStringService;
import util.CheckStringUtil;

/**
 * @author HZC
 *
 */
public class CheckStringServiceImpl implements ICheckStringService{
    /**
     * 
     * @param userName
     * @param password
     * @param verify
     * @return  输入正确返回3 输入错误返回其他数字
     */
    public static int CheckLoginString(String userName, String password, String verify) {
        int flag = 0;
        if(CheckStringUtil.CheckUserName(userName)) {
            flag++;
        }
        if(CheckStringUtil.CheckPassword(password)) {
            flag++;
        }
        if(CheckStringUtil.CheckVerifyCode(verify)) {
            flag++;
        }
        return flag;
    }
    /**
     * 
     * @param userName
     * @param password
     * @param email
     * @param verify
     * @return  输入正确返回4,输入错误返回其他
     */
    public static int CheckRegisterString(String userName, String password, String email, String verify) {
        int flag = 0;
        if(CheckStringUtil.CheckUserName(userName)) {
            flag++;
        }
        if(CheckStringUtil.CheckPassword(password)) {
            flag++;
        }
        if(CheckStringUtil.CheckEmail(email)) {
            flag++;
        }
        if(CheckStringUtil.CheckVerifyCode(verify)) {
            flag++;
        }
        return flag;
        
    }
}
