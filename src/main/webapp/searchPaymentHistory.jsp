<%-- 
    Document   : searchPaymentHistory
    Created on : 09/05/2022, 11:43:25 AM
    Author     : Christie
--%>
<%@page import="au.edu.uts.project.domain.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="au.edu.uts.project.domain.Payment"%>
<%@page import="java.util.List" %>
<html>
<head>
    <title>IoTBay</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js">
    <link rel="stylesheet" href="./assets/css/style.css">
</head>
<body
    <%
        List<Payment> list = (List<Payment>) request.getAttribute("list");
        String msg = (String) request.getAttribute("msg");
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
                            Payment
                        </a>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDropdownMenu2">
                            <li><a class="dropdown-item" href="PaymentHistoryServlet">View Payment History</a></li>
                            <li><a class="dropdown-item" href="SearchPaymentHistoryServlet">Search Payment</a></li>
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
        <h2>Search Payment details by Payment ID and Date Paid</h2>
       
        <form action="${pageContext.request.contextPath}/SearchPaymentHistoryServlet" method="post">
            
        <table>
            <tr>
                <td><label for name="search_PaymentID" class="subtitle">Payment ID </label></td>
                <td><input type ="text" id="searchPayment_ID" name="id" placeholder= "Search by Payment ID"></td>
            </tr>
                
            <tr> 
                <td><label for name="searchPayment_date" class="subtitle">Date Paid </label></td>
                <td><input type ="date" id="searchPayment_date" name="date" placeholder= "Search by Date Paid"></td>
            </tr>
            <tr> 
                <td><input id="search" class="button" type="submit" value="Search"></td>
            </tr>
        </table>
        </form>
            <% if(list != null){
                    for (Payment searchPayment : list){
            %>
            <b><p>Payment Details</p></b>
       
        
        <table>
	<thead>
                <tr>
                    <th scope="col">Payment ID</th>
                    <th scope="col">Order ID</th>
                    <th scope="col">Payment Method</th>
                    <th scope="col">Card Number</th>
                    <th scope="col">Expiry Date</th>
                    <th scope="col">Security Code</th>
                    <th scope="col">Name On Card</th>
                    <th scope="col">Date Paid</th>
                </tr>
        </thead>
        <tbody> 
                <tr>
                    <td><p><%= searchPayment.getPaymentId() %></p></td>
                    <td><p><%= searchPayment.getPaymentId() %></p></td>
                    <td><%= searchPayment.getPaymentMethod() %></td>
                    <td><%= searchPayment.getCardNumber() %></td>
                    <td><%= searchPayment.getExpiryDate() %></td>
                    <td><%= searchPayment.getSecurityCode() %></td>
                    <td><%= searchPayment.getNameOnCard() %></td>
                    <td><%= searchPayment.getPaymentDate() %></td>
                </tr> 
        </tbody>
        </table> 
        
            <%      }
                } else {
            %>
            <span><%=(msg != null ? msg : "")%></span>
            <%
                }
            %>
            
    </body>
</html>
