<%@page import="com.pcshop.database.entity.Product"%>
<%@page import="com.pcshop.database.manager.ProductManager"%>
<%@page import="com.pcshop.xml.CartProductXml"%>
<%@page import="com.pcshop.database.entity.CartProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	long cartid=11;
    String address = String.format("http://localhost:8080/FinalProject/cart/view?id=%d", cartid);
    InputStream in = WebHelper.get(address);
    Document document = XmlHelper.parse(in);
    List<CartProduct> products = new ArrayList<>();
    NodeList productList = document.getElementsByTagName("cartProduct");
    for (int i = 0; i < productList.getLength(); i++) {
        Element element = (Element) productList.item(i);
        CartProduct product = CartProductXml.format(element);
        products.add(product);
    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>Cart</title>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>
	
	<div class="container">
		<div class="d-fex py-3 "> 
		</div>
		<table class="table table-light">
		<thead>
		<tr>
		<th scope="col">Name</th>
		<th scope="col">Category</th>
		<th scope="col">Price</th>
		<th scope="col">Quantity</th>
		<th scope="col">Cancel</th>
		</tr>
		</thead>
		<tbody>
		<% 
		ProductManager productManager = new ProductManager();
		double totalAmount=0;
		for (CartProduct cartProduct : products) {
	        Product product = productManager.find(cartProduct.getProductId());
	    %>
		<tr>
		<td><%=product.getProductName() %></td>
		<td><%=product.getCategory().getCategoryName() %></td>
		<td><%=String.format("$%,.2f", product.getSalesPrice())%></td>
		<td><%=cartProduct.getSalesQuantity() %></td>
		<td>
			<a class="btn btn-sm btn-danger" href="">X</a>
		</td>
		</tr>
		<% totalAmount+=product.getSalesPrice()*cartProduct.getSalesQuantity();
		}  %>
		</tbody>
		</table>
		<h3>Total Price:  <%=String.format("$%,.2f", totalAmount)%> </h3> <a class="mx-3 btn btn-primary" href="#">Buy</a>
	</div>
	<%@include file="/includes/footer.jsp"%>

</body>
</html>