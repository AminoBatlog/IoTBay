<%-- 
    Document   : updatePayment
    Created on : 09/05/2022, 11:41:57 AM
    Author     : Christie
--%>


<%@page import="java.util.ArrayList"%>
<%@ page import="au.edu.uts.project.domain.Payment" %>
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
                        <a class="nav-link" href="logout.jsp">
                            <button type="button" class="btn btn-primary">Logout</button>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <%
            int orderid = (Integer) session.getAttribute("current_order_id");
            double price = (Double) session.getAttribute("current_price");
            Payment payment = (Payment) request.getAttribute("exist");
            %>
        <form action = "${pageContext.request.contextPath}/UpdatePaymentServlet" method="post">
        
            <h1> Order #<%=orderid%> </h1>
            <h2> Total Amount $<%=price%> </h2>

            <div class="body-text">
      
<%--                <div class="form-container">--%>
<%--                <div class="personal-information">--%>
                <h1>Payment Information</h1></div>
                <input type="text" name="paymentid" value="<%=payment.getPaymentId()%>" style="display: none">
                <input type="text" name="email" value="<%=payment.getEmail()%>" style="display: none">
                <input type="text" name="paymentMethod" placeholder="Payment Method"  value="<%=payment.getPaymentMethod()%>" required>
                <input type="text" name="cardNumber" placeholder="Card Number" value="<%=payment.getCardNumber()%>" required/>
                <input type="text" name="expiryDate" placeholder="MM/YY" value="<%=payment.getExpiryDate()%>" required/>
                <input type="password" name="securityCode" placeholder="Security Code" value="<%=payment.getSecurityCode()%>" required/>
                <input type="text" name="nameOnCard" placeholder="Name on Card" value="<%=payment.getNameOnCard()%>" required/>
                <input type="text" name="paymentdate" value="<%=payment.getPaymentDate()%>" style="display: none">

                <input type="submit" value="Update">
            </form>
                    
            <p><a class= "button"  href="OrderLineServlet?display=<%=orderid%>">Cancel</a></p>
            
    </body>
</html>

