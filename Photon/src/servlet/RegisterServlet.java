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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String msg = "";
	JSONObject json = new JSONObject(); 
	int flag = -1;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
	    //创建输出流对象 设置编码
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    
        // 获取表单信息
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
//        String nickName = request.getParameter("nickName");                                              
        String email = request.getParameter("email");
        String verify= request.getParameter("verify");
        String checkVerify = request.getParameter("checkVerify");
        
        //校验用户输入文本  防止非法输入  输入正确返回 4
        if(CheckStringServiceImpl.CheckRegisterString(userName, password, email, verify) != 4) {
            flag = 8;//输入错误
            msg = "输入信息有误";
            json.put("msg", msg);
            json.put("flag",flag);
            out.print(json);
            return ;
        }
        
        //判断验证码
        if(!checkVerify.equals(verify)) {
            flag = 9;
            msg = "验证码错误";
            json.put("msg", msg);;
            json.put("flag",flag);
            out.print(json);
            return ;
        }
        
        //创建用户Dao对象
        User user = new User(userName, password);
        user.setEmail("test");//test
        user.setNickName("test");//test
        user.setHeadImage("test");//test
        System.out.println("密码"+user.getPassword());//test
        //0失败 1成功 2已存在 else服务器错误
        flag = new UserServiceImpl().addUser(user);
        System.out.println(flag);//test
        json.put("flag", flag);
        if(flag == 0) {
            msg = "注册失败，请重试";
            json.put("msg",msg);
        }else if(flag == 1) {
            msg = "注册成功";
            json.put("msg",msg);
        }else if(flag == 2) {
            msg = "注册失败，用户已存在";
            json.put("msg",msg);
        }else {
            msg = "服务器异常";
            json.put("msg",msg);
        }
        out.print(json);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
