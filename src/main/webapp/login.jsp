<%--
  Created by IntelliJ IDEA.
  User: FurryDesktop
  Date: 3/27/2022
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets/css/select.css">
    <link rel="stylesheet" href="./assets/css/style.css">
</head>
<body>
    <% 
      String existErr = (String) session.getAttribute("existErr");
      String emailErr = (String) session.getAttribute("emailErr");
      String passErr = (String) session.getAttribute("passErr");
    %>
    <div class="container">
        <div class="row justify-content-center text-center">
            <div class="col-5">
                <img src="./assets/pictures/uts.png" alt="Here is a logo" style="height: 40px">
            </div>
        </div>
        <div class="row d-flex justify-content-center pd-120">
            <div class="col-6">
                <div class="form" class="text-center login-register-main">
                    <h4>Login: <span class="message"><%=(existErr != null ? existErr : "")%></span></h4>
                    <form method="post" action="${pageContext.request.contextPath}/LoginServlet" id="form">
                        <div class="form-group">
                            <label for="email"> Email</label>
                            <input type="email" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" name="email" id="email">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" name="password" id="password">
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-primary btn-lg" onclick="submitForm()">Login</button>
                            <a href="index.jsp">
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
