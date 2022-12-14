<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/11/5
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title">
            <span class="glyphicon glyphicon-list"></span>&nbsp;类型列表
            <span class="noteType_add">
			    <button class="btn btn-sm btn-success" type="button" id="addBtn">添加类别</button>
		    </span>
        </div>

        <div id="pDiv">
            <c:if test="${empty typeList}">
                <h2>未查询到日记类型</h2>
            </c:if>
            <c:if test="${!empty typeList}">
                <table id="myTable" class="table table-hover table-striped ">
                    <tbody>
                        <tr>
                            <th>编号</th>
                            <th>类型</th>
                            <th>操作</th>
                        </tr>
                    <c:forEach items="${typeList}" var="item">
                        <tr id="tr_${item.typeId}">
                            <td>${item.typeId}</td>
                            <td>${item.typeName}</td>
                            <td>
                                <button class="btn btn-primary" type="button" onclick="openUpdateModal(${item.typeId})">修改</button>&nbsp;
                                <button class="btn btn-danger del" type="button" onclick="deleteType(${item.typeId})">删除</button>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </c:if>
        </div>
    </div>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="typename">类型名称</label>
                        <input type="hidden" name="typeId" id="typeId">
                        <input type="text" name="typename" class="form-control" id="typename" placeholder="类型名称">
                    </div>
                </div>
                <div class="modal-footer">
<%--                    <tr><td>--%>
<%--                        <span style="color: red; font-size: 12px" id="msgSpan"></span>--%>
<%--                    </td></tr>--%>
                    <span id="msg" style="color: red; font-size: 12px"></span>
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove"></span>关闭</button>
                    <button type="button" id="btn_submit" class="btn btn-primary">
                        <span class="glyphicon glyphicon-floppy-disk"></span>保存</button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


<script src="statics/js/type.js" type="text/javascript"></script>