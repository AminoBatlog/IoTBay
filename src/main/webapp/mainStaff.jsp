<%--
  Created by IntelliJ IDEA.
  User: FurryDesktop
  Date: 3/27/2022
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="au.edu.uts.project.domain.Staff"%>
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
        Staff staff = (Staff)session.getAttribute("staff");
        
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
                        <a class="nav-link" href="MainServlet?email='<%= staff.getEmail()%>'">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="staffInfo.jsp">My Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AccessServlet?email='<%= staff.getEmail()%>'&password='<%=staff.getPassword()%>'">Access Log</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="IotDevServlet?list=true">Device List</a>
                    </li>
                    <% 
                       if (staff.getRoles().equals("Admin")) {
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="StaffServlet?list=true">Staff List</a>
                    </li>
                    <% } 
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="UpdateLogoutServlet?email='<%= staff.getEmail()%>'&password='<%=staff.getPassword()%>'">
                            <button type="button" class="btn btn-primary">Logout</button>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="row d-flex justify-content-center pd-120">
            <div class="col-6">
                <div id="login-form" class="text-center login-register-main">
                    <h4>You are logged in as ${staff.staffFname} ${staff.staffLname}(${staff.email})</h4>
                </div>
            </div>
        </div>       
    </div>
</body>
</html>
