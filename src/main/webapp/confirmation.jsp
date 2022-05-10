<%-- 
    Document   : confirmation
    Created on : May 8, 2022, 10:25:45 AM
    Author     : weichen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
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
            <div class="row d-flex justify-content-center pd-120">
                <div class="col-6">
                    <h1>Your Account Has Been Disabled!</h1>
                    <a href="LogoutServlet">
                        <button type="button" class="btn btn-primary">Return to Index</button>
                    </a>
                </div>
            </div>
        </div>
        
        <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
        <script type="text/javascript" src="./assets/js/jquery.nice-select.min.js"></script>
        <script type="text/javascript" src="./assets/js/main.js"></script>
    </body>
</html>
