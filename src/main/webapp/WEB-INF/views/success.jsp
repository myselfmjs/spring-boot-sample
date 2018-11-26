<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2018/11/20
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    SUCCESS <br>
   <c:if test="${online ne null}">当前登录人数：${online}</c:if>
</body>
</html>
