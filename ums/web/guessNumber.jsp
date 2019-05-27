<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/5/21
  Time: 11:32
  To change this template use File | Settings | File Templates.
  猜数游戏
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Random,java.math.*" %>
<%@ page import="com.sun.xml.internal.ws.api.ha.StickyFeature" %>
<%!
    //生成随机数
    private int newNum(){
        int num=new Random().nextInt(100);
        int answer=Math.abs(num%100)+1;
        System.out.println(answer);
        return answer;
    }

%>
<html>
<head>
    <title>Guess the Number</title>
    <style>
        body{
            text-align: center;
        }
        table{
            margin: 0 auto;
        }
        tr{
            text-align: center;
        }
    </style>
</head>
<body>
<%
    //获取输入的值
    String inputNum=request.getParameter("guessNum");
    //显示的消息
    String message=null;
    //是否猜对的标志
    Boolean same=false;
    if (inputNum==null){
        //没有提交过输入的值，生成一个随机数作为答案,猜的次数设置为0
        session.setAttribute("answer",newNum());
        session.setAttribute("count",0);
    }else {
        //提交了输入的值
        //取出答案作比较
        int answer=(Integer) session.getAttribute("answer");
        int guessNum=Integer.parseInt(inputNum);
        int count=(Integer) session.getAttribute("count");
        session.setAttribute("count",count+1);
        if (answer==guessNum){
            //猜对
            message="bravo!";
            same=true;
        }else if (answer>guessNum){
            message="猜小了";
        }else{
            message="猜大了";
        }
    }
%>
    <h1>Guess the Number</h1>
    <hr>
    <%-- --%>
    <%
        if (same){
    %>
    <%--<P>共猜了<%=session.getAttribute("count")%>次才猜对</P>--%>
    <P>共 ${sessionScope.count}
        次才猜对</P>
    <a href="guessNumber.jsp">try again</a>
    <%
        }else{
    %>
    <form method="post" action="guessNumber.jsp" >
        <table>
            <tr>
                <td><input type="text" name="guessNum" placeholder="输入一个数字"></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="submit"><input type="reset" name="reset" value="reset"></td>
            </tr>
        </table>
    </form>
    <hr/>
    <p><%=message %></p>
    <%
        }
    %>
</body>
</html>
