<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2017/9/25
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h1>欢迎登录!${user.username }</h1>
<form action="${pageContext.request.contextPath }/loginUser" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="checkbox" name="rememberMe">随便改改 测试GitKraken！123！3232323223！<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
