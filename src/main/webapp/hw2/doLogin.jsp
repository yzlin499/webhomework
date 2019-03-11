<%@ page import="top.yzlin.homework.entity.User" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: yzlin
  Date: 2019/3/4
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="top.yzlin.homework.entity.User"/>
<jsp:setProperty name="user" property="name"/>
<jsp:setProperty name="user" property="password"/>
<%
User srcUser = (User) session.getAttribute("user");
if(Objects.equals(user.getName(),srcUser.getName())&& Objects.equals(user.getPassword(),srcUser.getPassword())){
    response.sendRedirect("/hw2/showLoginInfo.jsp");
}else{
    out.print("账号密码错误");
}

%>
