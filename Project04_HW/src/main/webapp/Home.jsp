<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String username = (String) session.getAttribute("username");
if(username == null) {
	response.sendRedirect("Login.jsp");
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
Hoşgeldin <%=username %><br>
<a href="Logout.jsp">Logout</a><br>
</body>
</html>