<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理-注册</title>
    <#include "common.ftl">
    <link rel="stylesheet" href="${ctx}/css/index.css" media="all">

</head>
<body>
<div class="layui-container">
    <div class="admin-login-background">
        <div class="layui-form login-form">
            <form class="layui-form" action="">
                <div class="layui-form-item logo-title">
                    <h1>CRM用户注册</h1>
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-username" for="username"></label>
                    <input type="text" id="regName" name="username" lay-verify="required|account" placeholder="请输入用户名" autocomplete="off" class="layui-input" >
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password" for="password"></label>
                    <input type="password" id="regPwd" name="password" lay-verify="required|password" placeholder="请输入密码" autocomplete="off" class="layui-input" >
                </div>

                <div class="layui-inline">
<#--                    <label class="layui-form-label"></label>-->
                    <div class="layui-input-inline">
                        <input type="text" name="date" id="date" lay-verify="date" placeholder="出生年月日yyyy-MM-dd" autocomplete="off" class="layui-input">
                    </div>
                </div>


                <div class="layui-form-item">
                    <span  id="resMsg" style="color: red; font-weight: bold"></span>
                </div>



                <div class="layui-form-item">

                    <button class="layui-btn" lay-submit lay-filter="regForm">注册</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
<script src="${ctx}/js/register.js" charset="utf-8"></script>
</html>