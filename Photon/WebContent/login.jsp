<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
</head>
<body>
  <div align="center"><img src="file:///D:/Code/Javawebcode/InformationSystem/WebContent/img/Java.jpg"></div>
  <form action="LoginServlet" method="post">
    <table align="center" style="margin-top: 250px;">
      <tr>
        <td>用户名：</td>
        <td><input type="text" placeholder="请输入帐号" name="userName"/></td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><input type="password" placeholder="请输入密码" name="password"/></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="登录"/></td>
      </tr>
      <tr>
        <td colspan="2">还没有账号？单击<a href="register.jsp">这里</a>进入注册页面</td>
      </tr>
      <tr>
        <td colspan="2"><font color="red">${message }</font></td>
      </tr>
    </table>
  </form>
</body>
</html>