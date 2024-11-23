<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored= "false" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
     aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <c:if test = "${empty userObj}">
        <li class="nav-item active">
          <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
        </li>
      </c:if>
      <c:if test= "${userObj.role eq 'Admin'}">
        <li class="nav-item active">
           <a class="nav-link" href="admin.jsp">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
           <a class="nav-link" href="add_books.jsp"> <i class="fa-solid fa-plus"></i> Add Books</a>
        </li>
        <li class="nav-item">
           <a class="nav-link" href="view_books.jsp"> <i class="fa-regular fa-eye"></i> View Books</a>
        </li>
        <li class="nav-item">
           <a class="nav-link" href="view_orders.jsp"> <i class="fa-regular fa-eye"></i> View Orders</a>
        </li>
      </c:if>
      <c:if test= "${userObj.role eq 'User'}">
         <li class="nav-item active">
            <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
         </li>
         <li class="nav-item">
            <a class="nav-link" href="view_cart.jsp"><i class="fa-regular fa-eye"></i> View Cart </a>
         </li>
      </c:if>
    </ul>

    <form class="form-inline my-2 my-lg-0">
       <c:if test = "${userObj.role eq 'Admin'}">
          <a href = "#" class = "btn btn-light mr-1"> <i class="fa-solid fa-user"></i> Admin </a>
          <a href = "logout" class = "btn btn-light">  <i class="fa-solid fa-right-to-bracket"></i> Logout</a>
       </c:if>
       <c:if test = "${userObj.role eq 'User'}">
          <a href = "#" class = "btn btn-light mr-1" data-toggle="modal" data-target="#exampleModal">
              <i class="fa-solid fa-user"></i> View Profile </a>
          <a href = "logout" class = "btn btn-light">  <i class="fa-solid fa-right-to-bracket"></i> Logout</a>
       </c:if>
        <c:if test = "${empty userObj}">
          <a href = "login.jsp" class = "btn btn-light mr-1"> Login </a>
          <a href = "signup.jsp" class = "btn btn-light"> <i class="fa-solid fa-user"></i> Sign Up </a>
        </c:if>
    </form>
  </div>
</nav>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
 <div class="modal-dialog">
 <div class="modal-content">
  <div class="modal-header">
   <h1 class="modal-title fs-5" id="exampleModalLabel">Profile</h1>
   <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close">
    <i class="fa-solid fa-circle-xmark"></i></button>
    </div>
    <div class="modal-body">
     <div class = "card">
     <div class = "card-body">
     <div class = "text-center text-primary">
     <i class = "fas fa-user-circle fa-3x"> </i>
     </div>
     <table class= "table">
     <tbody>
     <tr>
     <th scope = "row"> Name </th>
     <th> ${userObj.name} </th>
     </tr>
     <tr>
     <th scope = "row"> Email </th>
     <th> ${userObj.email} </th>
     </tr>
     </tbody>
     </table>
     </div>
     </div>
      </div>
     <div class="modal-footer">
     <a href = "home.jsp" class="btn btn-secondary bg-danger" data-toggle="modal" data-target="#exampleModalTwo"> Delete your profile </a>
     <a href = "edit_user_profile.jsp" class="btn btn-primary"> Edit</a>
    </div>
   </div>
 </div>
</div>

<div class="modal bg-secondary" tabindex="-1" id = "exampleModalTwo">
 <div class="modal-dialog">
  <div class="modal-content">
   <div class="modal-header">
    <h5 class="modal-title text-danger">Confirm deletion!</h5>
    <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"><i class="fa-solid fa-circle-xmark"></i></button>
    </div>
    <div class="modal-body">
    <p>Are you sure?</p>
    </div>
    <div class="modal-footer">
    <a href= "deleteProfile?id=${userObj.id}" class="btn btn-sm btn-danger">Yes</a>
    <button type="button" class="btn-close btn-primary" data-dismiss = "modal" aria-label="Close">No</button>
    </div>
   </div>
  </div>
</div>