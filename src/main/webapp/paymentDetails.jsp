<%-- 
    Document   : paymentDetails
    Created on : 09/05/2022, 4:56:24 PM
    Author     : Christie
--%>

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
        <h1>Your</h1>
        <h4>You are logged in as ${payment.fname} ${account.lname}(${account.email})</h4>
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
                        <a class="nav-link" href="index.jsp">Index</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Devices
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Profile
                        </a>
                        <div class="dropdown-menu2" aria-labelledby="navbarDropdownMenu2">
                            <a class="dropdown-item" href="addPayment.jsp">Create Payment Details</a>
                            <a class="dropdown-item" href="paymentDetails.jsp">View Payment Details</a>
                            <a class="dropdown-item" href="updatePayment.jsp">Update Payment Details</a>
                            <a class="dropdown-item" href="paymentHistory.jsp">View Payment History</a>
                            <a class="dropdown-item" href="searchPaymentHistory">Search For Payment</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout.jsp">
                            <button type="button" class="btn btn-primary">Logout</button>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <h1>Your Payment Details</h1>
            <%
        Payment payment = (Payment)session.getAttribute("payment");
        
        %>
            <table>
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
