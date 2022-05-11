<%@ page import="au.edu.uts.project.domain.Customer" %><%--
    Document   : Customer-data
    Created on : 2022年5月11日, 下午12:24:56
    Author     : 11493
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Staff information</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets/css/select.css">
    <link rel="stylesheet" href="./assets/css/style.css">
    <link rel="stylesheet" href="./assets/css/staff_page.css">
</head>
    <body>
    <%
        Customer selected = (Customer)request.getAttribute("selected");
    %>
    <div>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-6" style="text-align: center">
                    <h2>Infomation of <% out.print(selected.getCustomerFname() + " " + selected.getCustomerLname()); %></h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="form" class="text-center login-register-main">
                        <span id="back-button"> &lsaquo;Back</span>
                        <form action="${pageContext.request.contextPath}/CustomerServlet" method="post">
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="customer_fname">First Name</label>
                                    <input name="customer_fname" type="text" id="customer_fname" value="<% out.print(selected.getCustomerFname()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="customer_lname">Last Name</label>
                                    <input name="customer_lname" type="text" id="customer_lname" value="<% out.print(selected.getCustomerLname()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="email">Email Address</label>
                                    <input name="email" type="text" id="email" value="<% out.print(selected.getEmail()); %>" readonly>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input name="password" type="text" id="password" value="<% out.print(selected.getPassword()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="dob">Date of Birth</label>
                                    <input name="dob" type="date" id="dob" value="<% out.print(selected.getDob()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="gender">Gender</label>
                                    <select name="gender" id="gender" class="form-select">
                                        <option value="Male" <% if("Male".equals(selected.getGender())) out.print("selected"); %> >Male</option>
                                        <option value="Female" <% if("Female".equals(selected.getGender())) out.print("selected"); %> >Female</option>
                                        <option value="Other"<% if("Other".equals(selected.getGender())) out.print("selected"); %> >Other</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="customer_streetno">Street Number</label>
                                    <input name="customer_streetno" type="text" id="customer_streetno" value="<% out.print(selected.getCustomerStreetno()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="customer_streetname">Street Name</label>
                                    <input name="customer_streetname" type="text" id="customer_streetname" value="<% out.print(selected.getCustomerStreetname()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="customer_city">City</label>
                                    <input name="customer_city" type="text" id="customer_city" value="<% out.print(selected.getCustomerCity()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="customer_zipcode">Zipcode</label>
                                    <input name="customer_zipcode" type="text" id="customer_zipcode" value="<% out.print(selected.getCustomerZipcode()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="customer_country">Country</label>
                                    <input name="customer_country" type="text" id="customer_country" value="<% out.print(selected.getCustomerCountry()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="type">Type</label>
                                    <input name="type" type="text" id="type" value="<% out.print(selected.getType()); %>">
                                </div>
                            </div>
                            <button type="submit" class="confirm-button">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./assets/js/submission.js"></script>
    <script type="text/javascript" src="./assets/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="./assets/js/validation.js"></script>
    <script type="text/javascript" src="./assets/js/jquery.nice-select.min.js"></script>
    <script type="text/javascript" src="./assets/js/main.js"></script>
    <script type="text/javascript">
        $('#back-button').click(function (){
            window.location.href = '${pageContext.request.contextPath}/StaffServlet?list=true';
        };
    </script>
</body>
</html>
