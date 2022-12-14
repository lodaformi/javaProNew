<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/10/31
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
动态包含
    格式:
        <jsp:include page="要包含的页面地址"></jsp:include>

         <jsp:include page="<%=val%>"></jsp:include>
                val不能为空
    特点:
        1．相等于方法调用
        2．生成多个源码文件，
        3．可以出现同名变量
        4．灵活方便，耦合性较低。
       注意：
            当动态包含不需要传递参数时，include双标签之间不要有任何内容，包括换行和空格
        异常报告 /05dynamicInclude.jsp (行.: [53], 列: [0]) 使用“name”；和“value”属性期望“jsp:param”标准操作


       传递参数

               <jsp:include page="04footer.jsp">
                    <jsp:param name="nameA" value="valA"/>
               </jsp:include>

           传固定值
                <jsp:param name="uname" value="scott"/>
           传表达式
                <jsp:param name="pwd" value="<%=pVal%>"/>

           获取参数
             String val = request.getParameter("key_name");


--%>

<jsp:include page="04header.jsp"></jsp:include>
<h1>body</h1>

<%
    String pageUrl="04footer.jsp";
//    String pageUrl=null;
%>


<jsp:include page="<%=pageUrl%>"></jsp:include>

<%
    String pVal="TIGER";
    Integer num = 20;
%>

<jsp:include page="04footer.jsp">
    <jsp:param name="uname" value="scott"/>
    <jsp:param name="pwd" value="<%=pVal%>"/>
</jsp:include>
<%
    System.out.println("body after footer: " + num);
%>

</body>

</html>
