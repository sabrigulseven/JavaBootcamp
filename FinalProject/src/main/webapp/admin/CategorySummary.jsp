<%@page import="com.pcshop.database.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.pcshop.database.manager.CategoryManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
CategoryManager categoryManager = new CategoryManager();
List<Category> categories = categoryManager.list();

if(request.getParameter("insert") != null){
	long categoryId=0;
	String categoryName = request.getParameter("categoryName");
	Category category = new Category(categoryId,categoryName);
	boolean isInserted = categoryManager.insert(category);
}

if(request.getParameter("update") != null){
	long categoryId=Long.parseLong(request.getParameter("categoryId"));
	String categoryName = request.getParameter("categoryName");
	Category category = new Category(categoryId,categoryName);
	boolean isUpdated = categoryManager.update(category);
}

if(request.getParameter("delete") != null){
	long categoryId=Long.parseLong(request.getParameter("categoryId"));
	boolean isUpdated = categoryManager.delete(categoryId);
	
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>

<title>Category Summary</title>
</head>
<body>
<%@include file="/admin/AdminPage.jsp"%>

	<table class="table table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Category Name</th>

			</tr>
		</thead>
		<tbody>

			<%
			if (!categories.isEmpty()) {
				for (Category category : categories) {
			%>
			
			<tr>
				<th scope="row"><a href="CategoryDetail.jsp?id=<%=category.getCategoryId()%>"><%=category.getCategoryId()%></a></th>
				<td><a href="CategoryDetail.jsp?id=<%=category.getCategoryId()%>"><%=category.getCategoryName()%></a></td>
			</tr>
			
			<%
			}
			} else {
			out.println("There is no category");
			}
			%>


		</tbody>
		
	</table>
	
  <form action="CategorySummary.jsp" method="POST">
  	<div class="input-group">
  		<input type="text" class="form-control" name="categoryId" placeholder="Category id" aria-label="Category id" aria-describedby="basic-addon2">
  		<input type="text" class="form-control" name="categoryName" placeholder="Category Name" aria-label="Category Name" aria-describedby="basic-addon2">
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