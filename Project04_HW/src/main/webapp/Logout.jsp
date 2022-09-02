<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
session.removeAttribute("username");
response.sendRedirect("Login.jsp");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
Logging out
</body>
</html>