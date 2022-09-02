<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.godoro.user.*" %>
<%
String username="";
String password="";
String password2="";
String message="";
UserManager userManager = new UserManager();
if(request.getParameter("login") != null){
	username= request.getParameter("username");
	password= request.getParameter("password");
	password2= request.getParameter("password2");
	if(!password.equals(password2)) {
		message="passwords must be equal";
		
	}else{
		if(userManager.findByUserName(username)==null) {
			User user = new User();
			user.setUserName(username);
			user.setUserPassword(password);
			boolean isCreated = userManager.create(user);
			if(isCreated){
				message= "user created and stored";
			}else{
			message= "user created but not stored";
			}
		}else{
			message= "username already taken";
		}
	}
	
}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<form action="Register.jsp" method="POST">
		username: <input type="text" name="username" value="<%=username%>"><br /> <br />
		password: <input	type="password" name="password" value="<%=password%>"> <br /><br />
		password: <input	type="password" name="password2" value="<%=password2%>"> <br /><br />
		<input	type="submit" value="register" name="login"><br /><br />
</form>
<button onclick="window.location.href='Login.jsp';">
      Login
    </button>
<%=message%><br /> 
</body>
</html>