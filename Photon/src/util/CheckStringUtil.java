/**
 * 
 */
package util;

/**
 * @author HZC
 *  校验字符串正确性
 */
public class CheckStringUtil {
    //校验用户名（帐号） 6-12位英文数字
    public static boolean CheckUserName(String userName) {
        String regex = "^[\\d\\w]{6,12}$";
        if(!isEmpty(userName)) {
            return userName.matches(regex);
        }
        return false;
    }
    //校验昵称 只能输入中文数字英文字母
    public static boolean CheckNickName(String nickName) {
        String regex = "^[A-Za-z0-9\\u4e00-\\u9fa5]+$";
        if(!isEmpty(nickName)) {
            return nickName.matches(regex);
        }
        return false;
    }
    //校验密码  6-12位英文数字
    public static boolean CheckPassword(String password) {
        String regex = "^[\\d\\w]{6,12}$";
        if(!isEmpty(password)) {
            return password.matches(regex);
        }
        return false;
    }
    //校验邮箱 4位数字
    public static boolean CheckEmail(String email) {
        String regex = "^[\\w\\d]{1,9}@[\\w\\d]{1,9}\\.[\\w]{2,3}$";
        if(!isEmpty(email)) {
            return email.matches(regex);
        }
        return false;
    }
    //校验验证码
    public static boolean CheckVerifyCode(String verify) {
        String regex = "[0-9]{4}";
        if(!isEmpty(verify)) {
            return verify.matches(regex);
        }
        return false;
    }
    //字符串判空
    public static boolean isEmpty(String string){
        return string == null || string.trim().length() == 0;
    }
    
    public static void main(String[] args) {
    }

}
