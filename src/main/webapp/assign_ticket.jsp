<%@ page import="main.org.example.model.Office" %>
<%@ page import="java.util.Set" %>
<%@ page import="main.org.example.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="main.org.example.model.Task" %>
<%@ page import="main.org.example.util.SecUtils" %>
<%@ page import="main.org.example.model.User" %><%--
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
    List<User> users = (List<User>) request.getAttribute("users");
%>


<form action="assign_ticket" method="post">
    <!-- Submit will call doPost() method. All parameters will be in request body!  -->
    <% if (SecUtils.hasRole(request, admin, manager)) { %>
    <c:if test="<%=SecUtils.hasRole(request, admin, manager)%>">


        <div class="group">
            <label>User</label>
            <select name="user_id">
                <%
                    for (User user : users) {
                    if (task.getUsers().contains(user)) {%>
                <option value='<%=user.getId()%>' selected><%=user.getId() + " - " + user.getName()%>
                            <%} else {%>
                <option value='<%=user.getId()%>'><%=user.getId() + " - " + user.getName()%>
                </option>
                <%
                        }
                    }
                %>
            </select>
        </div>


    </c:if>
    <% } %>
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
