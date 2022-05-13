<%-- 
    Document   : addPayment
    Created on : 09/05/2022, 11:43:08 AM
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
<body
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
                            <a class="dropdown-item" href="searchPaymentHistory.jsp">Search For Payment</a>
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
        <form action="addPaymentServlet" method="post">
       
        <h1> Order #${order_ID} </h1>
        <h2> Total Amount $${order.getAmount()} </h2>
        
        <div class="body-text"> 
            <h3><label for name="paymentMethod">Payment Method</label></h3>
                <input type="text" id="coloumn-left" name="Payment_method" placeholder="Payment Method" required/>
      
 
            <b><label for name="datePaid">Date</label></b>
                <input type="date" id="coloumn-left" name="Payment_date" placeholder="Date Paid" required/> 
          
                <div class="personal-information">
                <h1>Payment Information</h1></div> 
            
            <input type="text" id="input-field" name="cardNumber" placeholder="Card Number" required/> 
            <input type="text" id="input-field" name="expiryDate" placeholder="MM/YY" required/> 
            <input type="password" id="input-field" name="securityCode" placeholder="securityCode" required/> 
            <input type="text" id="input-field" name="nameOnCard" placeholder="Name on Card" required/> 
             
            <input type="submit" value="Pay">
        </form>
       
            <p><a class= "button" style="center" href="main.jsp">Cancel</a></p>
                
        </div>
    </body>
</html>
