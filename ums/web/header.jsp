<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/5/20
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
    <style>
        #headerh1{
            margin: 0px;
            text-align: center;
        }
        div{
            width: 100%;
            height: 30px;
            border-bottom: 3px solid darkgrey;
            text-align: center;
        }
        ul{
            list-style-type: none;

        }
        li{
            font-size: 15px;
            display: inline-block;
            width: 40px;
        }
    </style>
</head>
<body>
    <h2 id="headerh1">用户管理系统</h2>
    <div>
        <ul>
            <li><a href="<c:url value="/login.jsp"></c:url> ">Login</a></li>
            <li><a href="<c:url value="/register.jsp"></c:url> ">register</a></li>
            <li>3</li>
            <li>4</li>
        </ul>
    </div>
</body>
</html>
