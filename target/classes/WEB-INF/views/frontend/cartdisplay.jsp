<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Display</title>

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

</head>
<body>

<div class="container-fluid">
 <div class="row">
 <div class="col-md-5">
  
  
  <h2><i class="glyphicon glyphicon-user"></i>CART INFORMATION DISPLAY</h2>
<form action = "${pageContext.request.contextPath}/user/order/add" method="get">
<table class="table table-striped table-dark">
  <thead>
    <tr>
       <th scope="col">S.N</th>
       <th scope="col">Select Item</th>
      <th scope="col">PRODUCT</th>
      <th scope="col">USER</th>
     <th scope="col">DATE</th>
      <th scope="col">QUANTITY</th>
      <th scope="col">EDIT</th>
      <th scope="col">DELETE</th>
      
    </tr>
  </thead>
   <tbody>
  <c:set var = "count" value = "1"/>
 <c:forEach var="list" items="${clist}">
<tr>
<td>${count}</td>
<td><input  name="carts" value="${list.cartId }" type="checkbox"></td>
<td>${list.product.pName}</td>
<td>${list.user.uName }</td>
<td>${list.date}</td>
<td>${list.quantity }</td>

<td><a href="${pageContext.request.contextPath}/user/cart/delete/${list.cartId}">DELETE</a></td>
<td><a href="${pageContext.request.contextPath}/user/cart/update/${list.cartId}">UPDATE</a></td>
</tr>
<c:set var = "count" value = "${count + 1 }"/>
</c:forEach>
  </tbody> 
  </table>
  
  <div class="row">
 <div class="col-md-5">
 <input type="submit" value="Make an order">
  </div>
 </div>
</form>

</div>
</div>
</div>

         
</body>
</html>