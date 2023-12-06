<%--
  Created by IntelliJ IDEA.
  User: st
  Date: 06.12.2023
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exchange</title>
    <link rel="stylesheet" href=css/Style.css>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<form action="exchange" method="post">
    <div class="group">
        <select name="currency">
            <option value="USD" selected>USD</option>
            <option value="EUR">EUR</option>
            <option value="RUB">RUB</option>
        </select>
    </div>
    <br>
    <div class="group">
        <select name="option">
            <option value="buy" selected>buy</option>
            <option value="sell">sell</option>
        </select>
    </div>
    <br>
    <div class="group">
        <input type="number" name="amount" required><span class="highlight"></span><span class="bar"></span>
        <label>Amount</label>
    </div>
    <br>
    <button type="submit" class="button buttonBlue">CALCULATE
        <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
    </button>
</form>
</body>
</html>
