<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List , java.io.InputStream , org.w3c.dom.*, 
    com.pcshop.core.utils.WebHelper,com.pcshop.core.utils.XmlHelper, com.pcshop.database.entity.Product , java.util.ArrayList, com.pcshop.xml.ProductXml"%>
<%
String address = "http://localhost:8080/FinalProject/products";
InputStream in = WebHelper.get(address);
Document document = XmlHelper.parse(in);
List<Product> products = new ArrayList<>();
NodeList productList = document.getElementsByTagName("product");
for (int i = 0; i < productList.getLength(); i++) {
	Element element = (Element) productList.item(i);
	Product product = ProductXml.format(element);
	products.add(product);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>PCSHOP</title>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<a href="ProductView.jsp?id=<%=p.getProductId()%>"><img 
						class="card-img-top"
						src="${pageContext.request.contextPath}/images/img<%=p.getProductId()%>.png"
						alt="Card image cap"> </a>
					<div class="card-body">
						<h5 class="card-title"><%=p.getProductName()%></h5>
						<h6 class="price">
							Price: $<%=p.getSalesPrice()%></h6>
						<h6 class="category">
							Category:
							<%=p.getCategory().getCategoryName()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark"
								href="add-to-cart?id=<%=p.getProductId()%>">Add to Cart</a> <a
								class="btn btn-primary"
								href="order-now?quantity=1&id=<%=p.getProductId()%>">Buy Now</a>
						</div>
					</div>
				</div>
				
			</div>
			<%
			}
			} else {
			out.println("There is no proucts");
			}
			%>

		</div>
	</div>
	Web Application Context Path = ${pageContext.request.contextPath}

	<%@include file="/includes/footer.jsp"%>
</body>
</html>