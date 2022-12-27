<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Update Form </title>

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
  
  <h2><i class="glyphicon glyphicon-user"></i>Category Update Form</h2>

<form action="" method="post" class="form-group">

<input type="text" name="cId" class="form-control" value = "${cTitle.cId }" hidden>
<div class="form-group">

<label>Category Title</label>
<input type="text" name="cTitle" class="form-control" value = "${cTitle.CTitle }">
</div>

<div class="form-group">
<label>Description</label>
<textarea name="cDescription" class="form-control" rows="9">"${cTitle.cDescription}" </textarea>
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