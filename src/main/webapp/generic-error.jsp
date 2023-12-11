<%--
  Created by IntelliJ IDEA.
  User: st
  Date: 22.11.2023
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oooops</title>
 </head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1><%=request.getAttribute("error-msg")%></h1>
</body>
</html>
