<%@ page import="java.util.List" %>
<%@ page import="au.edu.uts.project.domain.Staff" %>
<%@ page import="au.edu.uts.project.domain.Order" %>
<%@ page import="au.edu.uts.project.domain.OrderLine" %><%--
  Created by IntelliJ IDEA.
  User: FurryDesktop
  Date: 5/4/2022
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order details</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets/css/select.css">
    <link rel="stylesheet" href="./assets/css/style.css">
    <link rel="stylesheet" href="./assets/css/staff_page.css">
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <h1>Order Details of <% out.print(session.getAttribute("email")); %></h1>
            </div>
        </div>
        <div class="row justify-content-center" style="margin-bottom: 20px;">
            <div class="col-10 text-center">
                <button id="back" class="staff-button">Back</button>
                <button id="confirm" class="staff-button">Confirmed Order</button>
                <button id="cancel" class="staff-button">Cancel Order</button>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-10 staff-list">
                <div class="container">
                    <div class="row staff-list-element-title">
                        <div class="col-3">
                            <span class="staff-list-element-cell">Order Id</span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell">Device Id</span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell">Quantity</span>
                        </div>
                    </div>
                    <%
                        List<OrderLine> list = (List<OrderLine>)request.getAttribute("orderLine_list");
                        for(OrderLine order : list){
                    %>
                    <div class="row staff-list-element" value="<% out.print(order.getOrderId()); %>">
                        <div class="col-3">
                            <span class="staff-list-element-cell"> <% out.print(order.getOrderId()); %> </span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell"> <% out.print(order.getDevId()); %> </span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell"> <% out.print(order.getQuantity()); %> </span>
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
        $('#confirm').click(function (){
            window.location.href = '${pageContext.request.contextPath}/OrderServlet?status=' + 'Processing&orderId=' + '<% out.print(request.getAttribute("orderId")); %>'
        })
        $('#cancel').click(function (){
            window.location.href = '${pageContext.request.contextPath}/OrderServlet?status=' + 'Cancelled&orderId=' + '<% out.print(request.getAttribute("orderId")); %>'
        })
        $('#back').click(function (){
            window.location.href = '${pageContext.request.contextPath}/OrderServlet?display=' + '<% out.print(session.getAttribute("email")); %>'
        })
    </script>
</body>
</html>