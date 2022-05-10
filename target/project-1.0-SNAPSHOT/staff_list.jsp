<%@ page import="java.util.List" %>
<%@ page import="au.edu.uts.project.domain.Staff" %><%--
  Created by IntelliJ IDEA.
  User: FurryDesktop
  Date: 5/4/2022
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getAttribute("list") == null){
        response.sendRedirect("/StaffServlet?list=true");
    }
%>
<html>
<head>
    <title>Staff List information</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets/css/select.css">
    <link rel="stylesheet" href="./assets/css/style.css">
    <link rel="stylesheet" href="./assets/css/staff_page.css">
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <h1>Staff list:</h1>
            </div>
        </div>
        <div class="row justify-content-center" style="margin-bottom: 20px;">
            <div class="col-10 text-center">
                <form action="${pageContext.request.contextPath}/StaffServlet">
                    <label for="name-filter">Filter name:</label>
                    <input type="text" id="name-filter" name="namef">
                    <label for="email-filter">Filter email:</label>
                    <input type="text" id="email-filter" name="emailf">
                    <button type="submit" class="staff-button" id="filter">Confirm Filter</button>
                </form>
                <button id="add" class="staff-button">Add Staff</button>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-10 staff-list">
                <div class="container">
                    <div class="row staff-list-element-title">
                        <div class="col-3">
                            <span class="staff-list-element-cell">Email</span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell">Name</span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell">Roles</span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell">Status</span>
                        </div>
                    </div>
                    <%
                        List<Staff> list = (List<Staff>)request.getAttribute("list");
                        for(Staff staff : list){
                    %>
                    <div class="row staff-list-element" value="<% out.print(staff.getEmail()); %>">
                        <div class="col-3">
                            <span class="staff-list-element-cell"> <% out.print(staff.getEmail()); %> </span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell"> <% out.print(staff.getStaffFname() + " " + staff.getStaffLname()); %> </span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell"> <% out.print(staff.getRoles()); %> </span>
                        </div>
                        <div class="col-3">
                            <span class="staff-list-element-cell"> <% out.print(staff.isStatus()); %> </span>
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
            var email = $(this).attr('value');
            window.location.href = '${pageContext.request.contextPath}/StaffServlet?email=' + email
        })
        $('#add').click(function () {
            window.location.href = '${pageContext.request.contextPath}/StaffServlet?create=true'
        })
    </script>
</body>
</html>