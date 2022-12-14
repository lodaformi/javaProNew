<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/10/30
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="loginServelet" id="loginForm">
    姓名：<input type="text" name="uname" id="uname">
    <button type="button" onclick="login();">登录</button>

    <script src="js/user.js" type="text/javascript"></script>
</form>
</body>
</html>
