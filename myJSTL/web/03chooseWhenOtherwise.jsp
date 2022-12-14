<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/11/1
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
       choose、when 和 otherwise 标签
           格式：
               <c:choose>
                   <c:when test="<boolean>">
                       ...
                   </c:when>
                   <c:when test="<boolean>">
                       ...
                   </c:when>
                   ...
                   ...
                   <c:otherwise>
                       ...
                   </c:otherwise>
               </c:choose>
           属性：
               1. choose标签没有属性
               2. when标签只有一个test属性，必须属性
               3. otherwise标签没有属性
           注意：
               1. choose标签和otherwise标签没有属性，而when标签必须有一个test属性
               2. choose标签中必须包含至少一个when标签，可以没有otherwise标签 （Illegal "choose" without child "when" tag）
               3. otherwise标签必须设置在最后一个when标签之后 （Illegal "c:when" after "c:otherwise" tag in "c:choose" tag.）
               4. choose标签中只能设置when标签与otherwise标签（Illegal child tag in "c:choose" tag: "c:if" tag）
               5. when标签和otherwise标签中可以嵌套其他标签
               6. otherwise标签会在所有的when标签不执行时才会执行
   --%>
<%
    request.setAttribute("score", 95.5);
    request.setAttribute("num", 10);
%>
<c:choose>
    <c:when test="${score < 60}">
        <h2>不及格</h2>
        <c:if test="${num eq 10}">
            <h1>if num eq 10 in when</h1>
        </c:if>
    </c:when>
<%--    <c:if test="${num eq 10}">--%>
<%--        <h1>if num eq 10</h1>--%>
<%--    </c:if>--%>
    <c:when test="${score < 70}">
        <h2>良好</h2>
    </c:when>
    <c:when test="${score<90}">
        <h2>优秀</h2>
    </c:when>
    <c:otherwise>
        <h2>棒棒！</h2>
        <c:if test="${num eq 10}">
            <h1>if num eq 10 in otherwise</h1>
        </c:if>
    </c:otherwise>
</c:choose>
</body>
</html>
