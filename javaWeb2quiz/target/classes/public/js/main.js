layui.use(['element', 'layer', 'layuimini','jquery','jquery_cookie'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        $ = layui.jquery_cookie($);

    // 菜单初始化
    $('#layuiminiHomeTabIframe').html('<iframe width="100%" height="100%" frameborder="0"  src="welcome"></iframe>')
    layuimini.initTab();


    $(".login-out").click(function () {
        layer.confirm('确认退出?', {icon: 3, title:'系统提示'}, function(index){
            //关闭弹出框
            layer.close(index);

            //清空cookies
            $.removeCookie("userId",{domain:"localhost",path:"/crm"});
            $.removeCookie("userName",{domain:"localhost",path:"/crm"});
            //跳转到登陆页(父级窗口跳转)
            window.parent.location.href = ctx + "/index";
        });
    });




});

