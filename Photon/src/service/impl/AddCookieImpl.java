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
 *   无用
 */
public class AddCookieImpl implements IAddCookie {
    public static void addCookie_user(User user, HttpServletRequest request, HttpServletResponse response) {
        //创建cookie
        Cookie userNameCookie = new Cookie("userNameCookie", user.getUserName());
        Cookie passwordCookie = new Cookie("passwordCookie", user.getPassword());
        //设置保存cookie路径
        userNameCookie.setPath(request.getContextPath()+"/");
        passwordCookie.setPath(request.getContextPath()+"/");
        String rememberMe = request.getParameter("rememberMe");
        if(rememberMe == null || rememberMe.equals(false)) {
            //不保存
            userNameCookie.setMaxAge(0);
            passwordCookie.setMaxAge(0);
        }else {
            userNameCookie.setMaxAge(7*24*60*60);
            passwordCookie.setMaxAge(7*24*60*60);
        }
        //把cookie加入到response
        response.addCookie(userNameCookie);
        response.addCookie(passwordCookie);
    }
}
