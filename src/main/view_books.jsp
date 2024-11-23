<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored= "false" %>
<%@page import = "com.db.DatabaseConnect" %>
<%@page import = "java.sql.Connection" %>
<%@page import = "com.dao.BooksDAO" %>
<%@page import = "java.util.List" %>
<%@page import = "com.entity.Books" %>
<!DOCTYPE HTML>
<html>
<head>
<title> View Books </title>
<%@include file= "all_components/all_css.jsp" %>
</head>
<body>
<c:if test = "${userObj.role ne 'Admin'}">
<c:redirect url = "login.jsp"></c:redirect>
</c:if>
<%@include file = "all_components/navbar.jsp" %>
<div class = "container">
<div class = "row">
<div class = "col-md-12">
<div>
<h5 class = "text-center text-primary"> All books </h5>
<c:if test = "${not empty successMsg}">
<div class = "alert alert-success" role= "alert">${successMsg}</h4>
<c:remove var="successMsg" />
</c:if>
</div>
<%
 BooksDAO dao = new BooksDAO(DatabaseConnect.getConn());
 List<Books> list = dao.getAllBooks();
 for(Books book : list){
%>
<div class = "card mt-2">
<div class = "card-body">
<div class = "text-center text-primary">
<i class = "far fa-clipboard fa-2x"></i>
</div>
<h6> <%= book.getTitle() %> </h6>
<p> <%= book.getAuthor() %> </p>
<br>
<div class = "form-row">
<div class = "form-group col-md-3">
<input type = "text" class = "form-control form-control-sm" value = "Price: <%= book.getPrice() %>" readonly>
</div>
<div class = "form-group col-md-3">
<input type = "text" class = "form-control form-control-sm" value = "Quantity: <%= book.getQuantity() %>" readonly>
</div>
<div class = "text-center">
<a href= "edit_books.jsp?id=<%= book.getId()%>" class = "btn btn-sm bg-success text-white"> Edit </a>
<a href= "delete?id=<%= book.getId()%>" class = "btn btn-sm bg-danger text-white"> Delete </a>
</div>
</div>
</div>
<% } %>
</div>
</div>
</div>
</body>
</html>