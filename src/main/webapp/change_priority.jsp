<!DOCTYPE HTML>
<html>
<head>
<title> Edit priority </title>
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
<i class="fa-solid fa-stairs"></i>
<h5> Update Priority </h5>
</div>
<form action = "changePriority" method = "post">
<%  int crId = Integer.parseInt(request.getParameter("crId"));  %>
<div class = "form-group">
<label for= "cartId"> Cart Item ID </label>  <input type = "text"
 required = "required" class = "form-control" id= "cartId" name = "cartId" value= "<%= crId %>"  readonly>
</div>
<div class = "form-group">
<label for= "newPriority">Enter new priority </label>  <input type = "text"
 required = "required" class = "form-control" id= "newPriority" name = "newPriority">
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






