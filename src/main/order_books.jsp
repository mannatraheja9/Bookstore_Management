<%@page import = "com.db.DatabaseConnect" %>
<%@page import = "java.sql.Connection" %>
<%@page import = "com.dao.BooksDAO" %>
<%@page import = "com.entity.Books" %>
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
<div class = "container p-2">
<div class = "col-md-10 offset-md-1">
<div class = "card">
<div class = "card-body">
<div class = "text-center text-success">
<i class="fa-solid fa-book"></i>
<h5> Enter details! </h5>
<c:if test = "${not empty successMsg}">
<div class = "alert alert-success" role= "alert">${successMsg}</h4>
<c:remove var="successMsg" />
</c:if>
</div>
<form action = "handlePlacedOrder" method = "get">
 <input type = "hidden" value= "${userObj.id}" name = "usersid">
 <% int bookId = Integer.parseInt(request.getParameter("bookId"));  %>
 <div>
 <input type = "number" name = "bookIdO" value = <%= bookId %> hidden >
 </div>
 <div class = "form-group">
 <label> Name </label> <input type = "text" name = "name"
 required class = "form-control" readonly value = "${userObj.name}">
 </div>
 <div class = "form-group">
 <label> Email </label> <input type = "email" name = "email"
 required class = "form-control" readonly value = "${userObj.email}">
 </div>
 <div class = "form-group">
 <label>Enter Phone No. </label> <input type = "tel" name = "phone"
  required class = "form-control">
 </div>
 <div class = "form-group">
 <label>Enter Address </label> <input type = "text" name = "address"
 required class = "form-control">
 </div>
 <div class = "form-group">
 <label>Payment method </label>
 <select name = "paymode">
 <option selected value = "pay"> Choose </option>
 <option value = "cashondel"> Cash on Delivery </option>
 <option value = "onlinepay"> Pay Online</option>
 </select
 </div>
 <div> <button class = "btn btn-success mt-4" type = "submit"> Place Order </button> </div>
 </form>
 </div>
 </div>
 </div>
 </div>
 </div>
</body>
</html>





