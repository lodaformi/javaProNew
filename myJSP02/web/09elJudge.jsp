<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.loda.po.User" %><%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/11/1
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>elJudge</title>
</head>
<body>
<%--
       EL表达式的使用
           empty
               判断域对象是否为空
                   为空，返回true；
                   不为空，返回false；

               如果域对象是字符串：
                   不存在的域对象：true
                   空字符串：true
                   null：true
                   有值：false

               如果域对象是List：
                   null：true
                   没有长度的List（size）：true

               如果域对象是Map：
                   null：true
                   空map对象：true
               如果域对象是Javabean对象：
                   null：true
                   空对象：false
           判断域对象不为空
               ${!empty 限域变量名}

        比较两个值是否相等，返回true或false
              ==  或  eq

   --%>
<%
    //str
    request.setAttribute("str1","");
    request.setAttribute("str2", "abc");
    request.setAttribute("str3", null);
%>
<h1>string</h1>
${empty str}
${empty str1}
${empty str2}
${empty str3}

<%
    //list
    List<String> list1 = null;
    List<String> list2 = new ArrayList<>();
    List<String> list3 = new ArrayList<>();
    list3.add("abc");
    request.setAttribute("list1", list1);
    request.setAttribute("list2", list2);
    request.setAttribute("list3", list3);
%>
<h1>list</h1>
${empty list}
${empty list1}
${empty list2}
${empty list3}

<%
    //map
    Map<String, Integer> map1 = null;
    Map<String, Integer> map2 = new HashMap<>();
    Map<String, Integer> map3 = new HashMap<>();
    map3.put("tom", 18);
    request.setAttribute("map1", map1);
    request.setAttribute("map2", map2);
    request.setAttribute("map3", map3);
%>
<h1>map</h1>
${empty map}
${empty map1}
${empty map2}
${empty map3}

<%--javaBean--%>
<%
    User user1 = null;
    User user2 = new User();
    User user3 = new User();
    user3.setId(1);
    request.setAttribute("user1", user1);
    request.setAttribute("user2", user2);
    request.setAttribute("user3", user3);
%>
<h1>javaBean</h1>
${empty user}
${empty user1}
${empty user2}
${empty user3}<br>
!empty user: ${!empty user}<br>
!empty user1: ${!empty user1}<br>
!empty user2: ${!empty user2}<br>
!empty user3: ${!empty user3}<br>


<%--运算符--%>
<%
    request.setAttribute("a", 10);
    request.setAttribute("b", 2);
    request.setAttribute("c", "aa");
    request.setAttribute("d", "bb");
%>
<%--
    比较两个值是否相等，返回true或false
        ==  或  eq
--%>
${a == b }
${c == d }
${c eq d }
${a == 5 }
${c == 'aa' }
<hr>
<%--
    加法： +
    减法： -
    乘法： *
    除法：	/ 或 div
--%>
${a + b }
${a / b } 或 ${a div b }
<hr>
<%--
    大于：>
    小于：<
    大于等于：>=
    小于等于：<=
--%>
${a > b}
${a + 1 > 10 }
${a + b >= 10 }
${a > b && b > 5 }
${a + b > 10 || a - b > 5 }
</body>
</html>
