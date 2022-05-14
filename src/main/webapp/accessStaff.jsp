<%-- 
    Document   : access
    Created on : May 7, 2022, 11:59:50 AM
    Author     : weichen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="au.edu.uts.project.domain.AccountAccess"%>
<%@page import="au.edu.uts.project.domain.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Log</title>
    </head>
    <body onload="resetSearch()">
        <% 
            Staff staff = (Staff) session.getAttribute("staff");
            String existErr = (String) session.getAttribute("existErr");
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
                        <a class="nav-link" href="mainStaff.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="staffInfo.jsp">My Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AccessServlet?email='<%= staff.getEmail()%>'&password='<%=staff.getPassword()%>'">Access Log</a>
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
        <h1>Access Log: <span class="message"><%=(existErr != null ? existErr : "")%></span></h1>
        <form method="post" action="SearchServlet?email='<%= staff.getEmail()%>'&password='<%=staff.getPassword()%>'">
            <div class="input-group">
                <div class="form-outline">
                    <input type="date" class="form-control rounded" aria-label="Search" aria-describedby="search-addon" name="date"/>
                </div>
                <button type="submit" class="btn btn-primary">search</button>
            </div>   
        </form>
        <table border="1" cellpadding="5">
            <tr>
                <th>Email</th>
                <th>Login Date</th>
                <th>Login Time</th>
                <th>Logout Date</th>
                <th>Logout Time</th>
            </tr>
            <c:forEach var="access" items="${list}">
                <tr>
                    <td><c:out value="${access.email}"/></td>
                    <td><c:out value="${access.inDate}"/></td>
                    <td><c:out value="${access.inTime}"/></td>
                    <td><c:out value="${access.outDate}"/></td>
                    <td><c:out value="${access.outTime}"/></td>
               </tr>
            </c:forEach>
        </table>
     </div>
    <script type="text/javascript" src="./assets/js/script.js"></script>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="./assets/js/script.js"></script>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js">
    <link rel="stylesheet" href="./assets/css/style.css">
   </body>
</html>
