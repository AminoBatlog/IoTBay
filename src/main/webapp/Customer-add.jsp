<%@ page import="au.edu.uts.project.domain.Customer" %><%--
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
                        <form action="${pageContext.request.contextPath}/StaffServlet" method="post">
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_fname">First Name</label>
                                    <input name="staff_fname" type="text" id="staff_fname" value="">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_lname">Last Name</label>
                                    <input name="staff_lname" type="text" id="staff_lname" value="">
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
                                    <label for="staff_streetno">Street Number</label>
                                    <input name="staff_streetno" type="text" id="staff_streetno" value="">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_streetname">Street Name</label>
                                    <input name="staff_streetname" type="text" id="staff_streetname" value="">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_city">City</label>
                                    <input name="staff_city" type="text" id="staff_city" value="">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_zipcode">Zipcode</label>
                                    <input name="staff_zipcode" type="text" id="staff_zipcode" value="">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_country">Country</label>
                                    <input name="staff_country" type="text" id="staff_country" value="">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="type">Type</label>
                                    <input name="type" type="text" id="type" value="">
                                </div>
                            </div>
                            <button type="submit" class="confirm-button">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
        
        
        
        
    </body>
</html>
