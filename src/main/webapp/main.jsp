<%--
  Created by IntelliJ IDEA.
  User: FurryDesktop
  Date: 3/27/2022
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="au.edu.uts.project.domain.Account"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IoTBay</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js">
    <link rel="stylesheet" href="./assets/css/style.css">
</head>

<style>
    
  .dropbtn {
  background-color: #121212;
  color: grey;
  padding: 16px;
  font-size: 16px;
  border: none;
}

  .dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}
</style>

<body>
    <%
        Account account = (Account)session.getAttribute("account");
        
        %>
    <div class="container">
        <div class="row justify-content-center text-center">
            <div class="col-5">
                <img src="./assets/pictures/uts.png" alt="Here is a logo" style="height: 40px">
            </div>
        </div>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">IoTBay</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="main.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Index</a>
                    </li>
                    
                    <li class="nav-item dropdown">
                        <a class="dropbtn">Devices</a>
                        <div class="dropdown-content">
                            <a href="#">Action</a>
                            <a href="#">Another action</a>
                            <a href="#">Something else here</a>
                        </div>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="logout.jsp">
                            <button type="button" class="btn btn-primary">Logout</button>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="row d-flex justify-content-center pd-120">
            <div class="col-6">
                <div id="login-form" class="text-center login-register-main">
                    <h4>You are logged in as ${account.fname} ${account.lname}(${account.email})</h4>
                </div>
            </div>
    </div>
</body>
</html>
