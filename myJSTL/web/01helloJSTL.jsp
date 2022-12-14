<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/11/1
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    JSTL的使用
        1. 下载JSTL所需要的jar包 （standard.jar 和 jstl.jar）
        2. 在项目的web目录下的WEB-INF中新建lib目录，将jar拷贝进去
        3. 右键lib目录Add as Library...
        4. 在需要使用标签库的JSP页面通过taglib标签引入指定库
--%>
<c:if test="${1==1}">
    Hello JSTL
</c:if>
</body>
</html>
