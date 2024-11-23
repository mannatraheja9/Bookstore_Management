<!DOCTYPE HTML>
<html>
<head>
<title> Edit Status </title>
<%@include file= "all_components/all_css.jsp" %>
</head>
<body style = "background-color: #f0f1f2;">
<%@include file = "all_components/navbar.jsp" %>
<div class = "container-fluid">
<div class = "row p-5">
<div class = "col-md-4 offset-md-4">
<div class = "card">
<div class = "card-body">
<div class = "text-center">
<i class="fa-solid fa-cart-shopping"></i>
<h5> Update Order Status </h5>
</div>
<form action = "updateOrderStatus" method = "post">
<%  int ordersId = Integer.parseInt(request.getParameter("orId"));  %>
<div class = "form-group">
<label for= "orderId"> Order ID </label>  <input type = "text"
 required = "required" class = "form-control" id= "orderId" name = "orderId" value= "<%= ordersId %>"  readonly>
</div>
<div class = "form-group">
<label for= "newStatus">Enter new status </label>  <input type = "text"
 required = "required" class = "form-control" id= "newStatus" name = "newStatus">
 </div>
 <button type = "submit" class = "btn btn-primary badge-pill btn-block"> Update </button>
 </form>
 </div>
 </div>
 </div>
 </div>
 </div>
</body>
</html>






