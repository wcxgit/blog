<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: 76339
  Date: 2017/7/24
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/tag.jsp" %>
<html>
<head>
    <title>设置导航栏内容</title>

    <%@include file="/common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">导航栏内容管理 <a class="btn btn-primary" data-toggle="modal"
                                               data-target="#add"><i class="fa fa-plus"
                                                                     style="color:white;">新增</i></a>
            </h3>
        </div>
        <table class="table table-bordered table-striped table-condensed">
            <thead>
            <tr>
                <th>序号</th>
                <th>导航名称</th>
                <th>指向地址</th>
                <th>创建日期</th>
                <th>修改日期</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="navbar" varStatus="status">
                <tr>
                    <th>${status.count}</th>
                    <th>${navbar.nName}</th>
                    <th>${navbar.nPath}</th>
                    <th>
                        <fmt:formatDate value="${navbar.createTime}" pattern="yyyy-MM-dd"/>
                    </th>
                    <th>
                        <fmt:formatDate value="${navbar.updateTime}" pattern="yyyy-MM-dd"/>
                    </th>
                    <th><a href="javascript:;" onclick="edit(${navbar.nId});" class="btn btn-primary"><i
                            class="fa fa-edit">修改</i></a>
                        <a href="javascript:;" onclick="del(${navbar.nId});" class="btn btn-danger"><i
                                class="fa fa-trash">删除</i></a>
                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <ul class="pagination" style="margin-top:0;">
        <c:if test="${pageInfo.prePage == 0}">
            <li class="disabled"><a href="javascript:;">&laquo;</a></li>
        </c:if>
        <c:if test="${pageInfo.prePage != 0}">
            <li>
                <a href="${pageContext.request.contextPath}/manage/getNavBars.do?pageNum=${pageInfo.pageNum-1}">&laquo;</a>
            </li>
        </c:if>
        <c:forEach var="num" begin="${pageInfo.navigateFirstPage}" end="${pageInfo.navigateLastPage}">
            <li><a href="${pageContext.request.contextPath}/manage/getNavBars.do?pageNum=${num}">${num}</a></li>
        </c:forEach>
        <c:if test="${pageInfo.pageNum == pageInfo.pages}">
            <li class="disabled"><a href="javascript:;">&raquo;</a></li>
        </c:if>
        <c:if test="${pageInfo.pageNum != pageInfo.pages}">
            <li>
                <a href="${pageContext.request.contextPath}/manage/getNavBars.do?pageNum=${pageInfo.pageNum+1}">&raquo;</a>
            </li>
        </c:if>
    </ul>
</div>
<%--添加模态框--%>
<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="addLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="addLabel">添加导航卡</h4>
            </div>
            <div class="modal-body">
                <form role="form" id="form">
                    <div class="form-group">
                        <label for="nName">导航卡名称</label>
                        <input type="text" class="form-control" name="nName" id="nName" placeholder="请输入导航卡名称" required>
                    </div>
                    <div class="form-group">
                        <label for="nPath">导航路径</label>
                        <input type="text" class="form-control" name="nPath" id="nPath" placeholder="请输入导航路径" required>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="sub" class="btn btn-primary">添加</button>
            </div>
        </div>
    </div>
</div>
<%--提示信息模态框--%>
<div class="modal fade" id="info" tabindex="-1" role="dialog" aria-labelledby="errLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="errLabel"></h4>
            </div>
            <div class="modal-body info">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<%--编辑信息--%>
<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="editLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="editLabel">修改导航信息</h4>
            </div>
            <div class="modal-body">
                <form role="form" id="editForm">
                    <div class="form-group">
                        <label for="nName">修改</label>
                        <input type="text" class="form-control" name="nName" id="editName" placeholder="请输入导航卡名称"
                               required>
                        <input type="hidden" name="nId" id="nId">
                    </div>
                    <div class="form-group">
                        <label for="nPath">导航路径</label>
                        <input type="text" class="form-control" name="nPath" id="editPath" placeholder="请输入导航路径"
                               required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="editSubmit" class="btn btn-primary">确认修改</button>
            </div>
        </div>
    </div>
</div>
<%--确认删除模态框--%>
<div class="modal fade" id="del" tabindex="-1" role="dialog" aria-labelledby="delLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title text-danger" id="delLabel">删除</h4>
            </div>
            <div class="modal-body info">
                确认删除该条信息吗?删除后无法恢复!
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-danger" id="isDel">确认</button>
            </div>
        </div>
    </div>
</div>


<%@include file="/common/js.jsp" %>
<script src="${pageContext.request.contextPath}/js/manager.js"></script>
<script>
    $("#sub").click(function () {
        manageNavBar.addNavBar();
    });

    //编辑
    function edit(id) {
        manageNavBar.editNavBar(id);
    }

    //删除
    function del(id) {
        manageNavBar.delById(id);
    }
</script>
</body>
</html>
