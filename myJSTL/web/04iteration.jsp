<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.loda.po.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/11/1
  Time: 15:14
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
    forEach标签
        格式：
            <c:forEach
                items="<object>"
                begin="<int>"
                end="<int>"
                step="<int>"
                var="<string>"
                varStatus="<string>">
            </c:forEach>

        属性：
            begin：开始数
            end：结束数
            step：间隔数
            var：限域变量名，用来接收当前遍历的成员
            items：要循环的数据（数组、List、Map等）

        forEach varStatus 属性
            index: 当前这次迭代从 0 开始的迭代索引
            count: 当前这次迭代从 1 开始的迭代计数
            first: 用来表明当前这轮迭代是否为第一次迭代的标志
            last: 用来表明当前这轮迭代是否为最后一次迭代的标志

        1. 迭代主体内容多次
            <c:forEach begin="开始数" end="结束数" step="间隔数" var="限域变量名">
            </c:forEach>
            相当于Java中for...int
            for (int i = 0; i < 10; i++) {
            }

        2. 循环
            <c:forEach items="要被循环的数据" var="限域变量名">
            </c:forEach>
            相当于Java中的foreach
            for(String str : list) {
            }
--%>
<%-- 迭代主体内容多次 --%>
<c:forEach var="i" begin="0" end="10" step="3">
    ${i} &nbsp;
</c:forEach>
<hr>
<%-- 循环 --%>
<%
    List<String> list = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
        list.add("A:" + i);
    }
    pageContext.setAttribute("li", list);
%>
<c:forEach items="${li}" var="item">
    ${item} &nbsp;
</c:forEach>
<hr>
<%--怎么遍历数组--%>
<%
    Integer[] arr = {11,222,33};
    pageContext.setAttribute("arr", arr);
%>
<c:forEach items="${arr}" var="item">
    ${item} &nbsp;
</c:forEach>
<%--<c:forEach var="i" begin="0" end="${arr.length}"  step="1">--%>
<%--    ${arr[i]} &nbsp;--%>
<%--</c:forEach>--%>
<hr>
<table align="center" width="800" border="1" style="border-collapse: collapse;">
    <tr>
        <th>名称</th>
        <th>当前成员下标</th>
        <th>循环次数</th>
        <th>是否第一次被循环</th>
        <th>是否最后一次被循环</th>
        <th>itemSta.current</th>
        <th>itemSta.step</th>
        <th>itemSta.end</th>
    </tr>
    <c:forEach items="${li}" var="item" varStatus="itemSta">
        <tr>
            <td>${item}</td>
            <td>${itemSta.index}</td>
            <td>${itemSta.count}</td>
            <td>${itemSta.first}</td>
            <td>${itemSta.last}</td>
            <td>${itemSta.current}</td>
            <td>${itemSta.step}</td>    <%-- 没值--%>
            <td>${itemSta.end}</td>  <%-- 没值--%>
        </tr>
    </c:forEach>
</table>
<hr>
<%-- 循环对象集合 --%>
<%
    List<User> userList = new ArrayList<>();
    User user = new User(1,"zhangsan","123456");
    User user2 = new User(2,"lisi","123321");
    User user3 = new User(3,"wangwu","654321");
    userList.add(user);
    userList.add(user2);
    userList.add(user3);
    // 将数据设置到作用域中
    request.setAttribute("userList", userList);
%>
<%-- 当集合不为空时，遍历集合 --%>
<c:if test="${!empty userList}">
    <table align="center" width="800" border="1" style="border-collapse: collapse;">
        <tr>
            <th>ID</th>
            <th>名称</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${userList}" var="item">
            <tr>
                <td align="center">${item.id}</td>
                <td align="center">${item.uname}</td>
                <td align="center">${item.pwd}</td>
                <td align="center"><button>update</button></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<%--循环map--%>
<%
    Map<String,Object> map = new HashMap<>();
    map.put("map1", "aaa");
    map.put("map2", "bbb");
    map.put("map3", "ccc");
    pageContext.setAttribute("map", map);
%>
<c:forEach items="${map}" var="item">
    key: ${item.key} &nbsp; value: ${item.value} <br>
</c:forEach>

</body>
</html>
