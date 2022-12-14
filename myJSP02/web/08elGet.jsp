<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.loda.po.User" %><%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/11/1
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>elGet</title>
</head>
<body>
<%--
    EL表达式的使用
        获取List
            获取List的size  ${list.size()}
            获取List的指定下标的值    ${list[下标]}
            注：list代表的是限域变量名
        获取Map
            获取Map中指定key的value   ${map.key} 或 ${map["key"]}
            注：map代表的是限域变量名
        获取JavaBean对象
            获取JavaBean中的属性
                ${javaBean.属性名} 或 ${JavaBean对象.get属性名()}
            注：JavaBean中的属性字段必须提供get方法

--%>
<%
    //list
    List<String> list1 = new ArrayList<>();
    list1.add("123");
    list1.add("abc");
    list1.add("www");
    request.setAttribute("list", list1);

    //map
    Map<String, Integer> myMap1 = new HashMap<>();
        myMap1.put("tom",18);
        myMap1.put("jerry", 19);
        myMap1.put("mike",17);
    request.setAttribute("map", myMap1);

    //javaBean
    User user01 = new User();
    user01.setId(1);
    user01.setUname("tom");
    user01.setPwd("abc");
    request.setAttribute("user", user01);
%>

<h1>获取list</h1>
list.size: ${list.size()}<br>
list[2]: ${list[2]}<br>

<h1>获取map</h1>
map.tom: ${map.tom} <br>
map["jerry"]: ${map["jerry"]} <br>

<h1>获取javaBean对象</h1>
user: ${user} <br>
user.uname： ${user.uname}<br>
user.getPwd()： ${user.getPwd()}<br>
</body>
</html>
