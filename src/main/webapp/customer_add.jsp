<%@ page import="au.edu.uts.project.domain.Account" %><%--
    Document   : Customer-add
    Created on : 2022年5月10日, 下午4:45:01
    Author     : 11493
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Customer Information</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/select.css">
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js">
    <link rel="stylesheet" href="./assets/css/style.css">
</head>
    <body>
        <div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-6" style="text-align: center">
                        <h2>Add new customer</h2>
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
                                        <input name="cust_fname" type="text" id="cust_fname" value="">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="cust_lname">Last Name</label>
                                        <input name="cust_lname" type="text" id="cust_lname" value="">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="email">Email Address</label>
                                        <input name="email" type="text" id="email" value="">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input name="password" type="text" id="password" value="">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="dob">Date of Birth</label>
                                        <input name="dob" type="date" id="dob" value="">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="gender">Gender</label>
                                        <select name="gender" id="gender" class="form-select">
                                            <option value="Male" >Male</option>
                                            <option value="Female" >Female</option>
                                            <option value="Other" >Other</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="cust_streetno">Street Number</label>
                                        <input name="cust_streetno" type="text" id="cust_streetno" value="">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="cust_streetname">Street Name</label>
                                        <input name="cust_streetname" type="text" id="cust_streetname" value="">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="cust_city">City</label>
                                        <input name="cust_city" type="text" id="cust_city" value="">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="cust_zipcode">Zipcode</label>
                                        <input name="cust_zipcode" type="text" id="cust_zipcode" value="">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="cust_country">Country</label>
                                        <input name="cust_country" type="text" id="cust_country" value="">
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
        <script type="text/javascript">
            $('#back-button').click(function (){
                window.location.href = '${pageContext.request.contextPath}/CustomerServlet?list=true'
            })
        </script>
    </body>
</html>