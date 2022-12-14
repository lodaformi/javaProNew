<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/11/16
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file</title>
</head>
<body>
<form action="uploadFile.do" method="post" enctype="multipart/form-data">
    <input type="file" name="file" />
    <button type="submit"> 提交</button>
</form>
</body>
</html>