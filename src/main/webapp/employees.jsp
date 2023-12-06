<%@ page import="main.org.example.model.Employee" %>
<%@ page import="java.util.Set" %>
<%@ page import="main.org.example.util.ServletUtils" %>
<%@ page import="main.org.example.util.SecUtils" %>
<%@ page import="main.org.example.model.User" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: sharlan_a
  Date: 20.11.2023
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="sutils" uri=""%>
<jsp:useBean id="sutils" class="main.org.example.util.SecUtils">
</jsp:useBean>

<html>
<head>
    <title>Employees</title>
    <link rel="stylesheet" href="css/table_style.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<c:if test="${empls.isEmpty()}">
    <h1>No Employees found!</h1>
</c:if>
<c:if test="${ not empls.isEmpty()}">
    <table class="table_dark">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>LAST NAME</th>
            <th>AGE</th>
            <th>OFFICE</th>
            <th>PASSPORT</th>
            <th>UPDATED</th>
            <th>CREATED</th>
            <c:if test="${sutils.hasRole(request, 'Admin', 'Manager')}">
                <th>Update</th>
            </c:if>
            <c:if test="${sutils.hasRole(request, 'Admin')}">
                <th>Delete</th>
            </c:if>
        </tr>
        <c:forEach items="${empls}" var="empl">
            <tr>
                <td>${empl.id}</td>
                <td>${empl.name}</td>
                <td>${empl.lastName}</td>
                <td>${empl.age}</td>
                <td>${empl.office.title}</td>
                <td>${empl.passport.indID}</td>
                <td>${empl.updatedTs}</td>
                <td>${empl.createdTs}</td>
                <c:if test="${sutils.hasRole(request, 'Admin', 'Manager')}">
                <td><a href="employees?action=U&id=${empl.id}"> UPDATE </a></td>
                </c:if>
                <c:if test="${sutils.hasRole(request, 'Admin')}">
                <td><a href= "employees?action=D&id=${empl.id}"> DELETE </a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>

<c:if test="${SecUtils.hasRole(request, 'Admin')}">
<br><a href="employees?action=C"> CREATE </a>
</c:if>

</c:if>
</body>
</html>