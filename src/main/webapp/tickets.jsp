<%@ page import="main.org.example.model.Employee" %>
<%@ page import="java.util.Set" %>
<%@ page import="main.org.example.util.ServletUtils" %>
<%@ page import="main.org.example.util.SecUtils" %>
<%@ page import="main.org.example.model.User" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sutils" uri=""%>--%>
<jsp:useBean id="sutils" class="main.org.example.util.SecUtils">
</jsp:useBean>

<html>
<head>
    <title>Tickets</title>
    <link rel="stylesheet" href="css/table_style.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<c:if test="${tasks.isEmpty()}">
    <h1>No Tickets found!</h1>
</c:if>
<c:if test="${ not tasks.isEmpty()}">
    <table class="table_dark">
        <tr>
            <th>ID</th>
            <th>DEADLINE</th>
            <th>DESCRIPTION</th>
            <th>PRIORITY</th>
            <th>STATUS</th>
            <th>USERS ASSIGNED</th>
            <%
                String admin = "Admin";
                String manager = "Manager";
            %>
            <th>Update</th>
            <c:if test="<%=SecUtils.hasRole(request, admin, manager)%>">
                <th>Delete</th>
                <th>Assign User</th>
            </c:if>
        </tr>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.id}</td>
                <td>${task.deadline}</td>
                <td>${task.descr}</td>
                <td>${task.priority}</td>
                <td>${task.status}</td>
                <td><c:forEach items="${task.users}" var="user">
                    ${user.name}
                </c:forEach>
                </td>
                <td><a href="tickets?action=U&id=${task.id}"> UPDATE </a></td>
                <c:if test="<%=SecUtils.hasRole(request, admin, manager)%>">
                    <td><a href="tickets?action=D&id=${task.id}"> DELETE </a></td>
                    <td><a href="tickets?action=A&id=${task.id}"> ASSIGN USER </a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>

    <c:if test="<%=SecUtils.hasRole(request, admin, manager)%>">
        <br><a href="tickets?action=C"> CREATE </a>
    </c:if>

</c:if>

</body>
</html>