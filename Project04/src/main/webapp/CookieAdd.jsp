<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
Cookie cookie = new Cookie("company", "godoro");
response.addCookie(cookie);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	çerez eklendi <%=cookie.getValue()%>
</body>
</html>