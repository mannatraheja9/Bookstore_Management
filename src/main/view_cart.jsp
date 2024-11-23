<%@page import = "com.db.DatabaseConnect" %>
<%@page import = "com.dao.CartDAO" %>
<%@page import = "com.entity.Cart" %>
<%@page import = "com.entity.Users" %>
<%@page import = "java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored= "false" %>
<!DOCTYPE HTML>
<html>
<head>
 <title> View Cart </title>
 <%@include file= "all_components/all_css.jsp" %>
</head>
<body style = "background-color: #f0f1f2;">
<c:if test = "${userObj.role ne 'User'}">
<c:redirect url = "login.jsp"></c:redirect>
</c:if>
<%@include file = "all_components/navbar.jsp" %>
<c:if test = "${not empty successMsg}">
<h5 class = "text-center text-danger">${successMsg}</h5>
<c:remove var="successMsg" />
</c:if>
<div class = "container">
<div class = "row p-2">
<div class = "col-md-12">
<div class= "card bg-white">
<div class = "card-body">
<h3 class = "text-center text-success"> Your selected books </h3>
<table class="table table-striped">
 <thead>
 <tr>
 <th scope="col">Book Title</th>
 <th scope="col">Author</th>
 <th scope="col">Price</th>
 <th scope="col">Priority</th>
 <th scope="col">Actions</th>
 <th scope = "col"> </th>
 </tr>
 </thead>
 <tbody>
  <%
  Users u = (Users) session.getAttribute("userObj");
  CartDAO dao = new CartDAO(DatabaseConnect.getConn());
  List<Cart> cart = dao.getBooksByUser(u.getId());
  Double totalPrice =0.00;
  for(Cart c: cart){
  totalPrice = c.getTotalPrice();
  %>
  <tr>
  <th scope="row"><%= c.getBookName() %></th>
  <td><%= c.getAuthor() %></td>
  <td><%= c.getPrice() %></td>
  <td class = "text-center"><%= c.getPriority() %></td>
  <td> <a href = "change_priority.jsp?crId=<%= c.getCid() %>" class = "btn btn-sm btn-success"> Change priority </a></td>
  <td> <a href = "remove_book?bid=<%= c.getBid() %>&&uid=<%= c.getUserid() %>" class = "btn btn-sm btn-danger">Remove </a></td>
  </tr>
  <%   }   %>
  <tr>
  <td>Total Price</td>
  <td></td>
  <td> <%= totalPrice %> </td>
  <td></td>
  <td></td>
  <td></td>
  </tr>
  </tbody>
  </table>
</div>
</div>
</div>
</div>
</div>
</body>
</html>



