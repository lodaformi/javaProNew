<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/10/31
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el</title>
</head>
<body>
<%--
EL表达式
    作用:
        简化JSP代码
    格式:
        ${域对象的名称}
    操作对象:
        EL表达式一般操作的是域对象，不能操作局部变量。
    操作范围:
        page范围
            在当前页面
        request范围
            在一次请求
        session范围
            在一次会话
        application范围
            在整个应用程序
    注:
    1．如果el表达式获取域对象的值为空，默认显示空字符串
    2. el表达式默认从小到大范围去找，找到即停止寻找，如果四个范围都未找到，返回空字符串

    查找数据时可以使用四个域对象对应的空间对象，分别是:
        pageScope,lequestScope, sessionScope,applicationScope
    查找指定空间的数据
--%>

<%--设置数据--%>
<%
//    pageContext.setAttribute("name","tom1");
    request.setAttribute("name", "tom2");
    session.setAttribute("name","tom3");
    application.setAttribute("name","tom4");
%>

<%--获取数据--%>
    name:${name}<br>
    str:${str}<br>
<%--获取指定范围的数据--%>
pageScope.name: ${pageScope.name}<br>
requestScope.name: ${requestScope.name}<br>
sessionScope.name: ${sessionScope.name}<br>
applicationScope.name：${applicationScope.name}<br>
</body>
</html>
