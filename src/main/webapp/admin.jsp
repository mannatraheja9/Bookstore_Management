<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored= "false" %>
<!DOCTYPE HTML>
<html>
 <head>
  <title> Admin </title>
  <%@include file= "all_components/all_css.jsp" %>
 </head>
 <body>
 <c:if test = "${userObj.role ne 'Admin'}">
 <c:redirect url = "login.jsp"></c:redirect>
 </c:if>
 <%@include file = "all_components/navbar.jsp" %>
 <div class = "container-fluid">
  <div class = "text-center">
   <h1 class = "text-black p-4"> Welcome Admin! </h1>
  </div>
  <img src= "img/admin_img.jpg" alt= "Admin image">
 </div>
 </body>
</html>