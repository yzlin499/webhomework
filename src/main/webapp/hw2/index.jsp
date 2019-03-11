<%@ page import="java.util.Optional" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/3/3
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实验1</title>
    <style>
        body{text-align:center}
    </style>
</head>
<body>
<%
    int count= Optional.ofNullable(application.getAttribute("count"))
            .map(o-> o instanceof Integer ? (Integer) o : Integer.valueOf(0))
            .orElse(0);
    application.setAttribute("count",++count);
%>
<p>你是第${count}位访客，访问时间为：<%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%></p>
<img src="../img/lvye.jpg" alt="崩了啊">
<h2>绿叶书店会员系统注册</h2>
<form action="doLogin.jsp" method="post">
    <label>用户名：<input type="text" name="name" value="${sessionScope.user.name}"></label><br><br>
    <label>密　码：<input type="password" name="password"></label><br><br>
    <input type="submit" value="注册"> <input type="reset" value="取消">
</form>
</body>
</html>
