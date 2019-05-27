<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/5/21
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("msg","请求范围");
        session.setAttribute("msg","会话范围");
        Cookie c1=new Cookie("username","name");
        Cookie c2=new Cookie("userpass","pass");
        response.addCookie(c1);
        response.addCookie(c2);
    %>
    <jsp:forward page="elTest2.jsp?pram1=pro1&pram2=pro2"></jsp:forward>
</body>
</html>
