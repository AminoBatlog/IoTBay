<%-- 
    Document   : registerType
    Created on : May 8, 2022, 9:29:20 PM
    Author     : weichen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <a href="index.jsp">
                <button type="button" class="btn btn-dark">Return</button>
            </a>
        </div>
        <div class="row d-flex justify-content-center pd-120">
            <div class="col-6">
                <div id="login-form" class="text-center welcome-main">
                    <h2>Sign-Up as:</h2>
                    <a href="register.jsp">
                        <button type="button" class="btn btn-primary btn-lg">Customer</button>
                    </a>
                    <a href="staffRegister.jsp">
                        <button type="button" class="btn btn-secondary btn-lg">Staff</button>
                    </a>
                </div>
            </div>
        </div>     
    </div>

    <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="./assets/js/jquery.nice-select.min.js"></script>
    <script type="text/javascript" src="./assets/js/main.js"></script>
    </body>
</html>
