<%@ page import="java.util.Objects" %>
<%@ page import="java.util.regex.Pattern" %><%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/3/3
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="top.yzlin.homework.entity.User"/>
<jsp:setProperty name="user" property="name"/>
<jsp:setProperty name="user" property="age"/>
<jsp:setProperty name="user" property="mail"/>
<jsp:setProperty name="user" property="password"/>
<%!private static final Pattern PATTERN=Pattern.compile("\\d+");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    StringBuilder sb=new StringBuilder();
    if(Objects.isNull(user.getName()) || "".equals(user.getName())){
        sb.append("系统登录错误：没有输入用户名<br>");
    }
    if(Objects.isNull(user.getAge())){
        sb.append("系统登录错误：没有输入年龄<br>");
    }else if(!PATTERN.matcher(user.getAge()).matches()){
        sb.append("系统登录错误：年龄要为数字整数<br>");
    }
    if(Objects.isNull(user.getPassword()) || "".equals(user.getPassword())){
        sb.append("系统登录错误：没有输入密码<br>");
    }
    if(Objects.isNull(user.getMail()) || "".equals(user.getMail())){
        sb.append("系统登录错误：没有输入邮箱<br>");
    }else if(!user.getMail().contains("@")){
        sb.append("系统登录错误：邮箱格式错误<br>");
    }
%>
<%if(sb.length()==0){%>
<%session.setAttribute("user",user);%>
<img src="../img/lvye.jpg" alt="Boom">
<h2>欢迎你${user.name}会员注册成功！！！3秒后跳转到登录界面</h2>
<script>
    setTimeout(function (args) {
        window.location = "index.jsp";
    }, 3000);
</script>
<%}else{%>
<p><%= sb.toString()%></p>
<%}%>
</body>
</html>