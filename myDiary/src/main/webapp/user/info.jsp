<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/11/5
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title"><span class="glyphicon glyphicon-edit"></span>&nbsp;个人中心 </div>
        <div class="container-fluid">
            <div class="row" style="padding-top: 20px;">
                <div class="col-md-8">
<%--                    表单类型  enctype="multipart/form-data"--%>
<%--                    提交方式  method="post"--%>
                    <form class="form-horizontal" method="post" action="user" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="hidden" name="actionName" value="updateUser">
                            <label for="nickName" class="col-sm-2 control-label">昵称:</label>
                            <div class="col-sm-3">
                                <input class="form-control" name="nick" id="nickName" placeholder="昵称" value="${user.nick}">
                            </div>
                            <label for="img" class="col-sm-2 control-label">头像:</label>
                            <div class="col-sm-5">
                                <input type="file" id="img" name="img">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="mood" class="col-sm-2 control-label">心情:</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" name="mood" id="mood" rows="3">${user.mood}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" id="btn" class="btn btn-success" onclick="return updateUser();">修改</button>&nbsp;&nbsp;
                                <span style="color:red; font-size: 12px" id="msg"></span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-4"><img style="width:240px;height:200px" src="user?actionName=userHead&imageName=${user.head}"></div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    $("#nickName").blur(function () {
        // 昵称文本框的失焦事件  blur
        // 1. 获取昵称文本框的值
        var newNick = $("#nickName").val();
        // 2. 判断值是否为空
        if (isEmpty(newNick)){
            // 如果为空，提示用户，禁用按钮，并return
            $("#msg").html("昵称不能为空");
            $("#btn").attr("disabled", true)
            return;
        }
        // 3. 判断昵称是否做了修改
        // 从session作用域中获取用户昵称 （如果在js中想要使用el表达式获取域对象，js需要写在JSP页面中，无法在js文件中获取）
        var oldNick = "${user.nick}";
        console.log("oldNick "+oldNick);
        console.log("newNick "+newNick);
        if (newNick == oldNick) {
            //如果用户昵称与session中的昵称一致，则return
            // $("#msg").html("昵称未改变");
            return;
        }
        // 4. 如果昵称做了修改
        // 发送ajax请求后台，验证昵称是否可用
        $.ajax({
            type:"get",
            url: "user",
            data: {
                nick:newNick,
                actionName:"checkNick"
            },
            success: function (code) {
                console.log("ajax code: " + code );
                // 如果不可用，提示用户，并禁用按钮
                if (code == 0) {
                    $("#msg").html("昵称已存在，请更换");
                    $("#btn").attr("disabled", true)

                } else {
                    // 如果可用，清空提示信息，按钮可用
                    $("#msg").html("");
                    $("#btn").attr("disabled", false)
                }
            }
        });
    }).focus(function () {
        // 昵称文本框的聚焦事件  focus
        // 1. 清空提示信息
            $("#msg").html("");
        // 2. 按钮可用
            $("#btn").attr("disabled", false);
    });

    /**
     * 表单提交校验
     *      满足条件，返回true，表示提交表单
     *      不满足条件，返回false，表示不提交表单
     * @returns {boolean}
     */
    function updateUser() {
        // 1. 获取昵称文本框的值
        var newNick = $("#nickName").val();
        // 2. 判断昵称是否做了修改
        // 从session作用域中获取用户昵称 （如果在js中想要使用el表达式获取域对象，js需要写在JSP页面中，无法在js文件中获取）
        var oldNick = "${user.nick}";
        if (newNick == oldNick) {
            //如果用户昵称与session中的昵称一致，则return false
            $("#msg").html("昵称未改变");
            $("#btn").attr("disabled", true);
            return false;
        }
        // 3. 判断值是否为空
        if (isEmpty(newNick)){
            // 如果为空，提示用户，禁用按钮，并return
            $("#msg").html("昵称不能为空");
            $("#btn").attr("disabled", true);
            return false;
        }
        //通过上面校验，则提交到后台
        return true;
    }
</script>