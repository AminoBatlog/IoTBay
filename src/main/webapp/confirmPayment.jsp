<%-- 
    Document   : confirmPayment
    Created on : 09/05/2022, 11:41:33 AM
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
        <div class="container">
        <div class="row justify-content-center text-center">
            <div class="col-5">
                <img src="./assets/pictures/uts.png" alt="Here is a logo" style="height: 40px">
            </div>
        </div>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">IoTBay</a>
        </nav>
        <%
            Integer payment_ID = (Integer) session.getAttribute("payment_ID");
        %>
        
        <p> Customer ID #${cust_ID}</p>
        <div class='center'>
    
        <h2>Would you like to confirm your purchase?</h2>
        
        <form action = "main.jsp" method="post">  
            

            <h3>Total Amount A$${order.getAmount()} </h3>
            <div>
                <table style="text-align: center">
           
                <p>Payment Method  = ${payment.getPayment_method()} </p>
                <p>Card Number     = ${payment.getCard_number()} </p>
                <p>Expiry Date     = ${payment.getExpiryDate()} </p>
                <p>Security Code   = ${payment.getSecurityCode()} </p>
                <p>Name On Card    = ${payment.getNameOnCard()} </p>
                <p>Date Paid       = ${payment.getPayment_date()}</p>
    
            <input class= button type="submit" value="Confirm" >
             
        </form>
            <p> <a class ="buttonpaycon" id="column-left" href="DeletePaymentServlet?payment_ID=<%=payment_ID%>">Cancel</a></p>           
        </div>        
    </body>
</html>
