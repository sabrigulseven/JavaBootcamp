<%@ page import="com.godoro.rectangle.Rectangle" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int sum = 0;
int width = 0;
int height = 0;
String type = "Result: ";

if (request.getParameter("area") != null) {
	type = "Area: ";
	width = Integer.parseInt(request.getParameter("width"));
	height = Integer.parseInt(request.getParameter("height"));
	Rectangle rectangle = new Rectangle(height,width);
	sum = rectangle.getArea();
}
if (request.getParameter("perimeter") != null) {
	type = "Perimeter: ";
	width = Integer.parseInt(request.getParameter("width"));
	height = Integer.parseInt(request.getParameter("height"));
	height = Integer.parseInt(request.getParameter("height"));
	Rectangle rectangle = new Rectangle(height,width);
	sum = rectangle.getPerimeter();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rectangle</title>
</head>
<body>
<h1>Rectangle </h1><br />
<form action="Rectangle.jsp" method="POST">
		width: <input type="text" name="width" value="<%=width%>"><br /> <br />
		height: <input	type="text" name="height" value="<%=height%>"> <br /><br />
		<input	type="submit" value="area" name="area"><br /><br />
		<input	type="submit" value="perimeter" name="perimeter"><br /><br />
</form>
	<%=type %> <%=sum%><br />
</body>
</html>