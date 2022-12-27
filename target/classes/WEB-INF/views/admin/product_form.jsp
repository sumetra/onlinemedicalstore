<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Form </title>
<script>
function validation()
{
	var medicine = document.getElementById("medicine").value;
	 var  product = document.getElementById("product").value; 
	 var  price = document.getElementById("price").value;  
	 var  quantity = document.getElementById("quantity").value;  
	

	if(medicine == null || medicine =="")
	{
	var medicineError = document.getElementById("medicineError").innerHTML= "please enter the medicine";
	return false;
	}
	 if(product == null || product ==""){
		var productError = document.getElementById("productError").innerHTML = "please enter the product";
		return false;
	}
	if(price == null || price ==""){
		var priceError = document.getElementById("priceError").innerHTML = "please enter the price";
		return false;
	} 
	if(quantity == null || quantity ==""){
		var quantityError = document.getElementById("quantityError").innerHTML = "please enter the quantity";
		return false;
	} 
	
	
	 			return true;
}

</script>


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
 <div class="col-md-4">
  
  <h2><i class="glyphicon glyphicon-user"></i>Product Form</h2>

<form action="${pageContext.request.contextPath}/admin/product_form" method="post" class="form-group" enctype="multipart/form-data" onsubmit="return validation();">
<div class="form-group">
<label>Medicine Name</label>
<input type="text" name="pMedicine" class="form-control" id="medicine">
<p id="medicineError" style="color:red;"></p>
</div>
<div class="form-group">
<label>Product Name</label>
<input type="text" name="pName" class="form-control" id="product">
<p id="productError" style="color:red;"></p>
</div>

<div class="form-group">
<label>Description</label>
<textarea name="pDescription" class="form-control" rows="9"></textarea>
</div>
<div class="form-group">
<label>Photo</label>
<input type="file" name="pPhoto" class="form-control">
</div>
<div class="form-group">
<label for="sub_code">Price</label>
<input type="text" name="pPrice" class="form-control" id="price">
<p id="priceError" style="color:red;"></p>
</div>
<div class="form-group">
<label>Quantity</label>
<input type="text" name="pQuantity" class="form-control" id="quantity">
<p id="quantityError" style="color:red;"></p>
</div>
<div class="form-group" id="category">
<p id="categoryError" style="color:red;"></p>
<label>Category</label>
<select name=cId class="form-control">
<c:forEach var="list" items="${cid }">
<option value = "${list.cId }">${list.CTitle }</option>
</c:forEach>
</select>
</div>

<div class="form-group">
<button type="submit" name="submit" value="submit" class="btn btn-primary">Submit</button>
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