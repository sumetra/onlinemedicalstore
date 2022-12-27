<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Update Form </title>

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
  
  <h2><i class="glyphicon glyphicon-user"></i>User Update Form</h2>

<form action="" method="post" class="form-group">

<input type="text" name="uId" class="form-control" value = "${uName.uId }" hidden>
<div class="form-group">

<label>User Name</label>
<input type="text" name="uName" class="form-control" value = "${uName.uName }">
</div>
<div class="form-group">
<label>Password</label>
<input type="text" name="uPassword" class="form-control" value = "${uName.uPassword }">
</div>
<div class="form-group">
<label>Email</label>
<input type="text" name="uEmail" class="form-control" value = "${uName.uEmail }">
</div>
<div class="form-group">
<label>Address</label>
<input type="text" name="uAddress" class="form-control" value = "${uName.uAddress }">
</div>
<div class="form-group">
<label>Phone</label>
<input type="text" name="uPhone" class="form-control" value = "${uName.uPhone }">
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