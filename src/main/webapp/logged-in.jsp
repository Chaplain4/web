<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24.11.2023
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h5>Hi there, <%=request.getParameter("name") == null ? "Stranger" : request.getParameter("name")%>) + " this is Servlets response. <%=new Date()%></h5>
<a href="logout">logout</a>
</body>
</html>
