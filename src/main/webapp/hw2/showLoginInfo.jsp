<%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/3/4
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
你好！${sessionScope.user.name}，你的密码是：${sessionScope.user.password}
</body>
</html>
