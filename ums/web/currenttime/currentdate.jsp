<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/5/20
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%--指令 - 告诉引擎如何处理jsp页面其他的部分--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.Date" %>
<html>
<head>
    <title>当前时间</title>
</head>
<%--动态包含--%>
<jsp:include page="../header.jsp"></jsp:include>
<%--声明 - 翻译成成员属性，所有servlet共享一份--%>
<%!
    Date date2=new Date();
%>

<body>
    <h1>系统当前时间：</h1>
    <%--脚本 - 翻译成局部变量--%>
    <%
        //需要引入包--page中添加import
        Date date=new Date();
    %>
    <%--表达式 - 翻译成输出语句--%>
    <p>写于代码块中的date：<%=date%></p>
    <p>声明中的date：<%=date2%></p>
    <p>声明中的翻译之后是成员属性，只有一份，所以刷新不会改变</p>
</body>
</html>
