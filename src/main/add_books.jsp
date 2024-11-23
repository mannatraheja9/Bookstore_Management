<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored= "false" %>
<!DOCTYPE HTML>
<html>
 <head>
 <title> Add Books </title>
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
   <h5> Add Books </h5>
   <c:if test = "${not empty successMsg}">
   <div class = "alert alert-success" role= "alert">${successMsg}</h4>
   <c:remove var="successMsg" />
   </c:if>
   </div>
   <form action = "add_books" method = "post">
    <div class = "form-group">
    <label>Enter Book Title </label> <input type = "text" name = "title"
    required class = "form-control">
    </div>
    <div class = "form-group">
    <label>Enter Author Name </label> <input type = "text" name = "author"
    required class = "form-control">
    </div>
    <div class = "form-group">
    <label>Enter Book Price </label> <input type = "number" name = "price"
    required class = "form-control">
    </div>
    <div class = "form-group">
    <label>Enter Book Quantity </label> <input type = "number" name = "quantity"
    required class = "form-control">
    </div>
    <button class = "btn btn-success">Add Book </button>
   </form>
  </div>
  </div>
  </div>
  </div>
  </div>
 </body>
</html>