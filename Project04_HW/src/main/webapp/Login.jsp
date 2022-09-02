<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.godoro.user.*" %>
<%
String username="";
String password="";
String message="";
UserManager userManager = new UserManager();
if(request.getParameter("login") != null){
	username= request.getParameter("username");
	password= request.getParameter("password");
	User user = userManager.findByUserName(username);
	if(user!= null) {
		if (user.getUserPassword().equals(password) ){
			session.setAttribute("username",username);
			response.sendRedirect("Home.jsp");
		}else{
			message="Şifre yanlış";
		}
	}else{
		message="Kullanıcı bulunamadı";
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="Login.jsp" method="POST">
		username: <input type="text" name="username" value="<%=username%>"><br /> <br />
		password: <input	type="password" name="password" value="<%=password%>"> <br /><br />
		<input	type="submit" value="login" name="login"><br /><br />
</form>
<%=message%><br /> 
</body>
</html>