<%-- 
    Document   : paymentHistory
    Created on : 09/05/2022, 11:42:26 AM
    Author     : Christie
--%>
<%@page import="au.edu.uts.project.domain.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="au.edu.uts.project.domain.Payment" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>IoTBay</title>
        <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
        <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js">
        <link rel="stylesheet" href="./assets/css/style.css">
    </head>
    <body>                
    <%
        ArrayList<Payment> list = (ArrayList<Payment>) request.getAttribute("paymentsList");
        String getMessage = (String) request.getAttribute("msg");
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
        <h3>Your Payment History</h3>
            <table class="table table-bordered">
                <tr>
                    <th scope="col">Payment ID    </th>
                    <th scope="col">Order ID    </th>
                    <th scope="col">Payment Method    </th>
                    <th scope="col">Card Number    </th>
                    <th scope="col">Expiry Date    </th>
                    <th scope="col">Security Code    </th>
                    <th scope="col">Name On Card    </th>
                    <th scope="col">Date Paid</th>
                </tr>
                <%  if(list != null){
                        for(Payment payment : list){
                %>
                    <td><p> <%=payment.getPaymentId()%> </p></td>
                    <td><p> <%=payment.getPaymentId()%> </p></td>
                    <td><p> <%=payment.getPaymentMethod()%> </p></td>
                    <td><p> <%=payment.getCardNumber()%> </p></td>
                    <td><p> <%=payment.getExpiryDate()%>  </p></td>
                    <td><p> <%=payment.getSecurityCode()%>  </p></td>
                    <td><p> <%=payment.getNameOnCard()%>  </p></td>
                    <td><p> <%=payment.getPaymentDate()%> </p></td>
                </tr>
                <%      }
                    } else {
                %>
            </table>
            <span class="error"><%=getMessage != null ? getMessage : ""%></span>
                <% } %>
    <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>     
    </body>
</html>
