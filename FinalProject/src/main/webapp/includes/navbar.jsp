
<%@page import= "java.io.InputStream, org.w3c.dom.*, com.pcshop.core.utils.*, java.util.List, java.util.ArrayList,com.pcshop.xml.CategoryXml, com.pcshop.database.entity.Category"%>
<% 
String addressNav = "http://localhost:8080/FinalProject/categories";
InputStream inNav = WebHelper.get(addressNav);
Document documentNav = XmlHelper.parse(inNav);
List<Category> categories = new ArrayList<>();
NodeList categoryList = documentNav.getElementsByTagName("category");
for (int i = 0; i < categoryList.getLength(); i++) {
	Element element = (Element) categoryList.item(i);
	Category category = CategoryXml.format(element);
	categories.add(category);
} %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="MainPage.jsp">PCSHOP</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<div class="dropdown">
			  <button type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    Categories
			  </button>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			  <%
			if (!categories.isEmpty()) {
				for (Category category : categories) {
			%>
			  
			    <a class="dropdown-item" href="ProductList.jsp?id=<%=category.getCategoryId() %>"> <%=category.getCategoryName() %></a>
			  
			  <%
			}
			} else {
			out.println("There is no category");
			}
			%>
				</div>
			</div>
			<ul class="navbar-nav ml-auto">
				
				<li class="nav-item"><a class="nav-link" href="MainPage.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="cart.jsp">Cart <span class="badge badge-danger">${cart_list.size()}</span> </a></li>
				<%
				String auth="";
				if (auth != null) {
				%>
				<li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
				<li class="nav-item"><a class="nav-link" href="log-out">Logout</a></li>
				<%
				} else {
				%>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
				<%
				}
				%>
			</ul>
		</div>
	</div>
</nav>