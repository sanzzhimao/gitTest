<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/5/20
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--静态包含 - 硬编码到文件，每次文件更改就需要重新翻译--%>
<%--<%@include file="header.jsp"%>--%>
<%--动态包含--%>

<html>
<head>
    <title>用户登录</title>
    <style>
        h1{
            margin-top: 50px;
        }
    </style>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
<h1>用户管理系统</h1>
<hr>
<form action="/ums/login" method="post">
    用户名：<input type="text" name="userName"/>
    密码:<input type="password" name="userPass"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
