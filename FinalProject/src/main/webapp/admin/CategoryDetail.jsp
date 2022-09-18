<%@page import="com.pcshop.database.entity.Category"%>
<%@page import="com.pcshop.database.manager.CategoryManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
long categoryId = Long.parseLong(request.getParameter("id"));
CategoryManager categoryManager = new CategoryManager();
Category category = categoryManager.find(categoryId);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Category Detail</title>
</head>
<body>
<%@include file="/admin/AdminPage.jsp"%>

	Category ID: <%=category.getCategoryId() %> <br><br>
	Category Name: <%=category.getCategoryName() %>
</body>
</html>