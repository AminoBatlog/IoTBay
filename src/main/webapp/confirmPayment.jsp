<%-- 
    Document   : confirmPayment
    Created on : 09/05/2022, 11:41:33 AM
    Author     : Christie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="au.edu.uts.project.domain.Payment"%>
<%@page import="au.edu.uts.project.domain.Order"%>
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
            Payment payment = (Payment) request.getAttribute("payment");
            int order_id = (Integer) session.getAttribute("current_order_id");
            double price = (Double) session.getAttribute("current_price");
        %>
        
  
        <div class='center'>
        <%
            if(payment != null){
        %>
            <h2>Would you like to confirm your purchase?</h2>


                <h3> Order #<%=order_id%> </h3>
                <h4>Total Amount $<%=price%> </h4>
                <div>
                    <table style="text-align: center">

                    <p>Payment Method  = <%=payment.getPaymentMethod()%> </p>
                    <p>Card Number     = <%=payment.getCardNumber()%> </p>
                    <p>Expiry Date     = <%=payment.getExpiryDate()%> </p>
                    <p>Name On Card    = <%=payment.getNameOnCard()%> </p>


            <a href="${pageContext.request.contextPath}/ConfirmedPaymentServlet?order_id=<%=order_id%>">Confirm</a>
            <p> <a class ="buttonpaycon2"  href="UpdatePaymentServlet?payment_id=<%=order_id%>">Update Details</a></p>
            <p> <a class ="buttonpaycon2"  href="DeletePaymentServlet?payment_id=<%=order_id%>">Remove Payment</a></p>
            <p> <a class ="buttonpaycon"  href="OrderLineServlet?display=<%=order_id%>">Cancel</a></p>
        <% } else {%>
            <h2>You don't have any payment related to this order, <a href="${pageContext.request.contextPath}/addPayment.jsp" style="color: yellow;">click me to add one?</a></h2>
        <% }%>
        </div>
            <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
            <script type="text/javascript">

            </script>
    </body>
</html>
