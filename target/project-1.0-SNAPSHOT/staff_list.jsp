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
    <%
        List<Staff> list = (List<Staff>)session.getAttribute("staff_list");
        for(Staff staff : list){
    %>
    <span> <% out.print(staff.getEmail()); %> </span> <span> <% out.print(staff.getRoles()); %> </span>
    <%
        }
    %>
</body>
</html>
