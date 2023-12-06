<%--
  Created by IntelliJ IDEA.
  User: st
  Date: 06.12.2023
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Game</title>
    <link rel="stylesheet" href=css/Style.css>
</head>


<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="game" method="post">
    <div class="group">
        <input type="number" name="numA" required><span class="highlight"></span><span class="bar"></span>
        <label>numA</label>
    </div>
    <div class="group">
        <input type="number" name="numB" required><span class="highlight"></span><span class="bar"></span>
        <label>numB</label>
    </div>
    <button type="submit" class="button buttonBlue">GENERATE
        <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
    </button>
</form>
</body>
</html>
