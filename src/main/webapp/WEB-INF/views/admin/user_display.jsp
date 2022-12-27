<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Display</title>
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
  
  
  <h2><i class="glyphicon glyphicon-user"></i>USER INFORMATION DISPLAY</h2>
  
  <table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">S.N</th>
      <th scope="col">NAME</th>
      <th scope="col">PASSWORD</th>
     <th scope="col">EMAIL</th>
      <th scope="col">ADDRESS</th>
       <th scope="col">PHONE</th>
       <th scope="col">DELETE</th>
      <th scope="col">EDIT</th>
      
      
    </tr>
  </thead>
  <tbody>
  <c:set var = "count" value = "1"/>
 <c:forEach var="list" items="${ulist}">
<tr>
<td>${count}</td>
<td>${list.uName}</td>
<td>${list.uPassword }</td>
<td>${list.uEmail}</td>
<td>${list.uAddress }</td>
<td>${list.uPhone}</td>


<td><a href="user_delete/${list.uId}">DELETE</a></td>
<td><a href="user_update/${list.uId}">UPDATE</a></td>
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