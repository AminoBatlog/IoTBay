<%-- 
    Document   : paymentDetails
    Created on : 09/05/2022, 4:56:24 PM
    Author     : Christie
--%>

<%@page import="au.edu.uts.project.domain.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="au.edu.uts.project.domain.Payment"%>
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
            
        Payment payment = (Payment)session.getAttribute("payment");
        Account account = (Account)session.getAttribute("account");
        
        %>
        <h5>You are logged in as ${payment.fname} ${account.lname}(${account.email})</h5><p>
        <div class="container">
        <div class="row justify-content-center text-center">
            <div class="col-5">
                <img src="./assets/pictures/uts.png" alt="Here is a logo" style="height: 40px">
            </div>
        </div>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">IoTBay</a>
        </nav>
        <h3>Your Payment Details</h3>
            <table class="table table-bordered">
                <tr>
                    <th scope="col">Payment Method</th>
                    <th scope="col">Card Number</th>
                    <th scope="col">Expiry Date</th>
                    <th scope="col">Security Code</th>
                    <th scope="col">Name On Card</th>
                </tr>
                <td><%= payment.getPaymentMethod() %></td>
                <td><%= payment.getCardNumber() %></td>
                <td><%= payment.getExpiryDate() %></td>
                <td><%= payment.getSecurityCode() %></td>
                <td><%= payment.getNameOnCard() %></td>
                </tr> 

            </table>
    </body>
</html>
