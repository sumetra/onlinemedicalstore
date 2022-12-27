<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Update Form </title>

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
  
  <h2><i class="glyphicon glyphicon-user"></i>Product Update Form</h2>

<form action="${pageContext.request.contextPath}/admin/product_update" method="post" class="form-group" enctype="multipart/form-data">

<input type="text" name="pId" class="form-control" value = "${product.pId }" hidden>
<div class="form-group">

<label>Medicine Name</label>
<input type="text" name="pMedicine" class="form-control" value = "${product.pMedicine }">
</div>
<div class="form-group">

<label>Product Name</label>
<input type="text" name="pName" class="form-control" value = "${product.pName }">
</div>
<div class="form-group">
<label>Description</label>
<textarea name="pDescription" class="form-control" rows="9">"${product.pDescription}" </textarea>
</div>
<div class="form-group">
<label>Product Photo</label>
<input type="file" name="pPhoto" class="form-control" >
<input type="text" name="oldphoto" class="form-control" value="${product.pPhoto } " readonly>
</div>
<div class="form-group">
<label>Product Price</label>
<input type="text" name="pPrice" class="form-control" value = "${product.pPrice }">
</div>
<div class="form-group">
<label>Product Quantity</label>
<input type="text" name="pQuantity" class="form-control" value = "${product.pQuantity }">
</div>
<div class="form-group">
<label>Category </label>
<select name=cId class="form-control">
<c:forEach var="cat" items="${category_list }">
<option  value = "${cat.cId }" 
<c:if test="${product.category.cId eq cat.cId }">selected</c:if>
>${cat.CTitle }</option>
</c:forEach>
</select>
</div>


<div class="form-group">
<button type="submit" name="submit" value="submit" class="btn btn-primary">Update</button>
</div>


</form>
</div>

</div>
</div>
</div>
<%@include file="footer.jsp" %>
</div>
</div>
</body>
</html>