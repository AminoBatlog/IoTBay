<%--
  Created by IntelliJ IDEA.
  User: FurryDesktop
  Date: 3/28/2022
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="au.edu.uts.project.domain.Account"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Welcome</title>
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
                <div id="login-form" class="text-center welcome-main">
<%--                    <h4>Successful Registration!</h4>--%>
                    <%
                        Account account = (Account) session.getAttribute("account");
;                        %>
                        <h1>Welcome, <%= account.getFname() %> <%= account.getLname() %>!</h1>
                        <p>Your Username is <%= account.getUsername() %>.</p>
                        <p>Your Email is <%= account.getEmail() %>.</p>
                        <p>Your Password is <%= account.getPassword() %>.</p>
                        <p>Your Gender is <%= account.getGender() %>.</p>
                        <p>Your Country is <%= account.getAddressCountry() %>.</p>
                        <p>Your State is <%= account.getAddressState() %>.</p>
                        <p>Your Street is <%= account.getAddressCity() %>.</p>
                        <p>Your Date of Birth is <%= account.getDob() %>.</p>
                    <a href="main.jsp" class="btn btn-primary">Go to Main Page</a>
                </div>
            </div>
        </div>     
    </div>

    <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="./assets/js/jquery.nice-select.min.js"></script>
    <script type="text/javascript" src="./assets/js/main.js"></script>
</body>
</html>


