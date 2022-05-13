<%@page import="au.edu.uts.project.domain.Customer"%><%--
    Document   : Customer-update
    Created on : 2022年5月14日, 上午12:02:45
    Author     : 11493
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update daya</title>
        <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="./assets/css/select.css">
        <link rel="stylesheet" href="./assets/css/style.css">
    </head>
    <body>
        <div><span class="time" id="time"></span></div>
        <% 
           Customer customer = (Customer) session.getAttribute("customer");
           String updated = (String) session.getAttribute("updated");
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
                        <a class="nav-link" href="mainStaff.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="staffInfo.jsp">Detail</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AccessServlet?email='<%= customer.getEmail()%>'&password='<%=customer.getPassword()%>'">Access Log</a>
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
                        <a class="nav-link" href="UpdateLogoutServlet?email='<%= customer.getEmail()%>'&password='<%=customer.getPassword()%>'">
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
                  <h6>customer information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="email">Email address</label>
                        <input type="email" name="email" id="email" class="form-control form-control-alternative" value="${customer.email}" readonly>
                      </div>
                    </div>
                      <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="password">Password</label>
                        <input type="password" name="password" id="password" class="form-control form-control-alternative" value="${customer.password}">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="fname">First name</label>
                        <input type="text" name="fname" id="fname" class="form-control form-control-alternative" value="${customer.customerFname}">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="lname">Last name</label>
                        <input type="text" name="lname" id="lname" class="form-control form-control-alternative" value="${customer.customerLname}">
                      </div>
                    </div>
                  </div>
                      <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="gender">Gender</label>
                        <input type="text" name="gender" id="gender" class="form-control form-control-alternative" value="${customer.gender}">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="dob">Date of Birth</label>
                        <input type="date" name="dob" id="dob" class="form-control form-control-alternative" value="${customer.dob}">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" for="roles">Role</label>
                        <input type="text" name="roles" id="roles" class="form-control form-control-alternative" value="${customer.roles}">
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
                        <input type="number" name="address_streetNo" id="address_streetNo" class="form-control form-control-alternative" value="${customer.customerStreetno}">
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="form-group focused">
                        <label class="form-control-label" for="address_streetName">Street Name</label>
                        <input type="text" name="address_streetName" id="address_streetName" class="form-control form-control-alternative" value="${customer.customerStreetname}">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-4">
                      <div class="form-group focused">
                        <label class="form-control-label" for="address_city">City</label>
                        <input type="text" name="address_city" id="addressCity" class="form-control form-control-alternative" value="${customer.customerCity}">
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="form-group focused">
                        <label class="form-control-label" for="address_country">Country</label>
                        <input type="text" name="address_country" id="address_country" class="form-control form-control-alternative" placeholder="Country" value="${customer.customerCountry}">
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="form-group">
                        <label class="form-control-label" for="address_zipcode">Postal code</label>
                        <input type="number" name="address_zipcode" id="address_zipcode" class="form-control form-control-alternative" value="${customer.customerZipcode}">
                      </div>
                    </div>
                      <div class="col-lg-4">
                      <div class="form-group focused">
                        <label class="form-control-label" for="type">Type</label>
                        <input type="text" name="type" id="type" class="form-control form-control-alternative" placeholder="Type" value="${customer.Type}">
                      </div>
                    </div>
                  </div>
                </div>
                <hr class="my-4">
                <input class="btn btn-primary" type="submit"  value="Update">
              </form>
            </div>
          </div>
        </div>
       </div>
    </body>
</html>
