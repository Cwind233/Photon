package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Start_View.Start1_0;

/**
 * Servlet implementation class Exchange1_0
 */
@WebServlet("/Exchange1_0")
public class Exchange1_0 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String upass= request.getParameter("upass");
       
        String Order=request.getParameter("Order");
        System.out.println("ssaas");
       System.out.println(Order);
        Start1_0 start=new Start1_0(Order);
        String order=start.IO();
        
        int x=start.get_x();//获取x轴坐标
        int y=start.get_y();//获取y轴坐标
        int direction=start.get_direction();//获取方向
        int score=start.get_score();
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();     
        json.put("X", x);//添加x坐标
        json.put("Y", y);//添加y轴坐标
        json.put("Direction", direction);//添加方向
        json.put("Score", score);//返回分数
        json.put("order", order);//返回解析命令
        out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
