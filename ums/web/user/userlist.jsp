<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ums.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            text-align:center;
        }
        th{
            padding-left: 60px;
            padding-right: 60px;
        }
    </style>
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script>
        function del() {
            var form=document.getElementById("form1");
            var usernames=document.getElementsByName("userName");
            for (var i=0;i<usernames.length;i++){
                usernames[i].valueOf();
            }
            form.action="<%=request.getContextPath()%>/user/delusers";
        }
        function pageSizeReq() {
            //拿到控件
            var pageSize=document.getElementById("pagesize");
            //拿到选中的项的索引
            var index=pageSize.selectedIndex;
            //拿到值
            var val=pageSize.options[index].value;
            //
            var form=document.getElementById("form1");
            form.action="<%=request.getContextPath()%>/user/userlist?page=${page}&pagesize="+val;
            form.submit();
        }
    </script>
</head>
<jsp:include page="../header.jsp"></jsp:include>
<body>
<h2>信息查询</h2>
<p>${sessionScope.loginUser.userName} 登陆了</p>
<hr/>
<%
    List<User> users=(List)session.getAttribute("users");
    if (users==null){
%>
    <p>没有用户数据</p>
<%
    }else{
%>
<form action="" method="post" id="form1">
    <table border="1" cellspacing="0" cellpadding="5" align="center">
        <thead>
        <tr>
            <th>选择</th><th>序号</th><th>头像</th><th>姓名</th><th>出生日期</th><th>爱好</th>
        </tr>
        </thead>
        <tbody>
        <%--        <%--%>
        <%--            for (int i=0;i<users.size();i++){--%>
        <%--            User user=users.get(i);--%>

        <%--        %>--%>
        <%--        <tr align="center">--%>
        <%--            <td><%=i+1%></td>--%>
        <%--            <td><%=user.getUserName()%></td>--%>
        <%--            <td><%=user.getBirthday()%></td>--%>
        <%--            <td>--%>
        <%--                <%=user.getHobbies()%>--%>
        <%--                &lt;%&ndash;<%--%>

        <%--                %>&ndash;%&gt;--%>
        <%--            </td>--%>
        <c:forEach items="${sessionScope.users}" var="user" varStatus="i">
            <tr bgcolor="${i.count%2==0?'#fff':'#ccc'}">
                <td><input type="checkbox" name="userName" value="${user.userName}"></td>
                <td>${i.count}</td>
                <td><img src="<%=request.getContextPath()%>/user/images/${user.pic}" alt="" width="40px" height="40px"></td>
                <td>${user.userName}</td>
                <td>${user.birthday}</td>
                <td>
                    <c:forTokens items="${user.hobbies}" delims="," var="hobbie">
                        <c:if test="${hobbie=='s'}">游泳&nbsp;</c:if>
                        <c:if test="${hobbie=='r'}">阅读&nbsp;</c:if>
                        <c:if test="${hobbie=='m'}">音乐&nbsp;</c:if>
                        <c:if test="${hobbie=='g'}">游戏&nbsp;</c:if>
                    </c:forTokens>
                </td>
                
            </tr>
        </c:forEach>
        <%--无法直接在el标签中使用i作为索引取值，值为空--%>
        <%--            <td>${i+1}</td>--%>
        <%--            <td>${users[i].userName}</td>--%>
        <%--            <td>${users[i].birthday}</td>--%>
        <%--            <td>--%>
        <%--                ${users[i].hobbies}--%>
        <%--            </td>--%>
        <%--        </tr>--%>
        <%--        <%--%>
        <%--            }--%>
        <%--        %>--%>
        </tbody>
    </table>
    <input type="checkbox" name="selectAll">全选
    <input type="button" value="删除" onclick="del()">
    <input type="button" value="导出到excel">
    <br>
    <c:forEach begin="1" end="${sessionScope.pageaNum}" var="p">
        <c:if test="${page==p}">
            ${p}
        </c:if>
        <c:if test="${page!=p}">
            <%--不是当前页，发送请求带上page参数发送到servlet处理--%>
            <a href="<%=request.getContextPath()%>/user/userlist?page=${p}&pagesize=${pagesize}">${p}</a>
        </c:if>
    </c:forEach>
    <br>
    每页显示：<select name="pagesize" id="pagesize" onchange="pageSizeReq()">
    <option value="3">3</option>
    <option value="5">5</option>
    <option value="10">10</option>
    </select>条信息
</form>

<%
    }
%>
</body>
</html>
