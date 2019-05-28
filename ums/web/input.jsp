<%--如下为input.jsp文件参考代码--%>
<%@page language="java" contentType="text/html;charser:utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head><meta http-equiv="Content-Type" content=""></head>
    <body>
        <form action="____(3)_______" method="post">
            姓名:<input type="text" name="username"/><br>
            密码:<input type="password" name="pwd"/><br>
            爱好:
            <input type="__(5)____" name="favorite" value="读书"/>读书
            <input type="__(5)____" name="favorite" value="游泳"/>游泳
            <input type="__(5)____" name="favorite" value="爬山"/>爬山
            <input type="__(5)____" name="favorite" value="听音乐"/>听音乐
            <input type="__(5)____" name="favorite" value="看电影"/>看电影<br>
            <input type="submit" value="确定"/>
            <input type="reset" value="重置"/>
        </form>
    </body>
</html>
