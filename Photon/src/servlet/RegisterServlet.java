package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.impl.UserServiceImpl;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        // 获取帐号密码
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String nickName = request.getParameter("nickName");                                                     
        String email = request.getParameter("email");
        
        //创建用户Dao对象
        User user = new User(userName, password);
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail("test");
        user.setNickName("test");
        user.setHeadImage("test");
        
        //写入session
        //0失败 1成功 2已存在
        int flag = new UserServiceImpl().addUser(user);
        System.out.println(flag);//test
        if(flag == 0) {
            request.getSession().setAttribute("message", "注册失败，请重试");
            response.sendRedirect("register.jsp");
        }else if(flag == 1) {
            request.getSession().setAttribute("message", "注册成功");
            response.sendRedirect("login.jsp");
        }else if(flag == 2) {
            request.getSession().setAttribute("message", "注册失败，用户已存在");
            response.sendRedirect("register.jsp");
        }else {
            request.getSession().setAttribute("message", "服务器异常");
            response.sendRedirect("register.jsp");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
