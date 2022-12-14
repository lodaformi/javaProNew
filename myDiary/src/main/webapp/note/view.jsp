<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/11/8
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title">
            <span class="glyphicon glyphicon-cloud-upload"></span>&nbsp;
            <c:if test="${empty noteInfo}">
                发表云记
            </c:if>
            <c:if test="${!empty noteInfo}">
                修改云记
            </c:if>
        </div>
        <div class="container-fluid">
            <div class="container-fluid">
                <div class="row" style="padding-top: 20px;">
                    <div class="col-md-12">
                        <%-- 判断类型列表是否为空，如果为空，提示用户先添加类型 --%>
                        <c:if test="${empty noteTypeList}">
                            <h1>没有日记类型，请先创建日记类型</h1>
                            <h4><a href="noteType?actionName=noteType">添加类型</a></h4>
                        </c:if>
                        <c:if test="${!empty noteTypeList}">
                            <form class="form-horizontal" method="post" action="note">
                                    <%-- 设置隐藏域：用来存放用户行为actionName --%>
                                <input type="hidden" name="actionName" value="addOrUpdateNote">
                                    <%-- 设置隐藏域：用来存放noteId --%>
                                <input type="hidden" name="noteId" value="${noteInfo.noteId}">

                                    <%-- 设置隐藏域：用来存放用户发布云记时所在地区的经纬度 --%>
                                    <%-- 经度 --%>
                                <input type="hidden" name="lon" id="lon">
                                    <%-- 纬度 --%>
                                <input type="hidden" name="lat" id="lat">

                                <div class="form-group">
                                    <label for="typeId" class="col-sm-2 control-label">类别:</label>
                                    <div class="col-sm-8">
                                        <select id="typeId" class="form-control" name="typeId">
                                            <option value="">请选择云记类别...</option>
                                            <c:forEach items="${noteTypeList}" var="item">
                                                <c:choose>
                                                    <c:when test="${!empty resultInfo}">
                                                        <option <c:if test="${resultInfo.rsObj.typeId == item.typeId}">selected</c:if>
                                                                value="${item.typeId}"> ${item.typeName} </option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option <c:if test="${noteInfo.typeId == item.typeId}">selected</c:if>
                                                                value="${item.typeId}"> ${item.typeName} </option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="title" class="col-sm-2 control-label">标题:</label>
                                    <div class="col-sm-8">
                                        <c:choose>
                                            <c:when test="${!empty resultInfo}">
                                                <input class="form-control" name="title" id="title" placeholder="云记标题" value="${resultInfo.rsObj.title}">
                                            </c:when>
                                            <c:otherwise>
                                                <input class="form-control" name="title" id="title" placeholder="云记标题" value="${noteInfo.title}">
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="title" class="col-sm-2 control-label">内容:</label>
                                    <div class="col-sm-8">
                                        <c:choose>
                                            <c:when test="${!empty resultInfo}">
                                                <%-- 准备容器，加载富文本编辑器 --%>
                                                <textarea id="content" name="content">${resultInfo.rsObj.content}</textarea>
                                            </c:when>
                                            <c:otherwise>
                                                <%-- 准备容器，加载富文本编辑器 --%>
                                                <textarea id="content" name="content">${noteInfo.content}</textarea>
                                            </c:otherwise>
                                        </c:choose>

                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-4 col-sm-4">
                                        <input type="submit" class="btn btn-primary" onclick="return checkForm()"  value="保存">
                                        &nbsp;<span id="msg" style="font-size: 12px;color: red">${resultInfo.msg}</span>
                                    </div>
                                </div>
                            </form>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var ue;
    $(function () {
        ue = UE.getEditor("content")
    });

    function checkForm() {
        // 获取下拉框选中的选项  .val()
        var type = $("#typeId").val();
        // 获取文本框的值       .val()
        var title = $("#title").val();
        // 获取富文本编辑器的内容
        // ue.getContent() 获取富文本编辑器的内容（包含html标签）
        //             ue.getContentTxt() 获取富文本编辑器的纯文本内容（不包含html标签）
        var content = ue.getContent();

        //非空判断
        if (isEmpty(type)) {
            $("#msg").html("类别不能为空");
            return false;
        }
        if (isEmpty(title)) {
            $("#msg").html("标题不能为空");
            return false;
        }
        if (isEmpty(content)) {
            $("#msg").html("内容不能为空");
            return false;
        }
        return true;
    }

</script>