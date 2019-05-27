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
<br>${msg}
<br>${sessionScope.msg}
<br>${pageContext.session.id}
<br>${pageContext.request.contentLength}
<br>${pageContext.response.bufferSize}
<br>${pageContext.servletContext}
<br>${pageContext.out.remaining}
<br>${param}
<br>${param.pram1}
<br>${param.pram2}
<br>${paramValues}
<br>${cookie}
<br>${cookie.username.value}
<br>${cookie.username.name}
<br>${5/3}
<br>${5 eq 3?yes:no}
<br>${5 ne 3?yes:no}
</body>
</html>
