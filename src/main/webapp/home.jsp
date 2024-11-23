<%@page import = "com.db.DatabaseConnect" %>
<%@page import = "com.entity.Books"  %>
<%@page import = "com.entity.Users"  %>
<%@page import = "java.util.List" %>
<%@page import = "com.dao.BooksDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored= "false" %>
<!DOCTYPE HTML>
<html>
<head>
<title> User:Home </title>
<%@include file= "all_components/all_css.jsp" %>
</head>
<body style = "background-color: #f0f1f2;">
<c:if test = "${empty userObj}">
<c:redirect url = "login.jsp"></c:redirect>
</c:if>
<%@include file = "all_components/navbar.jsp" %>
<div class = "container">
<div class = "row">
<div class = "col-md-12">
<h5 class = "text-center text-primary"> All books </h5>
<c:if test = "${not empty successMsg}">
<h5 class = "text-center text-danger">${successMsg}</h5>
<c:remove var="successMsg" />
</c:if>
<div class = "card">
<div class = "card-body">
<%
 Users u = (Users) session.getAttribute("userObj");
 BooksDAO dao = new BooksDAO(DatabaseConnect.getConn());
 List<Books> list = dao.getAllBooksForUser();
 for(Books book : list){
%>
<div class = "card-mt-2">
<div class = "card-body">
<div class = "text-center text-primary">
<i class = "far-fa-clipboard fa-2x"></i>
</div>
<h6> <%= book.getTitle() %> </h6>
<h6> <%= book.getAuthor() %> </h6>
<div class = "form-row">
<div class = "form-group col-md-3">
<input type = "text" class = "form-control form-control-sm" value= "Price: <%= book.getPrice() %>" readonly>
</div>
<div class = "form-group col-md-3">
<input type = "text" class = "form-control form-control-sm" value= "Quantity: <%= book.getQuantity() %>" readonly>
</div>
</div>
<div class = "text-center">
<a href = "cart?bid=<%= book.getId() %>&&uid=<%= u.getId() %>" class = "btn btn-sm bg-danger text-white"> Add to Cart </a>
<a href = "order_books.jsp?bookId=<%= book.getId() %>" class = "btn btn-sm bg-success text-white"> Buy Now </a>
</div>
</div>
</div>
<%  }    %>
</div>
</div>
</div>
</div>
</body>
</html>