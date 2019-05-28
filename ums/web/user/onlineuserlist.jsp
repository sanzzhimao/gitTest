<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/5/27
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>在线用户</title>
</head>
<body>
    <h1>在线用户</h1>
    <hr>
    <c:forEach items="${applicationScope.infos}" var="info">
        ${info}<br>
    </c:forEach>
    <a href="userlist.jsp">返回</a>
</body>
</html>
