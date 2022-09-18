<%@page import="com.pcshop.database.entity.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.pcshop.database.manager.CartManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	CartManager cartManager = new CartManager();
	List<Cart> cartList = cartManager.cartList();
%>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>Cart Summary</title>
</head>
<body>
<%@include file="/admin/AdminPage.jsp"%>
	<table class="table table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Customer Name</th>
				<th scope="col">Total Amount</th>

			</tr>
		</thead>
		<tbody>

			<%
			if (!cartList.isEmpty()) {
				for (Cart cart : cartList) {
			%>
			
			<tr>
				<th scope="row"><a href="CartDetail.jsp?id=<%=cart.getCartId()%>"><%=cart.getCartId()%></a></th>
				<td><a href="CartDetail.jsp?id=<%=cart.getCartId()%>"><%=cart.getCustomerName()%></a></td>
				<td><a href="CartDetail.jsp?id=<%=cart.getCartId()%>"><%=String.format("$%,.2f", cart.getTotalAmount())%></a></td>
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