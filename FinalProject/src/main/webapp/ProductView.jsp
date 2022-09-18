<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.InputStream, com.pcshop.core.utils.WebHelper, org.w3c.dom.Document,com.pcshop.core.utils.XmlHelper,com.pcshop.xml.ProductXml, com.pcshop.database.entity.*"%>
<%
long productId = Long.parseLong(request.getParameter("id"));
String address = String.format("http://localhost:8080/FinalProject/product/find?id=%d", productId);
InputStream in = WebHelper.get(address);
Document document = XmlHelper.parse(in);
Product product = ProductXml.format(document);
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>

<title><%=product.getProductName() %></title>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>

	<div class="container">
		<div class="row">
			
			<div class="col-md-6 my-6">
				<div class="card w-100">
					<img class="card-img-top"
						src="${pageContext.request.contextPath}/images/img<%=product.getProductId()%>.png" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=product.getProductName()%></h5>
						<h6 class="price">
							Price: $<%=product.getSalesPrice()%></h6>
						
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="add-to-cart?id=<%=product.getProductId()%>">Add to Cart</a> 
							<a class="btn btn-primary" href="order-now?quantity=1&id=<%=product.getProductId()%>">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	<%@include file="/includes/footer.jsp"%>
</body>
</html>