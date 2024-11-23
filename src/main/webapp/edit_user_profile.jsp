<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored= "false" %>
<!DOCTYPE HTML>
<html>
<head>
<title> Login Page </title>
<%@include file= "all_components/all_css.jsp" %>
</head>
<body style = "background-color: #f0f1f2;">
<c:if test = "${empty userObj}">
<c:redirect url = "login.jsp"></c:redirect>
</c:if>
<%@include file = "all_components/navbar.jsp" %>
<div class = "container-fluid">
<div class = "row p-4">
<div class = "col-md-4 offset-md-4">
<div class = "card">
<div class = "card-body">
<div class = "text-center">
<i class="fa-regular fa-user"></i>
<h5> Edit profile </h5>
</div>
<form action = "update_profile" method = "post">
 <input type = "hidden" value= "${userObj.id}" name = "id">
 <div class = "form-group">
 <label>Enter Name </label> <input type = "text" name = "name" value = "${userObj.name}"
  required class = "form-control">
 </div>
 <div class = "form-group">
 <label>Enter Email </label> <input type = "text" name = "email" value = "${userObj.email}"
  required class = "form-control">
 </div>
 <div class = "form-group">
 <label>Enter password </label> <input type = "password" name = "password" value = "${userObj.password}"
  required class = "form-control">
 </div>
 <button class = "btn btn-success">Update</button>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>