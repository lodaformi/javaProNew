<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/10/31
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>filedGet</title>
</head>
<body>
    <%
        out.write("page: "+pageContext.getAttribute("name1"));
        out.write("<br>");
        out.write("request: "+request.getAttribute("name2"));
        out.write("<br>");
        out.write("session: "+session.getAttribute("name3"));
        out.write("<br>");
        out.write("application: "+application.getAttribute("name4"));
    %>

</body>
</html>
