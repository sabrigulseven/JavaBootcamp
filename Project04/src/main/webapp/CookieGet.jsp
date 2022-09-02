<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
String company="";
if(request.getCookies()!= null) { 
	for(Cookie cookie : request.getCookies()) { 
		if(cookie.getName().equals("company"))
			company = cookie.getValue();
	}
}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
.çerez alındı: <%=company %>
</body>
</html>