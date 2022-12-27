<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User profile</title>
</head>
 <link href="${pageContext.request.contextPath}/resources/img/favicon.png" rel="icon">
  <link href="${pageContext.request.contextPath}/resources/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<body>
<div id = "wrapper">
<!-- sidebar -->

 <div id="content-wrapper" class="d-flex flex-column">
<div id="content">
<div class="container">

<div class="row">
	<div class="col-md-10">
	</div>
	<div class="col-md-2">
	<a class="btn btn-danger" href="${pageContext.request.contextPath }/logout">Logout</a>
	</div>
</div>
 <div class="row">
 
 <div >
  
  
  <h2 class="text-center"><i class="glyphicon glyphicon-user"></i>User Information Display</h2>
  <div class="col-md-12 d-flex justify-content-center">
  <table class="table table-striped ">
  <thead>
    <tr>
      <th scope="col">NAME</th>
     <th scope="col">EMAIL</th>
      <th scope="col">ADDRESS</th>
       <th scope="col">PHONE</th>
       
    </tr>
  </thead>
  <tbody>
  
<tr>
<td>${userdetail.uName}</td>
<td>${userdetail.uEmail}</td>
<td>${userdetail.uAddress }</td>
<td>${userdetail.uPhone}</td>

</tr>

  </tbody>
  </table>
  </div>  
</div>
</div>

<div class="row">
 
 <h2><i class="glyphicon glyphicon-user"></i>User Notification Display</h2>
  <div class="col-md-12 d-flex justify-content-center">
  <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Notice</th>
      <th scope="col">Order</th>
     <th scope="col">Viewed</th>
      <th scope="col">Date</th>
       
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${notification_list }" var="notice">  
<tr>
<td>${notice.notice}</td>
<td>${notice.orderModel.products.pName }</td>
<td>${notice.viewed}</td>
<td>${notice.date }</td>
</tr>
 </c:forEach>
  </tbody>
  </table>
 </div>
 </div>



<div class="row">
 
 <h2><i class="glyphicon glyphicon-user"></i>User Cart Display</h2>
  <div class="col-md-12 d-flex justify-content-center">
  <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Product</th>
     <th scope="col">Date</th>
      <th scope="col">Quantity</th>
       
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${cart_list }" var="cart">  
<tr>
<td>${cart.cartId}</td>
<td>${cart.product.pName }</td>
<td>${cart.date}</td>
<td>${cart.quantity }</td>
</tr>
 </c:forEach>
  </tbody>
  </table>
 </div>
 </div>
 
 
 
<div class="row">
 
 <h2><i class="glyphicon glyphicon-user"></i>User Order Display</h2>
  <div class="col-md-12 d-flex justify-content-center">
  <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Product</th>
     <th scope="col">date</th>
      <th scope="col">status</th>
       
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${order_list }" var="order">  
<tr>
<td>${order.orderId}</td>
<td>${order.products.pName }</td>
<td>${order.date}</td>
<td>${order.status }</td>
</tr>
 </c:forEach>
  </tbody>
  </table>
 </div>
 </div>
 
 

</div>

</div>
</div>


</body>
</html>