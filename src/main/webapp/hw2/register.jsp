<%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/3/9
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            text-align: center;
        }
    </style>
</head>
<body>
<img src="../img/lvye.jpg" alt="崩了啊">
<h2>绿叶书店会员系统注册</h2>
<form action="LoginAction.jsp" method="post">
    <label>用户名：<input type="text" name="name"></label><br><br>
    <label>密　码：<input type="password" name="password"></label><br><br>
    <label>年　龄：<input type="number" name="age"></label><br><br>
    <label>电　邮：<input type="text" name="mail"></label><br><br>
    <input type="submit" value="注册"><input type="reset" value="取消">
</form>
</body>
</html>
