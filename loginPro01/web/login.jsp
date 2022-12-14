<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/11/3
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>userLogin</title>
</head>
<body>
<div style="text-align: center">
    <form action="login" method="post" id="loginForm">
        姓名: <input type="text" name="uname" id="uname" value="${messageModel.object.userName}"><br>
        密码: <input type="text" name="upwd" id="upwd" value="${messageModel.object.userPwd}"> <br>
        <span id="msgSpan" style="font-size: 12px; color: darkred">${messageModel.msg}</span><br>
        <button type="button" id="loginBtn">登录</button>
        <button type="button" id="regBtn">注册</button>
    </form>
</div>
</body>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
<%--
    登录表单验证
        1．给登录按钮绑定点击事件（通过id选择器绑定)
        2．获取用户姓名和密码的值
        3．判断姓名是否为空
            如果姓名为空，提示用户( span标签赋值)，并且return
        4．判断密码是否为空
            如果密码为空，提示用户( span标签赋值)，并且return
        5．如果都不为空，则手动提交表单

        分层思想（解耦:高内聚低耦合)
            controller层
            接收请求
            (调用service层，返回结果）响应结果
        service层
            业务逻辑判断mapper
        接口类
            mapper.xml mybatis与数据库的相关操作entity (po、model)
        JavaBean实体util
        工具类（通用的方法/类)test
        测试类/方法
--%>
    $("#loginBtn").click(function() {
        var name = $("#uname").val();
        var pwd = $("#upwd").val();
        if (isEmpty(name)) {
            $("#msgSpan").html("用户名不能为空");
            return;
        }
        if (isEmpty(pwd)) {
            $("#msgSpan").html("密码不能为空");
            return;
        }
        $("#loginForm").submit();
    });


    function isEmpty(str) {
        // if (str == null || str.trim() == "") {
        //     return true;
        // }
        // return false;

        return str == null || str.trim() == "";
    }
</script>
</html>
