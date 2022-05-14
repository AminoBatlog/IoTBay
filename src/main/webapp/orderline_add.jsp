<%@ page import="au.edu.uts.project.domain.Staff" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: FurryDesktop
  Date: 5/9/2022
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Staff information</title>
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
                    <h2>Add Order Item for customer: <% out.print(session.getAttribute("email")); %></h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="form" class="text-center login-register-main">
                        <span style="color: yellow"><%
                            if(request.getAttribute("msg") != null)
                                out.print(request.getAttribute("msg"));
                        %></span>
                        <form id="form" action="${pageContext.request.contextPath}/OrderLineServlet" method="post">
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="orderid">Your Order Id</label>
                                    <input name="orderid" type="text" id="orderid" value="<% out.print(request.getAttribute("id")); %>" readonly>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="devid">Device id</label>
                                    <input name="devid" type="text" id="devid" value="">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="quantity">Quantity</label>
                                    <input name="quantity" type="text" id="quantity" value="">
                                </div>
                            </div>
                            <button type="button" class="staff-button" id="add">Add</button>
                            <button type="button" class="staff-button" id="back">Return to transaction</button>
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
        $('#add').click(function() {
            $('#form').submit()
        })
        $('#back').click(function() {
            window.location.href = '${pageContext.request.contextPath}/OrderLineServlet?display=' + '<% out.print(request.getAttribute("id")); %>'
        })
    </script>
</body>
</html>
