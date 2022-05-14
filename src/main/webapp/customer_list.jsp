<%@ page import="java.util.List" %>
<%@ page import="au.edu.uts.project.domain.Account" %>
<%-- 
    Document   : Customer-list
    Created on : 2022年5月14日, 下午7:43:35
    Author     : 11493
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getAttribute("list") == null){
        response.sendRedirect("/CustomerServlet?list=true");
    }
%>
<html>
<head>
    <title>Customer List information</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets/css/select.css">
    <link rel="stylesheet" href="./assets/css/style.css">
    <link rel="stylesheet" href="./assets/css/staff_page.css">
</head
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <h1>Customer list:</h1>
            </div>
        </div>
        <div class="col-6">
            <a href="mainStaff.jsp">
                <button type="button" class="btn btn-primary">Return</button>
            </a>
        </div>
        <div class="row justify-content-center" style="margin-bottom: 20px;">
            <div class="col-10 text-center">
                <form action="${pageContext.request.contextPath}/CustomerServlet">
                    <label for="name-filter">Filter name:</label>
                    <input type="text" id="name-filter" name="namef">
                    <label for="email-filter">Filter email:</label>
                    <input type="text" id="email-filter" name="emailf">
                    <button type="submit" class="btn btn-primary btn-sm" id="filter">Confirm Filter</button>
                </form>
                <button id="add" class="btn btn-secondary">Add Customer</button>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-10 customer-list">
                <div class="container">
                    <div class="row customer-list-element-title">
                        <div class="col-3">
                            <span class="customer-list-element-cell">Email</span>
                        </div>
                        <div class="col-3">
                            <span class="customer-list-element-cell">Name</span>
                        </div>
                        <div class="col-3">
                            <span class="customer-list-element-cell">Password</span>
                        </div>
                        <div class="col-3">
                            <span class="customer-list-element-cell">Status</span>
                        </div>
                    </div>
                    <%
                        List<Account> list = (List<Account>)request.getAttribute("list");
                        for(Account customer : list){
                    %>
                    <div class="row customer-list-element" value="<% out.print(customer.getEmail()); %>">
                        <div class="col-3">
                            <span class="customer-list-element-cell"> <% out.print(customer.getEmail()); %> </span>
                        </div>
                        <div class="col-3">
                            <span class="customer-list-element-cell"> <% out.print(customer.getFname()+ " " + customer.getLname()); %> </span>
                        </div>
                        <div class="col-3">
                            <span class="customer-list-element-cell"> <% out.print(customer.getPassword()); %> </span>
                        </div>
                        <div class="col-3">
                            <span class="customer-list-element-cell"> <% out.print(customer.isStatus()); %> </span>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $('.customer-list-element').click(function handleClick(event) {
            var email = $(this).attr('value');
            window.location.href = '${pageContext.request.contextPath}/CustomerServlet?email=' + email
        })
        $('#add').click(function () {
            window.location.href = '${pageContext.request.contextPath}/CustomerServlet?create=true'
        })
    </script>
</body>
</html>
