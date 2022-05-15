<%-- 
    Document   : addPayment
    Created on : 09/05/2022, 11:43:08 AM
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
<body
    <div class="container">
        <div class="row justify-content-center text-center">
            <div class="col-5">
                <img src="./assets/pictures/uts.png" alt="Here is a logo" style="height: 40px">
            </div>
        </div>
    
        <%
            int order_id = (Integer) session.getAttribute("current_order_id");
            double price = (Double) session.getAttribute("current_price");
            String email = (String) session.getAttribute("email");
        %>
        <form action="${pageContext.request.contextPath}/AddPaymentServlet" method="post">
       
            <h1> Order #<%=order_id%> </h1>
            <h2> Total Amount $<%=price%> </h2>

            <div class="body-text">
                <h3><label for name="paymentMethod">Payment Method</label></h3>
                    <input type="text"  name="Payment_method" placeholder="Payment Method" required/>


                <b><label for name="datePaid">Date</label></b>
                    <input type="date" name="Payment_date" placeholder="Date Paid" required/>

                    <div class="personal-information">
                    <h1>Payment Information</h1></div>
                <input type="text" name="paymentid" value="<%=order_id%>" style="display: none">
                <input type="text" name="email" value="<%=email%>" style="display: none">
                <input type="text"  name="cardNumber" placeholder="Card Number" required/>
                <input type="text"  name="expiryDate" placeholder="MM/YY" required/>
                <input type="password" name="securityCode" placeholder="securityCode" required/>
                <input type="text"  name="nameOnCard" placeholder="Name on Card" required/>

                <button type="submit">Confirmed Add</button>
            </div>
        </form>
        <p><a class= "button" style="" href="main.jsp">Cancel</a></p>
    </body>
</html>
