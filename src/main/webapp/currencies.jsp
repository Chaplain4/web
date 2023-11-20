<%@ page import="java.util.Date" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: st
  Date: 20.11.2023
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currencies</title>

</head>
<body>
<h2>Currencies Date: <%= getCurrentServerDate()%>
</h2>
<!--Declaration-->
<%!
    Date getCurrentServerDate() {
        return new Date();
    }
%>
<table border="1">
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Rate</th>
    </tr>
    <% Map<String, String> map = (Map<String, String>) request.getAttribute("map");
        int number = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
    %>
    <tr>
        <th>
            <%= ++number%>
        </th>
        <th>
            <%= entry.getKey()%>
        </th>
        <th>
            <%= entry.getValue()%>
        </th>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
