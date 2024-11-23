<%@page import = "com.db.DatabaseConnect" %>
<%@page import = "com.dao.BooksDAO" %>
<%@page import = "com.entity.Books" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored= "false" %>
<!DOCTYPE HTML>
<html>
<head>
<title> Edit Books </title>
<%@include file= "all_components/all_css.jsp" %>
</head>
<body style = "background-color: #f0f1f2;">
<c:if test = "${userObj.role ne 'Admin'}">
<c:redirect url = "login.jsp"></c:redirect>
</c:if>
<%@include file = "all_components/navbar.jsp" %>
<div class = "container p-2">
<div class = "col-md-10 offset-md-1">
<div class = "card">
<div class = "card-body">
<div class = "text-center text-success">
<i class="fa-solid fa-book"></i>
 <%
 int id = Integer.parseInt(request.getParameter("id"));
 BooksDAO dao = new BooksDAO(DatabaseConnect.getConn());
 Books book = dao.getBookById(id);
 %>
 <h5> Edit Books </h5>
 </div>
 <form action = "update" method = "post">
 <input type = "hidden" value= "<%= book.getId() %>" name = "id">
 <div class = "form-group">
 <label>Enter Book Title </label> <input type = "text" name = "title" value = "<%= book.getTitle() %>"
  required class = "form-control">
 </div>
 <div class = "form-group">
 <label>Enter Author Name </label> <input type = "text" name = "author" value = "<%= book.getAuthor() %>"
  required class = "form-control">
 </div>
 <div class = "form-group">
 <label>Enter Book Price </label> <input type = "number" name = "price" value = "<%= book.getPrice() %>"
  required class = "form-control">
 </div>
 <div class = "form-group">
 <label>Enter Book Quantity </label> <input type = "number" name = "quantity" value = "<%= book.getQuantity() %>"
  required class = "form-control">
 </div>
 <button class = "btn btn-success">Update Book </button>
 </form>
</div>
</div>
</div>
</div>
</body>
</html>