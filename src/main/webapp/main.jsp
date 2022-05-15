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
    <script type="text/javascript" src="./assets/js/script.js"></script>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js">
    <link rel="stylesheet" href="./assets/css/style.css">
</head>
<body onload="startTimer()">
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
                        <a class="nav-link" href="accountInfo.jsp">My Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AccessServlet?email='<%= account.getEmail()%>'&password='<%=account.getPassword()%>'">Access Log</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="OrderServlet?display=<% out.print(account.getEmail()); %>">Order</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="IotDevServlet?list=true">Device List</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenu2" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Profile
                        </a>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDropdownMenu2">
                            <li><a class="dropdown-item" href="AddPaymentServlet">Create Payment Details</a></li>
                            <li><a class="dropdown-item" href="paymentDetails.jsp">View Payment Details</a></li>
                            <li><a class="dropdown-item" href="UpdatePaymentServlet">Update Payment Details</a></li>
                            <li><a class="dropdown-item" href="paymentHistory.jsp">View Payment History</a></li>
                            <li><a class="dropdown-item" href="SearchPaymentHistoryServlet">Search For Payment</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="UpdateLogoutServlet?email='<%= account.getEmail()%>'&password='<%=account.getPassword()%>'">
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
    </div>
    <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</body>
</html>
