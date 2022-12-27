<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Form </title>

<script>
function validation()
{
	var categorytitle = document.getElementById("categorytitle").value;
	if(categorytitle == null || categorytitle ==""){
		var categorytitleError = document.getElementById("categorytitleError").innerHTML = "please enter the category title";
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
 <div class="col-md-5">
  
  <h2><i class="glyphicon glyphicon-user"></i>Category Form</h2>

<form action="" method="post" class="form-group" onsubmit="return validation();">
<div class="form-group">
<label>Category Title</label>
<input type="text" name="cTitle" class="form-control" id="categorytitle">
<p id="categorytitleError" style="color:red;"></p>
</div>

<div class="form-group">
<label>Description</label>
<textarea name="cDescription" class="form-control" rows="9"></textarea>
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