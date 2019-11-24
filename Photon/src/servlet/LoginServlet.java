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
import service.impl.CheckStringServiceImpl;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private int flag = -1;
	private JSONObject json = new JSONObject();
	private String msg="";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    request.setCharacterEncoding("utf-8");
	    
	    //创建输出流对象 设置编码
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	     
        // 获取帐号密码
        String userName = request.getParameter("uname");
        String password = request.getParameter("password");
        String verify = request.getParameter("verify");
        String checkVerify = request.getParameter("checkVerify");
        
        //验证用户输入  输入正确返回 3  有bug
        if(CheckStringServiceImpl.CheckLoginString(userName, password, verify) != 3) {
            flag = 8;//输入错误
            msg = "输入信息有误";
            json.put("msg", msg);
            json.put("flag",flag);
            out.print(json);
            return ;
        }
        
        //判断验证码
        System.out.println(checkVerify);//test
        System.out.println(verify);//test
        if(!checkVerify.equals(verify)) {
            flag = 9;//验证码错误
            msg = "验证码错误";
            json.put("msg", msg);
            json.put("flag",flag);
            out.print(json);
            return ;
        }
        
        //创建用户Dao对象
        User user = new User(userName, password);
        user.setEmail("test");//tests
        user.setNickName("test");//test
        user.setHeadImage("test");//test
        System.out.println(user.getUserName() + " \n   "+ user.getPassword());//test
        
        //校验密码 返回flag  0失败 1成功 2不存在
        flag = new UserServiceImpl().queryUserPassword(user);
        System.out.println("flag:"+flag);//test
        json.put("flag",flag);
        if(flag == 0) {
            System.out.println("密码错误");
            msg = "密码错误";
        }else if(flag == 1){//1可以
            //登录验证成功后，查询用户信息
            User queryUser = new User();
            queryUser = new UserServiceImpl().queryUserByUserName(user);
            json.put("userName", queryUser.getUserName());
            json.put("nickName", queryUser.getNickName());
            json.put("headImage", queryUser.getHeadImage());
            json.put("gameRound", queryUser.getGameRound());
            msg = "登录成功";
        }else if(flag == 2) {
            msg = "登录失败，用户不存在";
        }else {
            msg = "服务器异常，请重试";
        }
        json.put("msg", msg);
        System.out.println("json:"+json);//test
        out.print(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
