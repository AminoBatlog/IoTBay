<%@ page import="java.util.List" %>
<%@ page import="au.edu.uts.project.domain.Staff" %><%--
  Created by IntelliJ IDEA.
  User: FurryDesktop
  Date: 5/4/2022
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Staff List information</title>
</head>
<body>
    <script type="text/javascript">
        console.log(1)
    </script>
    <h1>Staff list:</h1>
    <button id="add">Add Staff</button>
    <%
        List<Staff> list = (List<Staff>)session.getAttribute("staff_list");
        for(Staff staff : list){
    %>
    <div class="staff-list-element" value="<% out.print(staff.getEmail()); %>">
        <span class=""> <% out.print(staff.getEmail()); %> </span>
        <span> <% out.print(staff.getStaffFname() + " " + staff.getStaffLname()); %> </span>
    </div>
    <%
        }
    %>

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