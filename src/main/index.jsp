<!DOCTYPE HTML>
<html>
<head>
<title> Home Page </title>
<%@include file= "all_components/all_css.jsp" %>
<style type= "text/css">
 .back-img{
     background: url("img/bgimg.jpg");
     width: 100% ;
     height: 100vh ;
     background-repeat: repeat;
     background-size: cover;
    }
    #topic{
     position: relative;
     top: 205px;
     font-family: "Times New Roman", Times, serif;
     font-weight: 530;
     font-size: 40px;
     text-shadow: 3px 3px 0px #000;
    }
    #footer{
    background-color: cornflowerblue;
    z-index: 1;
    height: 100px;
    width: 100%;
    }
 </style>
</head>
<body>
<%@include file = "all_components/navbar.jsp" %>
<div class = "container-fluid back-img">
<div class = "text-center">
<h1 id = "topic" class= "text-white p-4"> Bookstore Management <br> System </h1>
</div>
</div>
<footer id = "footer">
<footer>
</body>
</html>