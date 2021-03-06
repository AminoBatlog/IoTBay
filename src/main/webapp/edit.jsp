<%-- 
    Document   : edit
    Created on : May 4, 2022, 9:22:45 PM
    Author     : weichen
--%>

<%@page import="au.edu.uts.project.domain.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Account</title>
        <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="./assets/css/select.css">
        <link rel="stylesheet" href="./assets/css/style.css">
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time"></span></div>
        <% 
           Account account = (Account) session.getAttribute("account");
           String updated = (String) session.getAttribute("updated");
           String passErr = (String) session.getAttribute("passErr");
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
        <div class="col-xl-8 order-xl-1">
          <div class="card bg-secondary shadow">
            <div class="card-header bg-white border-0">
              <div class="row align-items-center">
                <div class="col-8">
                  <h3 class="mb-0">My account: <span class="message"><%=(updated != null ? updated : "")%></span></h3>
                </div>
              </div>
            </div>
            <div class="card-body">
              <form method="post" action="UpdateServlet">
                  <h6>User information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="email">Email address</label>
                        <input type="email" name="email" id="email" class="form-control form-control-alternative" value="${account.email}" readonly>
                      </div>
                    </div>
                      <div class="col-lg-6">
                      <div class="form-group focused">
                          <label class="form-control-label" for="password">Password: (<span class="message"><%=(passErr != null ? passErr : "")%></span>)</label>
                        <input type="password" name="password" id="password" class="form-control form-control-alternative" value="${account.password}">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="fname">First name</label>
                        <input type="text" name="fname" id="fname" class="form-control form-control-alternative" value="${account.fname}">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="lname">Last name:</label>
                        <input type="text" name="lname" id="lname" class="form-control form-control-alternative" value="${account.lname}">
                      </div>
                    </div>
                  </div>
                      <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="gender">Gender</label>
                        <input type="text" name="gender" id="gender" class="form-control form-control-alternative" value="${account.gender}">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="dob">Date of Birth</label>
                        <input type="date" name="dob" id="dob" class="form-control form-control-alternative" value="${account.dob}">
                      </div>
                    </div>
                  </div>
                </div>
                <hr class="my-4">
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-4">
                      <div class="form-group focused">
                        <label class="form-control-label" for="address_streetNo">Street No.</label>
                        <input type="number" name="address_streetNo" id="address_streetNo" class="form-control form-control-alternative" value="${account.addressStreetNo}">
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="form-group focused">
                        <label class="form-control-label" for="address_streetName">Street Name</label>
                        <input type="text" name="address_streetName" id="address_streetName" class="form-control form-control-alternative" value="${account.addressStreetName}">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-4">
                      <div class="form-group focused">
                        <label class="form-control-label" for="address_city">City</label>
                        <input type="text" name="address_city" id="addressCity" class="form-control form-control-alternative" value="${account.addressCity}">
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="form-group focused">
                        <label class="form-control-label" for="address_country">Country</label>
                        <input type="text" name="address_country" id="address_country" class="form-control form-control-alternative" placeholder="Country" value="${account.addressCountry}">
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="form-group">
                        <label class="form-control-label" for="address_zipcode">Postal code</label>
                        <input type="number" name="address_zipcode" id="address_zipcode" class="form-control form-control-alternative" value="${account.addressZipcode}">
                      </div>
                    </div>
                  </div>
                </div>
                <hr class="my-4">
                <input class="btn btn-primary" type="submit" value="Update">
              </form>
            </div>
          </div>
        </div>
       </div>
        <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
        <script type="text/javascript" src="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
    </body>
</html>
