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
                    <h2>Add New Order</h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="form" class="text-center login-register-main">
                        <span id="back-button"> &lsaquo;Not, that is not me</span>
                        <form action="${pageContext.request.contextPath}/OrderServlet" method="post">
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="email">Customer Email</label>
                                    <input name="email" type="text" id="email" value="<% out.print(session.getAttribute("email")); %>" readonly>
                                </div>
                            </div>
                            <div style="display: none">
                                <%
                                    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                                    SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
                                    Date now = new Date(System.currentTimeMillis());
                                %>
                                <input name="status" value="Initializing">
                                <input name="date" value="<% out.print(date.format(now)); %>">
                                <input name="time" value="<% out.print(time.format(now)); %>">
                            </div>
                            <button type="submit" class="staff-button">Yes, that is me</button>
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
            window.location.href = '${pageContext.request.contextPath}/OrderServlet?display=<% out.print(session.getAttribute("email")); %>'
        })
    </script>
</body>
</html>
