<%@page import = "com.entity.Users" %>
<%@page import = "com.entity.Orders" %>
<%@page import = "com.dao.OrdersDAO" %>
<%@page import = "com.db.DatabaseConnect" %>
<%@page import = "java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored= "false" %>
<!DOCTYPE HTML>
<html>
<head>
<title> View Orders </title>
<%@include file= "all_components/all_css.jsp" %>
</head>
<body style = "background-color: #f0f1f2;">
<c:if test = "${userObj.role ne 'Admin'}">
<c:redirect url = "login.jsp"></c:redirect>
</c:if>
<%@include file = "all_components/navbar.jsp" %>
<c:if test = "${not empty successMsg}">
<h5 class = "text-center text-danger">${successMsg}</h5>
<c:remove var="successMsg" />
</c:if>
 <div class = "container">
 <div class = "row p-2">
 <div class = "col-md-14">
 <div class= "card bg-white">
 <div class = "card-body">
 <h3 class = "text-center text-success"> Order Details </h3>
  <table class="table table-striped">
  <thead>
  <tr>
  <th scope="col"> Order ID </th>
  <th scope="col"> Book ID </th>
  <th scope="col"> User ID </th>
  <th scope="col"> User Name </th>
  <th scope="col"> Email </th>
  <th scope="col"> Phone </th>
  <th scope="col"> Address </th>
  <th scope="col"> Payment Method </th>
  <th scope="col"> Status </th>
  <th scope = "col">Action</th>
  </tr>
  </thead>
  <tbody>
  <%
   OrdersDAO dao = new OrdersDAO(DatabaseConnect.getConn());
   List<Orders> order = dao.getAllOrders();
   for(Orders o : order){
   %>
   <tr>
   <th scope="row"><%= o.getOid() %></th>
   <td><%= o.getBid() %></td>
   <td><%= o.getUid() %></td>
   <td><%= o.getUname() %></td>
   <td><%= o.getEmail() %></td>
   <td><%= o.getPhone() %></td>
   <td><%= o.getAddress() %></td>
   <td><%= o.getPayMethod() %></td>
   <td><%= o.getStatus() %></td>
   <td> <a href = "edit_status.jsp?orId=<%= o.getOid() %>" class = "btn btn-sm btn-success mb-3">
   Update Status </a> <a href = "deleteOrder?osId=<%= o.getOid() %>" class = "btn btn-sm btn-danger">
   Delete Order </a></td>
   </tr>
   <%   }   %>
   </tbody>
  </table>
 </div>
</div>
</body>
</html>





