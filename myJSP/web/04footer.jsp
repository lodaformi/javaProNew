<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/10/31
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>footer</title>
</head>
<body>
    <h1>footer</h1>
<%--静态包含不能有重复的变量，如果编译的时候没有检测出来，运行的时候也会报错--%>
<%--    <%--%>
<%--        &lt;%&ndash;--%>
<%--        JSP文件：[/04footer.jsp] 的第 [16] 行发生了一个错误--%>
<%--        Duplicate local variable num--%>
<%--        &ndash;%&gt;--%>
<%--        Integer num = 30;--%>
<%--    %>--%>

    <%
        String name = request.getParameter("uname");
        String pwd = request.getParameter("pwd");

        out.write(name+"---"+pwd);
        Integer num = 200;
        out.write("footer: " + num);
//        System.out.println("footer num: "+ num);
    %>

</body>
</html>
