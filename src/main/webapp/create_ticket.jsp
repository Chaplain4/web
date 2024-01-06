<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 06.01.2024
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Employee</title>
    <!-- <link rel="stylesheet" href="css/Style.css"> -->
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="tickets" method="post">
    <!-- Submit will call doPost() method. All parameters will be in request body!  -->
    <div class="group">
        <label>Description</label>
        <input type="text" name="descr"><span class="highlight"></span><span class="bar"></span>
    </div>
    <div class="group">
        <label>Priority</label>
        <select id="priority" name="priority">
            <option value="Critical">Critical</option>
            <option value="High">High</option>
            <option value="Medium">Medium</option>
            <option value="Low">Low</option>
        </select>
    </div>
    <div class="group">
        <label>Status</label>
        <select id="status" name="status">
            <option value="New">New</option>
            <option value="Open">Open</option>
            <option value="In Progress">In Progress</option>
            <option value="Completed">Completed</option>
        </select>
    </div>
    <div class="group">
        <input type="date" name="deadline"><span class="highlight"></span><span class="bar"></span>
        <label>Deadline</label>
    </div>
    <button type="submit" class="button buttonBlue">Create
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

