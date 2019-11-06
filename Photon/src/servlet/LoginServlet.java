package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.json.JSONObject;

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
	    int flag = -1;
	    //创建JSON对象
	    JSONObject json=new  JSONObject();
	    //创建输出流对象
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out=response.getWriter();
	     String msg="";
        // 获取帐号密码
        String userName = request.getParameter("uname");
        String password = request.getParameter("password");
        String verify = request.getParameter("verify");
        String checkVerify = request.getParameter("checkVerify");
        
        //判断验证码
        System.out.println(checkVerify);
        System.out.println(verify);
        if(!checkVerify.equals(verify)) {
            flag = 9;
            msg="验证码错误";
            json.put("msg", msg);
            json.put("flag",flag);
            out.print(json);
            return ;
        }
        
        
        //创建用户Dao对象
        User user = new User(userName, password);
        user.setUserName(userName);
        user.setPassword(password);
        
        user.setEmail("test");//tests
        user.setNickName("test");//test
        user.setHeadImage("test");//test
        System.out.println(user.getUserName() + "    "+ user.getPassword());
        //校验密码 返回flag  0失败 1成功 2不存在
        flag = new UserServiceImpl().queryUserPassword(user);
        System.out.println(flag);
        json.put("flag",flag);
        if(flag == 0) {
//            request.getSession().setAttribute("message", "登录失败，密码错误");
//            response.sendRedirect("login.jsp");//test
//            System.out.println("111");
//            response.sendRedirect("login.html");
            System.out.println("密码错误");
            msg="密码错误";
            json.put("msg", msg);
        }else if(flag == 1){//1可以
            //登录验证成功后，查询用户信息
            User queryUser = new User();
            queryUser = new UserServiceImpl().queryUserByUserName(user);
            //写入session
//            request.getSession().setAttribute("userName", queryUser.getUserName());
//            request.getSession().setAttribute("nickName", queryUser.getNickName());
//            request.getSession().setAttribute("headImage", queryUser.getHeadImage());
//            request.getSession().setAttribute("message", "登录成功");//test
//            response.sendRedirect("logintest.jsp");//test
//           json.put("message", "登录成功");
//            request.getRequestDispatcher("/Photon/WebContent/startgame.html").forward(request, response);
            json.put("userName", queryUser.getUserName());
            json.put("nickName", queryUser.getNickName());
            json.put("headImage", queryUser.getHeadImage());
            
            
        }else if(flag == 2) {
//            request.getSession().setAttribute("message", "登录失败，用户不存在");
//            response.sendRedirect("logintest.jsp");//test
//            response.sendRedirect("login.html");
            msg="登录失败，用户不存在";
            json.put("msg", msg);
        }else {
//            request.getSession().setAttribute("message", "服务器异常，请重试");
//            response.sendRedirect("logintest.jsp");//test
//            response.sendRedirect("login.html");
            msg="服务器异常，请重试";
            json.put("msg", msg);
        }
        System.out.println(json);
        
        out.print(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
