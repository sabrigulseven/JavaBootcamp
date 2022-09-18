<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>Admin Page</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-primary">
  <a class="navbar-brand" href="AdminPage.jsp">Admin Page</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link" href="CategorySummary.jsp">Category Summary</a>
      <a class="nav-item nav-link" href="ProductSummary.jsp">Product Summary</a>
    </div>
  </div>
</nav>

<%@include file="/includes/footer.jsp"%>

</body>
</html>