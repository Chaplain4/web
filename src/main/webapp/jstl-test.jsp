<%--
  Created by IntelliJ IDEA.
  User: st
  Date: 04.12.2023
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL TEST</title>
</head>
<body>
<c:forEach var="n" begin="1" end="10">
    Number #<c:out value="${n}"></c:out> <br>
</c:forEach>
</body>
</html>
