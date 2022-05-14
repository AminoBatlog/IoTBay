<%-- 
    Document   : device
    Created on : May 11, 2022, 2:52:06 PM
    Author     : kevin
--%>

<%@page import="au.edu.uts.project.domain.IotDev"%>
<%@page import="java.util.List"%>
<%@page import="au.edu.uts.project.domain.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (request.getAttribute("list") == null) {
        response.sendRedirect("/IotDevServlet?list=1");
    }
%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Devices List Page</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets/css/select.css">
    <link rel="stylesheet" href="./assets/css/style.css">
    <link rel="stylesheet" href="./assets/css/staff_page.css">
</head>

<body>
    <div class="container">
        <div class="col-6">
            <a href="main.jsp">
                <button type="button" class="btn btn-primary">Return</button>
            </a>
        </div>

        <div class="row justify-content-center">
            <div class="col-6">
                <h1 class="text-center">Devices Catalogue</h1>
            </div>
        </div>

        <div class="row justify-content-center" style="margin-bottom: 40px;">
            <div class="col-10 text-center">
                <form action="${pageContext.request.contextPath}/IotDevServlet">
                    <label for="search-id">Search ID</label>
                    <input type="text" id="search-id" name="idfind">
                    <button type="submit" class="btn btn-success btn-sm" id="filter">Search</button>
                </form>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-10 devices-list">
                <div class="container">
                    <div class="row devices-list-element-title">
                        <div class="col-sm-3">
                            <span class="devices-list-element-cell">Devices ID</span>
                        </div>
                        <div class="col-sm-3">
                            <span class="devices-list-element-cell">Devices Name</span>
                        </div>
                        <div class="col-sm-3">
                            <span class="devices-list-element-cell">Devices Price</span>
                        </div>
                        <div class="col-sm-3">
                            <span class="devices-list-element-cell">Quantity</span>
                        </div>
                    </div>

                    <%
                        List<IotDev> list = (List<IotDev>) request.getAttribute("list");
                        for (IotDev iotDev : list) {
                    %>

                    <div class="row devices-list-element" value="<% out.print(iotDev.getDevID()); %>">
                        <div class="col-sm-3">
                            <span class="devices-list-element-cell"> <% out.print(iotDev.getDevID()); %> </span>
                        </div>
                        <div class="col-sm-3">
                            <span class="devices-list-element-cell"> <% out.print(iotDev.getDevName()); %> </span>
                        </div>
                        <div class="col-sm-3">
                            <span class="devices-list-element-cell"> <% out.print(iotDev.getDevPrice()); %> </span>
                        </div>
                        <div class="col-sm-3">
                            <span class="devices-list-element-cell"> <% out.print(iotDev.getQuantity()); %> </span>
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
    </script>

</body>





