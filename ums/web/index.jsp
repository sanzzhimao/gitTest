<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/5/16
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  <h1>Welcome!</h1>
  <c:if test="${5<3}" var="v" scope="request">
    <p>sjtl标签</p>
    ${v}
  </c:if>
  <c:out value="${v}"></c:out>
  <%--set标签，设置一个变量--%>
  <c:set var="salary" scope="session" value="2000"></c:set>
  <%--删除--%>
  <%--<c:remove var="salary" scope="session"></c:remove>--%>
  <c:choose>
    <c:when test="${salary>1000}">
      1000以上
    </c:when>
    <c:when test="${salary<=1000}">
      1000以下
    </c:when>
    <c:otherwise>
      其他
    </c:otherwise>
  </c:choose>
  <br>
  <% for ( int i = 0 ; i < 3 ; i ++){ %>
  out.print( i * 2);
  <% } %>
  forEach迭代
  <c:forEach begin="1" end="10" step="2">
    forEach
  </c:forEach>
  <% x=3; %>
  <% int x=5; %>
  <%! int x=7; %>
  x = <%=x%>, <%=this.x%>
  <%! int sum=1;%>
  <% int sum=8;%>
  <%out.println(sum++);%>


  <%--重定向--%>
  <%--<c:redirect url="login.html"></c:redirect>--%>
  </body>
</html>
