/**
 * 
 */
package service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.IAddCookie;

/**
 * @author HZC
 * 把用户名和密码写入cookie 实现记住我功能
 */
public class AddCookieImpl implements IAddCookie {
    public static void addCookie_user(User user, HttpServletRequest request, HttpServletResponse response) {
        //创建cookie
        Cookie userNameCookie = new Cookie("userNameCookie", user.getUserName());
        Cookie passwordCookie = new Cookie("passwordCookie", user.getPassword());
        //设置保存cookie路径
        userNameCookie.setPath(request.getContextPath()+"/");
        passwordCookie.setPath(request.getContextPath()+"/");
        //把cookie加入到response
        response.addCookie(userNameCookie);
        response.addCookie(passwordCookie);
    }
}
