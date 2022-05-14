<%-- 
    Document   : updateDevice
    Created on : May 13, 2022, 10:31:55 AM
    Author     : kevin
--%>

<%@page import="java.util.List"%>
<%@page import="au.edu.uts.project.domain.IotDev"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" language="java">
        <title>Device Update Page</title>
        <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="./assets/css/select.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/staff_page.css">
    </head>
    <body>
        <div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-6" style="text-align: center">
                        <h2>Update Device</h2>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-6">
                        <div class="form" class="text-center login-register-main">
                            <button type="button" name="back" onclick="history.back()">back</button>
                            <form action="${pageContext.request.contextPath}/IotDevServlet" method="post">
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="devID" >Device ID</label>
                                        <input type="text" name="devID" id="devID" value="">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="deviceName">Device Name</label>
                                        <input name="deviceName" type="text" id="deviceName" value="">
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="devicePrice">Device Price</label>
                                        <input name="devicePrice" type="text" id="devicePrice" value="">
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group">
                                        <label for="deviceQuantity">Device Quantity</label>
                                        <input name="deviceQuantity" type="text" id="deviceQuantity" value="">
                                    </div>
                                </div>
                                <button type="submit" class="confirm-button" id="Update">Update Device</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>              

        <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
        <script type="text/javascript" src="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
        <script type="text/javascript">
        </script>


    </body>
</html>
