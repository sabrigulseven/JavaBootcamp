<%@page import="com.pcshop.database.entity.CartProduct"%>
<%@page import="java.util.List"%>
<%@page import="com.pcshop.database.manager.CartManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	long cartId = Long.parseLong(request.getParameter("id"));
	CartManager cartManager = new CartManager();
	List<CartProduct> cartProductList = cartManager.viewCartProduct(cartId);
	int id =0;
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>Insert title here</title>
</head>
<body>
<%@include file="/admin/AdminPage.jsp"%>
<table class="table table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Product Id</th>
				<th scope="col">Sales Quantity</th>
				<th scope="col">Sales Price</th>

			</tr>
		</thead>
		<tbody>

			<%
			if (!cartProductList.isEmpty()) {
				for (CartProduct cart : cartProductList) {
					id+=1;
			%>
			
			<tr>
				<th scope="row"><%=id%></th>
				<td><a href="ProductDetail.jsp?id=<%=cart.getProductId()%>"><%=cart.getProductId()%></a></td>
				<td> <%=cart.getSalesQuantity() %></td>
				<td><a ><%=String.format("$%,.2f", cart.getSalesPrice())%></a></td>
			</tr>
			
			<%
			}
			} else {
			out.println("There is no cart");
			}
			%>


		</tbody>
		
	</table>
<%@include file="/includes/footer.jsp"%>

</body>
</html>