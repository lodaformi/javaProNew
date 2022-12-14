<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/10/31
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>filedObj</title>
</head>
<body>
<%--
四大域对象
JSP中跳转方式
    1.服务端跳转
        jsp:forward page="跳转的页面地址"></jsp:forward>
    2．客户端跳转
        超链接

--%>

<%
    pageContext.setAttribute("name1", "tom1");
    request.setAttribute("name2", "tom2");
    session.setAttribute("name3", "tom3");
    application.setAttribute("name4", "tom4");
%>
<%--<jsp:forward page="06filedGet.jsp"></jsp:forward>--%>

<a href="06filedGet.jsp">jump2get</a>

</body>
</html>
