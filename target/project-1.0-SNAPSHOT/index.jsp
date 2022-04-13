<%-- 
    Document   : index
    Created on : Apr 1, 2022, 1:45:21 PM
    Author     : weichen
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/select.css">
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
        <div class="col-6">
            <a href="register.jsp">
                <button type="button" class="btn btn-primary">Register</button>
            </a>
            <a href="login.jsp">
                <button type="button" class="btn btn-secondary">Login</button>
            </a>
        </div>
                <div class="row d-flex justify-content-center pd-120">
            <div class="col-6">
                <div id="login-form" class="text-center login-register-main">
                    <h4>You are not logged in!</h4>
                </div>
            </div>
        </div>
    </div>


    <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="./assets/js/jquery.nice-select.min.js"></script>
    <script type="text/javascript" src="./assets/js/main.js"></script>
</body>
</html>
