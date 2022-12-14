layui.use(['form','jquery','jquery_cookie'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        $ = layui.jquery_cookie($);

    $("#regBtn").click(function () {
        window.location.href=ctx+"/register";
    });

    // layui 用户登录 表单提交
    form.on('submit(login)',function (data) {
        // 获取表单元素 用户名+密码
        data = data.field;
        console.log(data);

        /**
         *  用户名 密码 非空校验
         */
        if(data.username=="undefined" || data.username=="" || data.username.trim()==""){
            layer.msg("用户名不能为空!");
            return false;
        }

        if(data.password=="undefined" || data.password=="" || data.password.trim()==""){
            layer.msg("用户密码不能为空!");
            return false;
        }

        $.ajax({
            type:"post",
            url:ctx+"/user/login",
            data:{
                username:data.username,
                tPwd:data.password
            },
            dataType:"json",
            success:function (data) {
                if(data.code==200){
                    $("#resMsg").text(data.msg)
                    afterLogin(data)
                    // layer.msg("用户登录成功",function () {
                    //     var result =data.result;
                    //     $.cookie("userId",result.id);
                    //     $.cookie("userName",result.username);
                    //     if($("input[type='checkbox']").is(":checked")){
                    //         $.cookie("userId",result.id,{expires:7});
                    //         $.cookie("userName",result.username,{expires:7});
                    //     }
                    //     window.location.href=ctx+"/main";
                    // })
                }else{
                    $("#resMsg").text(data.msg)
                    // layer.msg(data.msg);
                }
            }
        });
        return false;
    })

    function afterLogin(data) {
        var result =data.result;
        $.cookie("userId",result.id);
        $.cookie("userName",result.username);

        if($("input[type='checkbox']").is(":checked")){
            $.cookie("userId",result.id,{expires:7});
            $.cookie("userName",result.username,{expires:7});
        }
        //将用户登陆ip和时间存入数据库
        // $.ajax({
        //     type: "post",
        //     url: ctx+"/user/loginInfo",
        //     data: {
        //         tLoginIp: result.ip,
        //         tLoginTime: result.date
        //     }
        //     // ,
        //     // success: function (result) {
        //     //     if(result.code==200){
        //     //         $("#resMsg").text(result.msg)
        //     //     }else{
        //     //         $("#resMsg").text(result.msg)
        //     //         // layer.msg(data.msg);
        //     //     }
        //     // }
        // })
        window.location.href=ctx+"/main";
    }

});