layui.use(['form','jquery','laydate'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        laydate = layui.laydate;

    //加载日期控件
    laydate.render({
        elem: '#date' //指定元素
    });

    $("#regPwd").blur(function () {
        // $("#resMsg").text("")
        var userPwd = $("#regPwd").val();

        if(userPwd=="undefined" || userPwd=="" || userPwd.trim()==""){
            $("#resMsg").text("用户密码不能为空!");
            return false;
        }
    })

    $("#regName").blur(function () {
        // $("#resMsg").text("")
        var username = $("#regName").val();
        console.log($("#regName").val())

        if(username == "undefined" || username=="" || username.trim()==""){
            $("#resMsg").text("用户名不能为空!");
            return false;
        }
        //向后端发送数据，检查用户名是否存在
        $.ajax({
            type: "post",
            url: ctx + "/user/checkName",
            data: {
                username: username
            },
            dataType:"json",
            success:function (data) {
                if(data.code==200){
                    $("#resMsg").text(data.msg)
                }else{
                    $("#resMsg").text(data.msg)
                    // layer.msg(data.msg);
                }
            }
        })
    })

    //监听提交
    form.on('submit(regForm)', function(data){
        var username = $("#regName").val();
        if(username == "undefined" || username=="" || username.trim()==""){
            $("#resMsg").text("用户名不能为空!");
            return false;
        }

        if (username.length < 3 || username.length > 12) {
            $("#resMsg").text("用户名长度需在3-12位！")
            return false;
        }

        var userPwd = $("#regPwd").val();
        if(userPwd=="undefined" || userPwd=="" || userPwd.trim()==""){
            $("#resMsg").text("用户密码不能为空!");
            return false;
        }
        console.log(userPwd.length)
        if (userPwd.length < 6 || userPwd.length > 18){
            $("#resMsg").text("密码长度需在6-18位！")
            return false;
        }

        var date = $("#date").val();
        console.log(date)
        if (date.length == 0 || date.trim() == '') {
            $("#resMsg").text("出生年月日不能为空!");
            return false;
        }

        var userData = data.field;
        console.log("data.field")
        console.log(userData)
        $.ajax({
           type: "post",
           url: ctx +"/user/register",
           data: {
               username: userData.username,
               tPwd:userData.password,
               tBirthday: userData.date
           },
            success: function (result) {
                if(result.code==200){
                    $("#resMsg").text("注册成功,在3秒后跳转到登陆界面...")
                    setTimeout(function () {
                        window.parent.location.href=ctx+"/index";
                    },3000);
                }else{
                    $("#resMsg").text(result.msg)
                }
            }
        });
        return false;
    });
});