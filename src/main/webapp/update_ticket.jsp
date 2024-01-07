<%@ page import="main.org.example.model.Office" %>
<%@ page import="java.util.Set" %>
<%@ page import="main.org.example.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="main.org.example.model.Task" %>
<%@ page import="main.org.example.util.SecUtils" %><%--
  Created by IntelliJ IDEA.
  Date: 22.11.2023
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="sutils" class="main.org.example.util.SecUtils">
</jsp:useBean>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <!-- <link rel="stylesheet" href="css/Style.css"> -->
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<% Task task = (Task) request.getAttribute("ticket");
    String admin = "Admin";
    String manager = "Manager";
%>


<form action="update_ticket" method="post">
    <!-- Submit will call doPost() method. All parameters will be in request body!  -->
    <% if (SecUtils.hasRole(request, admin, manager)) { %>
    <c:if test="<%=SecUtils.hasRole(request, admin, manager)%>">
        <div class="group">
            <label>Description</label>
            <input type="text" name="descr" value="<%=task.getDescr()%>"><span class="highlight"></span><span
                class="bar"></span>
        </div>
        <div class="group">
            <label>Priority</label>
            <select id="priority" name="priority">
                <option value="Critical"  <% if (task.getPriority().equals("Critical")) {%> selected<%}%>>Critical
                </option>
                <option value="High" <% if (task.getPriority().equals("High")) {%> selected<%}%>>High</option>
                <option value="Medium" <% if (task.getPriority().equals("Medium")) {%> selected<%}%>>Medium</option>
                <option value="Low" <% if (task.getPriority().equals("Low")) {%> selected<%}%>>Low</option>
            </select>
        </div>
        <div class="group">
            <input type="date" name="deadline" value="<%=task.getDeadline()%>"><span class="highlight"></span><span
                class="bar"></span>
            <label>Deadline</label>
        </div>
    </c:if>
    <% } else { %>
    <div class="group">
        <input type="hidden" name="descr" value="<%=task.getDescr()%>"><span class="highlight"></span><span
            class="bar"></span>
    </div>
    <div class="group">
        <input type="hidden" name="priority" value="<%=task.getPriority()%>"><span class="highlight"></span><span
            class="bar"></span>
        </select>
    </div>
    <div class="group">
        <input type="hidden" name="deadline" value="<%=task.getDeadline()%>"><span class="highlight"></span><span
            class="bar"></span>
    </div>
    <% } %>
    <div class="group">
        <label>Status</label>
        <select id="status" name="status">
            <option value="New" <% if (task.getStatus().equals("New")) {%> selected<%}%>>New</option>
            <option value="Open" <% if (task.getStatus().equals("Open")) {%> selected<%}%>>Open</option>
            <option value="In Progress" <% if (task.getStatus().equals("In Progress")) {%> selected<%}%>>In Progress
            </option>
            <option value="Completed"<% if (task.getStatus().equals("Completed")) {%> selected<%}%>>Completed</option>
        </select>
    </div>
    <input type="hidden" name="id" value="<%=task.getId()%>"/>
    <button type="submit" class="button buttonBlue">Update
        <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
    </button>
</form>
<footer><!-- <a href="http://www.polymer-project.org/" target="_blank"><img
        src="https://www.polymer-project.org/images/logos/p-logo.svg"></a>
    <p>You Gotta Love <a href="http://www.polymer-project.org/" target="_blank">Google</a></p>-->
</footer>
<script src="js/login.js"></script>

</body>
</html>
