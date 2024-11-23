<!DOCTYPE HTML>
<html>
<head>
<title> Login Page </title>
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
<i class="fa-solid fa-user"></i>
<h5> Login </h5>
</div>
<c:if test = "${not empty successMsg}">
<h5 class = "text-center text-danger">${successMsg}</h5>
<c:remove var="successMsg" />
</c:if>
<form action = "login" method = "post">
 <div class = "form-group">
 <label for= "exampleInputEmail1">Enter email </label>  <input type = "email"
  required = "required" class = "form-control" id= "exampleInputEmail1" name = "email">
 </div>
 <div class = "form-group">
 <label for= "exampleInputPassword1">Enter password </label>  <input type = "password"
  required = "required" class = "form-control" id= "exampleInputPassword1" name = "password">
 </div>
 <button type = "submit" class = "btn btn-primary badge-pill btn-block"> Login </button>
 </form>
 </div>
 </div>
 </div>
 </div>
 </div>
 </body>
</html>