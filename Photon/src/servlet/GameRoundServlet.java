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

/**
 * 游戏关卡
 */
@WebServlet("/GameRoundServlet")
public class GameRoundServlet extends HttpServlet {
	private int flag = -1;
    private JSONObject json = new JSONObject();
    private String msg="";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //创建输出流对象 设置编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
	    
		int gameRound = Integer.parseInt(request.getParameter("gameRound"));
		String userName = request.getParameter("userName");
		User user = new User(userName);
		user.setGameRound(gameRound);
		//1更改成功 0失败 2无需更改
		flag = new UserServiceImpl().updateUserGameRound(user);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
