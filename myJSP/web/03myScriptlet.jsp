<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/10/31
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page  contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>myScriptlet</title>
</head>
<body>
<%--java脚本段，可以定义局部变量、编写语句--%>
<%

    //局部变量
    String name = "tom";
    System.out.println("name console1: "+ name);
    System.out.println("num console1: "+num);
    out.println("name browser1: "+ name);
    out.println("num browser1: "+ num);
    out.write("name browser1.1: "+ name);
    out.write("num browser1.1: "+ num);
%>

<%
    System.out.println("name console2: "+ name);
    System.out.println("num console2: "+num);
    out.println("name browser2: "+ name);
    out.println("num browser2: "+ num);
    out.write("name browser2.1: "+ name);
    out.write("num browser2.1: "+ num);
%>
<%--java脚本段，声明，可以定义全局（成员）变量、方法、类--%>
<%!
    //全局变量
    Integer num = 101;
%>

<%--java脚本段--输出--%>
<%=
    "name3: "+ name
%>

<%=
"num3: "+ num
%>
</body>
</html>
