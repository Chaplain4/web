<%@ page import="main.org.example.model.Office" %>
<%@ page import="java.util.Set" %>
<%@ page import="main.org.example.model.Employee" %><%--
  Created by IntelliJ IDEA.
  Date: 22.11.2023
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <!-- <link rel="stylesheet" href="css/Style.css"> -->
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<% Employee employee = (Employee) request.getAttribute("empl");%>
<form action="update" method="post">
    <!-- Submit will call doPost() method. All parameters will be in request body!  -->
    <div class="group">
        <label>Name</label>
        <input type="text" name="name" value="<%=employee.getName()%>"><span class="highlight"></span><span class="bar"></span>
    </div>
    <div class="group">
        <input type="text" name="last_name" value="<%=employee.getLastName()%>"><span class="highlight"></span><span class="bar"></span>
        <label>Last Name</label>
    </div>

    <div class="group">
        <input type="number" name="age" value="<%=employee.getAge()%>">
        <span class="highlight"></span><span class="bar"></span>
        <label>Age</label>
    </div>

    <div class="group">
        <select name="office">
            <% for (Office office : (Set<Office>) request.getAttribute("offices")) {
                if (office.equals(employee.getOffice())) {%>
            <option value='<%=office.getId()%>' selected><%=office.getId() + " - " + office.getTitle()%>
                    <%} else {%>
            <option value='<%=office.getId()%>'><%=office.getId() + " - " + office.getTitle()%>
            </option>
            <%
                    }
                }
            %>
        </select>
        <label>Office</label>
    </div>
    <br>
    <!-- Passport form -->
    <div class="group">
        <input type="text" name="personal_id" value="<%=employee.getPassport().getPersonalID()%>"><span
            class="highlight"></span><span class="bar"></span>
        <label>Personal ID</label>
    </div>
    <div class="group">
        <input type="text" name="ind_id" value="<%=employee.getPassport().getIndID()%>"><span
            class="highlight"></span><span class="bar"></span>
        <label>Individual ID</label>
    </div>
    <div class="group">
        <input type="date" name="exp_date" value="<%=employee.getPassport().getExpTS()%>"><span
            class="highlight"></span><span class="bar"></span>
        <label>Exp Date</label>
    </div>
    <input type="hidden" name="id" value="<%=employee.getId()%>" />
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
