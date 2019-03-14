<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
    body {
        background: url(../img/timg.jpg) no-repeat center center;
        background-size: cover;
        text-align: center;
    }

    table {
        margin: 0 auto;
    }
</style>
<body>
<h1>在线机票预订</h1>
<form action="${pageContext.request.contextPath}/hw4${requestScope.url}" method="post">
    <table>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name" title="name"></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <label><input type="radio" name="sex" value="man">男</label>
                <label><input type="radio" name="sex" value="woman">女</label>
            </td>
        </tr>
        <tr>
            <td>始发城市：</td>
            <td><input type="text" name="originating" title="originating"></td>
        </tr>
        <tr>
            <td>目的城市：</td>
            <td><input type="text" name="destination" title="destination"></td>
        </tr>
        <tr>
            <td>出发日期：</td>
            <td><input type="datetime-local" name="date" title="date"></td>
        </tr>
        <tr>
            <td>身份证：</td>
            <td><input type="text" name="idCardNo" title="idCardNo"></td>
        </tr>
        <tr>
            <td><input type="submit" value="预订"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>

</body>
</html>