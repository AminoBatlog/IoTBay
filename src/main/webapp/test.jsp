<%--
  Created by IntelliJ IDEA.
  User: FurryDesktop
  Date: 5/15/2022
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    out.print(request.getAttribute("order_id"));
    out.print(request.getAttribute("price"));
  %>
</body>
</html>
