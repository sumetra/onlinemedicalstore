<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Register</title>

    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/assests/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/assests/css/sb-admin-2.min.css" rel="stylesheet">
<script>
function validation()
{
	/* return false; */
	/* var submit=false; */
	//list elements
	
var name = document.getElementById("name").value;
 var  password = document.getElementById("password").value; 
 var  email = document.getElementById("email").value;  
 var  address = document.getElementById("address").value;  
 var  number = document.getElementById("number").value;  

if(name == null || name =="")
{
var nameError = document.getElementById("nameError").innerHTML= "please enter the name";
return false;
}
 if(password == null || password ==""){
	var passwordError = document.getElementById("passwordError").innerHTML = "please enter the password";
	return false;
}
if(email == null || email ==""){
	var emailError = document.getElementById("emailError").innerHTML = "please enter the email";
	return false;
} 
if(address == null || address ==""){
	var addressError = document.getElementById("addressError").innerHTML = "please enter the address";
	return false;
} 
if(number == null || number ==""){
	var numberError = document.getElementById("numberError").innerHTML = "please enter the number";
	return false;
} 
if(!passwordMatch()){
	return false;
}
 			return true;
 /* else
{
var nameError = document.getElementById("nameError").innerHTML="";
submit= true;
} */



/* else
	{
	var passwordError = document.getElementById("passwordError").innerHTML = "";
	submit= true;
	} */
	


/* else
	{
	var emailError = document.getElementById("emailError").innerHTML = "";
	submit= true;
	} */
	/* return submit; */
		
	

}
function passwordMatch()
{
	var password = document.getElementById("password").value;
	var rePassword = document.getElementById("rePassword").value;
	
	if(password != rePassword)
		{
		var rePass = document.getElementById("rePass").innerHTML="Password is mismatch";
		return false;
		}
	return true;
	
	
}



</script>

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-3 d-none d-lg-block bg"></div>
                    <div class="col-lg-9">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form action="" method="post" class="user" onsubmit="return validation();">
<div class="form-group">
<label>User Name</label>
<input type="text" name="uName" class="form-control" id="name">
<p id="nameError" style="color: red;"></p>
</div>
<div class="form-group">
<label>Password</label>
<input type="password" name="uPassword" class="form-control" id="password" >
<p id="passwordError" style="color:red;"></p>
</div>

<div class="form-group">
<label>Confirm Password</label>
<input type="password" name="cPassword" class="form-control" id="rePassword" >
<p id="rePass" style="color:red;"></p>
</div>


<div class="form-group">
<label>Email</label>
<input type="email" name="uEmail" class="form-control" id="email">
<p id="emailError" style="color:red;"></p>
</div>

<div class="form-group">
<label>Address</label>
<input type="text" name="uAddress" class="form-control" id="address">
<p id="addressError" style="color:red;"></p>

</div>

<div class="form-group">
<label>Phone Number</label>
<input type="text" name="uPhone" class="form-control" id="number">
<p id="numberError" style="color:red;"></p>
</div>

<div class="form-group">
<button type="register" name="submit" value="register" id="submit" class="btn btn-primary">Register</button>
</div>


</form>
                            <hr>
                           <!--   <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.html">Already have an account? Login!</a>
                            </div>
                        </div> -->
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/assests/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/assests/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/assests/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/assests/js/sb-admin-2.min.js"></script>

</body>

</html>




