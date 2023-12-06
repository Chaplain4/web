<%--
  Created by IntelliJ IDEA.
  User: st
  Date: 06.12.2023
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Game</title>
    <link rel="stylesheet" href=css/Style.css>
</head>


<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Number #${result}<h1/> <br>
<form action="game" method="get">
    <button type="submit" class="button buttonBlue">PLAY AGAIN
        <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
    </button>
</form>
</body>
</html>
