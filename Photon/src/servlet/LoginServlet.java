package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    request.setCharacterEncoding("utf-8");
        // 获取帐号密码
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        //创建用户Dao对象
        User user = new User(userName, password);
        user.setUserName(userName);
        user.setPassword(password);
        
        user.setEmail("test");//tests
        user.setNickName("test");//test
        user.setHeadImage("test");//test
        System.out.println(userName+password);//test
        
        //校验密码 返回flag  0失败 1成功 2不存在
        int flag = new UserServiceImpl().queryUserPassword(user);
        System.out.println(flag);//test
        if(flag == 0) {
            request.getSession().setAttribute("message", "登录失败，密码错误");
            response.sendRedirect("logintest.jsp");//test
            System.out.println("登录失败密码错误");//test
        }else if(flag == 1){//1可以
            //登录验证成功后，查询用户信息
            User queryUser = new User();
            queryUser = new UserServiceImpl().queryUserByUserName(user);
            //写入session
            request.getSession().setAttribute("userName", queryUser.getUserName());
            request.getSession().setAttribute("nickName", queryUser.getNickName());
            request.getSession().setAttribute("headImage", queryUser.getHeadImage());
            request.getSession().setAttribute("message", "登录成功");//test
            response.sendRedirect("logintest.jsp");//test
            System.out.println("登录成功");//test
        }else if(flag == 2) {
            request.getSession().setAttribute("message", "登录失败，用户不存在");
            response.sendRedirect("logintest.jsp");//test
            System.out.println("登录失败用户不存在");//test
        }else {
            request.getSession().setAttribute("message", "服务器异常，请重试");
            response.sendRedirect("logintest.jsp");//test
            System.out.println("登录失败服务器异常");//test
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
