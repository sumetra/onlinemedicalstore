<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assests/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/assests/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>

 <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fa fa-plus-square"></i>
                </div>
                <div class="sidebar-brand-text mx-3">MediServe</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.html">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
               Menu
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            
             <!-- li class="nav-item">
                <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/category_form" >
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Category</span>
                   
                </a>
                
            </li-->
            
            <!-- li class="nav-item">
                <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/product_form" >
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Product</span>
                   
                </a>
                
            </li-->
            
             <!--  li class="nav-item">
                <a class="nav-link collapsed" href="${pageContext.request.contextPath}/admin/user_form" >
                    <i class="fas fa-fw fa-cog"></i>
                    <span>User</span>
                   
                </a>
                
            </li-->
            
            
            <!-- if necessary use this -->
            
             <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOne"
                    aria-expanded="true" aria-controls="collapseOne">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Category</span>
                   
                </a>
                <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Category Info</h6>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/admin/category_form">Category Insert</a>
                      <a class="collapse-item" href="${pageContext.request.contextPath}/admin/category_display">Display Category</a> 
                    </div>
                </div>
            </li> 
            
              <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseThree"
                    aria-expanded="true" aria-controls="collapseThree">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Products</span>
                   
                </a>
                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Product Info</h6>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/admin/product_form">Product Insert</a>
                      <a class="collapse-item" href="${pageContext.request.contextPath}/admin/product_display">Display Product</a> 
                    </div>
                </div>
            </li> 
            
            
            
             <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Users</span>
                   
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">User Info</h6>
                      <!-- -  <a class="collapse-item" href="${pageContext.request.contextPath}/admin/user_form">User Insert</a> -->
                      <a class="collapse-item" href="${pageContext.request.contextPath}/admin/user_display">Display User</a> 
                    </div>
                </div>
            </li> 
            
             <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFour"
                    aria-expanded="true" aria-controls="collapseFour">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Restock</span>
                   
                </a>
                <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Restock Info</h6>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/admin/restock_form">Restock Insert</a>
                      <a class="collapse-item" href="${pageContext.request.contextPath}/admin/restock_display">Display Restock</a> 
                    </div>
                </div>
            </li> 
            
              <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseFive"
                    aria-expanded="true" aria-controls="collapseFive">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Order Information</span>
                   
                </a>
                <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Order Info</h6>
                        <a class="collapse-item" href="${pageContext.request.contextPath}/admin/order_display">Order Display</a>
                      
                    </div>
                </div>
            </li> 
            
            

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Utilities</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Custom Utilities:</h6>
                        <a class="collapse-item" href="utilities-color.html">Colors</a>
                        <a class="collapse-item" href="utilities-border.html">Borders</a>
                        <a class="collapse-item" href="utilities-animation.html">Animations</a>
                        <a class="collapse-item" href="utilities-other.html">Other</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            

        </ul>

</body>
</html>