<!DOCTYPE HTML>
<html>
<head>
<title> Verify Registration </title>
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
<i class="fa-solid fa-check"></i>
<h5> Verify Registration </h5>
</div>
<form action = "verify_code" method = "post">
<div class = "form-group">
<label for = "regCode"> Enter code received via Email </label>
<input type = "text" id = "regCode" name = "regCode" required class = "form-control">
</div>
<button type = "submit" class = "btn btn-primary badge-pill btn-block"> Complete Sign Up </button>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>






