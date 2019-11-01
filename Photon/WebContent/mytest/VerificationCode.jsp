<%@ page import="java.util.Random,java.awt.*,java.awt.Graphics,java.awt.image.*,javax.imageio.*" %>
<%@ page language="java" contentType="image/jpeg; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! 
    int width = 80;
    int height = 30;
    //产生随机颜色
    public Color getColor(){
        Random ran = new Random();//0-1
        int r = ran.nextInt(256);
        int g = ran.nextInt(256);
        int b = ran.nextInt(256);
        return new Color(r, g, b);
    }

    
    //产生验证码值
    public String getRandomNumber() {
        //1000-9999
        int random = (int)(Math.random()*9000) + 1000;
        return String.valueOf(random);
}
%>
<%
    //禁止缓存，防止验证码过期
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Expires", "0");
    //绘制验证码
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics graphics = image.getGraphics();
    graphics.setFont(new Font("self", Font.BOLD, 20));
    graphics.fillRect(0, 0, width, height);
    
    graphics.setColor(Color.BLACK);
    String verificationCode = getRandomNumber();
    StringBuffer stringBuffer = new StringBuffer();
    for(int i = 0; i < verificationCode.length(); i++) {
        stringBuffer.append(verificationCode.charAt(i)+" ");
    }
    graphics.drawString(stringBuffer.toString(), 15, 25);//绘制
    //画线条
     for(int i = 0; i < 15; i++) {
        Random random = new Random();
        int x_Begin = random.nextInt(width);
        int y_Begin = random.nextInt(height);
        int x_End = random.nextInt(x_Begin + 15);
        int y_End = random.nextInt(y_Begin + 15);
        graphics.setColor(getColor());
        graphics.drawLine(x_Begin, y_Begin, x_End, y_End);
    }
    //画点 
    for(int i = 0; i < 500; i++){
        Random random = new Random();
        int x_Begin = random.nextInt(width);
        int y_Begin = random.nextInt(height);
        graphics.setColor(getColor());
        graphics.drawLine(x_Begin, y_Begin, x_Begin, y_Begin);
    }
    //把验证码保存在session中
    session.setAttribute("verificationCode",verificationCode);
    
    //生成图片
    ImageIO.write(image, "jpeg", response.getOutputStream());
    //关闭流
    out.clear();
    out = pageContext.pushBody();
%>