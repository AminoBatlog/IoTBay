<%-- 
    Document   : staffRegister
    Created on : May 8, 2022, 9:55:51 PM
    Author     : weichen
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets/css/select.css">
    <link rel="stylesheet" href="./assets/css/style.css">
</head>
<body>
    <div class="container">
        <div class="row justify-content-center text-center">
            <div class="col-5">
                <img src="./assets/pictures/uts.png" alt="Here is a logo" style="height: 40px">
            </div>
        </div>
        <div class="row d-flex justify-content-center pd-120">
            <div class="col-6">
                <div class="form" class="text-center login-register-main">
                    <%
                        String existErr = (String) session.getAttribute("existErr");
                        String emailErr = (String) session.getAttribute("emailErr");
                        String passErr = (String) session.getAttribute("passErr");
                        String nameErr = (String) session.getAttribute("nameErr");
                    %>
                    <h4>Register: <span class="message"><%=(existErr != null ? existErr : "")%></span></h4>
                    <form method="post" action="RegisterServlet" id="form">
                        <div class="form-row">
                            <div class="form-group">
                                <label for="fname">First Name</label>
                                <input type="text" placeholder="<%=(nameErr != null ? nameErr : "Enter first name")%>" name="fname" id="fname">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="lname">Last Name</label>
                                <input type="text" placeholder="<%=(nameErr != null ? nameErr : "Enter last name")%>" name="lname" id="lname">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" name="email" id="email">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" name="password" id="password">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group">
                                <label>Gender</label>
                                <select name="gender" id="gender" class="form-select">
                                    <option value="0" selected disabled>---Choose your gender---</option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                    <option value="Other">Other</option>
                                </select>
                            </div>
                        </div><br><br>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="address_streetNo">Street Number</label>
                                <input type="number" name="address_streetNo" id="address_streetNo">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="address_streetName">Street Name</label>
                                <input type="text" name="address_streetName" id="address_streetName">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="address_zipcode">Zip code</label>
                                <input type="number" name="address_zipcode" id="address_zipcode">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="address_city">City</label>
                                <input type="text" name="address_city" id="address_city">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="address_country">Country</label>
                                <input type="text" name="address_country" id="address_country">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="roles">Roles</label>
                                <input type="text" name="roles" id="roles">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group">
                                <label for="dob">Date of Birth</label>
                                <input type="date" name="dob" id="dob">
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-primary btn-lg" onclick="submitForm()">Submit</button>
                            <a href="registerType.jsp">
                                <button type="button" class="btn btn-secondary btn-lg">Cancel</button>
                            </a>
                        </div>
                    </form>
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
</body>
</html>
