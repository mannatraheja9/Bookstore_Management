<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored= "false" %>
<!DOCTYPE HTML>
<html>
<head>
<title> Sign Up Page </title>
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
<i class="fa-solid fa-user-plus"></i>
<h5> Registration </h5>
</div>
<div>
<c:if test = "${not empty successMsg}">
<h5 class = "text-center text-danger">${successMsg}</h5>
<c:remove var="successMsg" />
</c:if>
</div>
<form action = "add_user" method = "post">
 <div class = "form-group">
 <label for= "exampleInputName1">Enter name </label>  <input type = "text"
  required = "required" class = "form-control" id= "exampleInputName1" name = "nm">
 </div>
 <div class = "form-group">
 <label for= "exampleInputEmail1">Enter email </label>  <input type = "email"
  required = "required" class = "form-control" id= "exampleInputEmail1" name = "em">
 </div>
 <div class = "form-group">
 <label for= "exampleInputPassword1">Enter password </label>  <input type = "password"
  required = "required" class = "form-control" id= "exampleInputPassword1" name = "ps">
 </div>
 <button type = "submit" class = "btn btn-primary badge-pill btn-block"> Register </button>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>