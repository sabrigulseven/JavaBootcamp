<%@page import="com.pcshop.database.entity.Product"%>
<%@page import="com.pcshop.database.manager.ProductManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
long productId = Long.parseLong(request.getParameter("id"));
ProductManager productManager = new ProductManager();
Product product = productManager.find(productId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=product.getProductName() %></title>
</head>
<body>
<%@include file="/admin/AdminPage.jsp"%><br>
Product Id: <%=product.getProductId() %> <br>
Product Name: <%=product.getProductName() %><br>
Sales Price: <%=product.getSalesPrice() %><br>
Category: <%=product.getCategory().getCategoryName() %><br>
<div class=col-sm-6>
	<img class="img-responsive" width="auto" height="400px"
		src="${pageContext.request.contextPath}/images/img<%=product.getProductId()%>.png" alt="Card image cap">
</div>

</body>
</html>