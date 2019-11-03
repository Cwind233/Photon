package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import entity.User;
import service.impl.UserServiceImpl;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
	    String msg="";
	    JSONObject json=new JSONObject(); 
	    int flag = -1;
	    PrintWriter out=response.getWriter();
	    
        // 获取帐号密码  verify
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String verify= request.getParameter("verify");
//        String nickName = request.getParameter("userName");                                                     
        String email = request.getParameter("email");
        String checkVerify = request.getParameter("checkVerify");
        
        //判断验证码
        if(!checkVerify.equals(verify)) {
            flag = 9;
            json.put("flag",flag);
            out.print(json);
            return ;
        }
        
        //创建用户Dao对象
        User user = new User(userName, password);
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail("test");
        user.setNickName("test");
        user.setHeadImage("test");
        System.out.println(user.getUserName());
        //写入session
        //0失败 1成功 2已存在
        flag = new UserServiceImpl().addUser(user);
        System.out.println(flag);//test
        json.put("flag", flag);
        if(flag == 0) {
//            request.getSession().setAttribute("message", "注册失败，请重试");
//            response.sendRedirect("register.jsp");
            msg= "注册失败，请重试";
            json.put("msg",msg);
        }else if(flag == 1) {
//            request.getSession().setAttribute("message", "注册成功");
//            response.sendRedirect("login.jsp");
            msg= "注册成功";
            json.put("msg",msg);
        }else if(flag == 2) {
//            request.getSession().setAttribute("message", "注册失败，用户已存在");
//            response.sendRedirect("register.jsp");
            msg= "注册失败，用户已存在";
            json.put("msg",msg);
        }else {
//            request.getSession().setAttribute("message", "服务器异常");
//            response.sendRedirect("register.jsp");
            msg= "服务器异常";
            json.put("msg",msg);
        }
        out.print(json);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
