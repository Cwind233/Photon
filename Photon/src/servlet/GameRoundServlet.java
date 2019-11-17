package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

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
	    
		String gameRound = request.getParameter("gameRound");
		
//		UserServiceImpl;
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
