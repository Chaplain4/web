<%--
  Created by IntelliJ IDEA.
  User: st
  Date: 06.12.2023
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange Result</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>You get ${result}<h1/> <br>
    <form action="exchange" method="get">
        <button type="submit" class="button buttonBlue">TRY AGAIN?
            <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
        </button>
    </form>
</body>
</html>
