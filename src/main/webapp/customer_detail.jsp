<%@ page import="au.edu.uts.project.domain.Account" %><%--
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
        Account selected = (Account)request.getAttribute("selected");
    %>
    <div>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-6" style="text-align: center">
                    <h2>Information of <% out.print(selected.getFname() + " " + selected.getLname()); %></h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="form" class="text-center login-register-main">
                        <span id="back-button"> &lsaquo;Back</span>
                        <form action="${pageContext.request.contextPath}/CustomerServlet" method="post">
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="cust_fname">First Name</label>
                                    <input name="cust_fname" type="text" id="cust_fname" value="<% out.print(selected.getFname()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="cust_lname">Last Name</label>
                                    <input name="cust_lname" type="text" id="cust_lname" value="<% out.print(selected.getLname()); %>">
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
                                    <label for="cust_streetno">Street Number</label>
                                    <input name="cust_streetno" type="text" id="cust_streetno" value="<% out.print(selected.getAddressStreetNo()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="cust_streetname">Street Name</label>
                                    <input name="cust_streetname" type="text" id="cust_streetname" value="<% out.print(selected.getAddressStreetName()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="cust_city">City</label>
                                    <input name="cust_city" type="text" id="cust_city" value="<% out.print(selected.getAddressCity()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="cust_zipcode">Zipcode</label>
                                    <input name="cust_zipcode" type="text" id="cust_zipcode" value="<% out.print(selected.getAddressZipcode()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="cust_country">Country</label>
                                    <input name="cust_country" type="text" id="cust_country" value="<% out.print(selected.getAddressCountry()); %>">
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
            window.location.href = '${pageContext.request.contextPath}/CustomerServlet?list=true';
        };
    </script>
</body>
</html>