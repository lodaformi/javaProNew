<!DOCTYPE html>
<html>
<head>
    <title>信息管理</title>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" >
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" name="loginDateTime"
                           class="layui-input
					searchVal" placeholder="登陆时间" />
                </div>
                <a class="layui-btn search_btn" data-type="reload"><i
                            class="layui-icon">&#xe615;</i> 搜索</a>
            </div>
        </form>
    </blockquote>
    <#--    数据表格-->
    <table id="infoList" class="layui-table"  lay-filter="info"></table>

</form>
<script type="text/javascript" src="${ctx}/js/login/info.js"></script>

</body>
</html>