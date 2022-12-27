<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>order display </title>
</head>
<body>
<div id = "wrapper">
<!-- sidebar -->
<%@include file="sidebar.jsp" %>
 <div id="content-wrapper" class="d-flex flex-column">
<div id="content">
<%@include file="topbar.jsp" %>
<div class="container-fluid">
 <div class="row">
 <div class="col-md-5">
  
  
  <h2><i class="glyphicon glyphicon-user"></i>ORDER INFORMATION DISPLAY</h2>

  <div class= "col-md-12">
  <div class= "col-md-6">
  <form action="${pageContext.request.contextPath}/admin/search" method="get" class="form-group" >
<div class="form-group">
<label>Search By Date</label>
<input type="date" name=date class="form-control">


<button class="btn btn-primary">Submit</button>
  </div>
 </form>
 </div>
 
</div>


<table class="table table-striped table-dark">
  <thead>
    <tr>
     <th scope="col">S.N</th>
       <th scope="col">Order Id</th>
      <th scope="col">PRODUCT</th>
      <th scope="col">USER</th>
     <th scope="col">DATE</th>
      <th scope="col">QUANTITY</th>
      <th scope="col">Unit Price</th>
       <th scope="col">Total Price</th>
      <th scope="col">STATUS</th>
      <th scope="col">UPDATE</th>
      
    </tr>
  </thead>
  <tbody>
 <c:set var = "count" value = "1"/>
  <c:set var="grand_total" value="0"/>
 <c:forEach var="order" items="${view}">
<tr>
<td>${count}</td>
<td>${order.orderId}</td>
<td>${order.products.pName}</td>
<td>${order.user.uName }</td>
<td>${order.date}</td>
<td>${order.quantity }</td>
<td>${order.products.pPrice }</td>
<td>${order.quantity * order.products.pPrice}</td>
 <c:set var="grand_total" value="${grand_total +  order.quantity * order.products.pPrice}"/>
<td>  
<form action="${pageContext.request.contextPath}/admin/order/update/${order.oId}" method="post">
<div class="form-control">
<select name="status"> 
<option value="NULL">----select an option----</option>
<c:forEach items="${orderStatus }" var="oitem"> 
 	<option value="${oitem }" <c:if test="${oitem.equals(order.status) }">selected</c:if>>${oitem }</option>
 </c:forEach>
</select>


</td>
<td>
<button type="submit" class="">Update</button>
</div>
</form>
</td>
</tr>
<c:set var = "count" value = "${count + 1 }"/>
</c:forEach>

</tbody>
  </table>
</div>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
</div>
</div>
</body>
</html>