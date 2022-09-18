<%@page import="com.pcshop.database.entity.Product"%>
<%@page import="com.pcshop.database.manager.ProductManager"%>
<%@page import="com.pcshop.database.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.pcshop.database.manager.CategoryManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	CategoryManager categoryManager = new CategoryManager();
    	List<Category> categories = categoryManager.list();
    	ProductManager productManager = new ProductManager();
    	List<Product> productList = productManager.list();
    	
    	if(request.getParameter("insert") != null){
    		long productId=0;
    		String productName = request.getParameter("productName");
    		double salesPrice = Double.parseDouble(request.getParameter("salesPrice"));
    		String categoryName = request.getParameter("categoryName");
    		Category category = categoryManager.find(categoryName);
    		Product product = new Product(productId,productName,salesPrice,category);
    		boolean isInserted = productManager.insert(product);
    	}

    	if(request.getParameter("update") != null){
    		long productId= Long.parseLong(request.getParameter("productId"));
    		String productName = request.getParameter("productName");
    		double salesPrice = Double.parseDouble(request.getParameter("salesPrice"));
    		String categoryName = request.getParameter("categoryName");
    		Category category = categoryManager.find(categoryName);
    		Product product = new Product(productId,productName,salesPrice,category);
    		boolean isInserted = productManager.update(product);
    	}

    	if(request.getParameter("delete") != null){
    		long productId=Long.parseLong(request.getParameter("productId"));
    		boolean isUpdated = productManager.delete(productId);
    		
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>Product Summary</title>
</head>
<body>
<%@include file="/admin/AdminPage.jsp"%>

	<table class="table table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Product Name</th>
				<th scope="col">Sales Price</th>
				<th scope="col">Category</th>

			</tr>
		</thead>
		<tbody>

			<%
			if (!productList.isEmpty()) {
				for (Product product : productList) {
			%>
			
			<tr>
				<th scope="row"><a href="ProductDetail.jsp?id=<%=product.getProductId()%>"><%=product.getProductId()%></a></th>
				<td><a href="ProductDetail.jsp?id=<%=product.getProductId()%>"><%=product.getProductName()%></a></td>
				<td><a href="ProductDetail.jsp?id=<%=product.getProductId()%>"><%=String.format("$%,.2f", product.getSalesPrice())%></a></td>
				<td><a href="ProductDetail.jsp?id=<%=product.getProductId()%>"><%=product.getCategory().getCategoryName()%></a></td>
			</tr>
			
			<%
			}
			} else {
			out.println("There is no category");
			}
			%>


		</tbody>
		
	</table>
	<form action="ProductSummary.jsp" method="POST">
  	<div class="input-group">
  		<input type="text" class="form-control" name="productId" placeholder="Product id" aria-label="Product id" aria-describedby="basic-addon2">
  		<input type="text" class="form-control" name="productName" placeholder="Product Name" aria-label="Product Name" aria-describedby="basic-addon2">
  		<input type="text" class="form-control" name="salesPrice" placeholder="Sales Price" aria-label="Product Name" aria-describedby="basic-addon2">
  		<input type="text" class="form-control" name="categoryName" placeholder="Category Name" aria-label="Product Name" aria-describedby="basic-addon2">
  		<div class="input-group-append">
    		<button class="btn btn-outline-secondary" type="submit" value="insert" name="insert">Insert</button>
    		<button class="btn btn-outline-secondary" type="submit" value="update" name="update">Update</button>
    		<button class="btn btn-outline-secondary" type="submit" value="delete" name="delete">Delete</button>
    	</div>
	</div>
   </form>
		<%@include file="/includes/footer.jsp"%>
	
</body>
</html>