<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
int sum = 0;
int left = 0;
int right = 0;
if (request.getParameter("add") != null) {
	left = Integer.parseInt(request.getParameter("left"));
	right = Integer.parseInt(request.getParameter("right"));
	sum = left + right;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AdderForm.jsp" method="POST">
		sol: <input type="text" name="left" value="<%=left%>"><br /> <br />
		sağ: <input	type="text" name="right" value="<%=right%>"> <br /><br />
		<input	type="submit" value="topla" name="add"><br /><br />
	</form>
	Toplam :<%=sum%><br />
</body>
</html>