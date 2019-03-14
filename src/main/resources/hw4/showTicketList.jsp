<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
    body {
        text-align: center;
    }

    table {
        font-size: 1.5em;
        margin: 0 auto;
    }

    table tr td {
        text-align: center;
        width: 200px;
    }
</style>
<body>
<h1>所有机票预订信息</h1>
<table border="1" cellspacing="1" cellpadding="0" bgcolor="aqua">
    <tr>
        <th>姓名</th>
        <th>性别</th>
        <th>始发城市</th>
        <th>目的城市</th>
        <th>出发日期</th>
        <th>身份证</th>
    </tr>
    <c:forEach items="${requestScope.ticketList}" var="ticket">
        <tr>
            <td>${ticket.name}</td>
            <td>${ticket.sex}</td>
            <td>${ticket.originating}</td>
            <td>${ticket.destination}</td>
            <td>${ticket.date}</td>
            <td>${ticket.idCardNo}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>