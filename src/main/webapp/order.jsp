<%-- 
    Document   : order
    Created on : May 4, 2022, 11:00:23 AM
    Author     : kevin
--%>
<%@page import="au.edu.uts.project.domain.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
        <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
        <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js">
        <link rel="stylesheet" href="./assets/css/style.css">
    </head>
    <body>
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
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Devices
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <a class="dropdown-item" href="#">Something else here</a>
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
