<%@ page import="java.util.List" %>
<%@ page import="au.edu.uts.project.domain.Staff" %>
<%@ page import="au.edu.uts.project.domain.Order" %><%--
  Created by IntelliJ IDEA.
  User: FurryDesktop
  Date: 5/4/2022
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Order Information</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets/css/select.css">
    <link rel="stylesheet" href="./assets/css/style.css">
    <link rel="stylesheet" href="./assets/css/staff_page.css">
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <h1>ORDER</h1>
            </div>
        </div>
        <div class="row justify-content-center" style="margin-bottom: 20px;">
            <div class="col-10 text-center">
                <form action="${pageContext.request.contextPath}/OrderServlet">
                    <label for="id-filter">Filter id:</label>
                    <input type="text" id="id-filter" name="fid">
                    <label for="date-filter">Filter date:</label>
                    <input type="text" id="date-filter" name="fdate">
                    <button type="submit" class="staff-button" id="filter">Confirm Filter</button>
                </form>
                <button id="add" class="staff-button">New Order</button>
            </div>
        </div>
        <span><%
            if(request.getAttribute("msg") != null){
                out.print(request.getAttribute("msg"));
            }
        %></span>
        <div class="row justify-content-center">
            <div class="col-10 staff-list">
                <div class="container">
                    <div class="row staff-list-element-title">
                        <div class="col-3">
                            <span class="staff-list-element-cell">Order Id</span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell">Status</span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell">Delivery Date</span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell">Delivery Time</span>
                        </div>
                    </div>
                    <%
                        List<Order> list = (List<Order>)request.getAttribute("order_list");
                        for(Order order : list){
                    %>
                    <div class="row staff-list-element" value="<% out.print(order.getOrderId()); %>">
                        <div class="col-3">
                            <span class="staff-list-element-cell"> <% out.print(order.getOrderId()); %> </span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell"> <% out.print(order.getStatus()); %> </span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell"> <% out.print(order.getDeliveryDate()); %> </span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell"> <% out.print(order.getDeliveryTime()); %> </span>
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
        $('.staff-list-element').click(function handleClick(event) {
            var id = $(this).attr('value');
            window.location.href = '${pageContext.request.contextPath}/OrderLineServlet?display=' + id
        })
        $('#add').click(function () {
            window.location.href = '${pageContext.request.contextPath}/OrderServlet' + '?create=<% out.print(request.getAttribute("order_active_email")); %>'
        })
    </script>
</body>
</html>