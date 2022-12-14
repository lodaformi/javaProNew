<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/10/31
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="loginServelet" method="post">
    姓名<input type="text" name="uname" placeholder="input your name"><br>
    密码<input type="password" name="pwd" placeholder="input your password"> <br>
<%--    <span style="color: darkred; font-size: 20px"><%=request.getAttribute("msg")%></span>--%>
    <span style="color: darkred; font-size: 20px">${msg}</span>
    <br>
    <button>submit</button>

</form>
</body>
</html>
