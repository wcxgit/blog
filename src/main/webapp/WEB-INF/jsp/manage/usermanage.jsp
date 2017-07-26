<%--
  Created by IntelliJ IDEA.
  User: 76339
  Date: 2017/7/25
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/tag.jsp" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/common/head.jsp" %>
    <%@include file="/common/js.jsp" %>
    <script src="${pageContext.request.contextPath}/js/manager.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">用户管理</h3>
        </div>
        <table class="table table-bordered table-striped table-condensed">
            <thead>
            <tr>
                <th>序号</th>
                <th>用户名</th>
                <th>性别</th>
                <th>邮箱</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="userInfo" varStatus="status">
                <tr>
                    <th>${status.count}</th>
                    <th>${userInfo.uName}</th>
                    <th>${userInfo.uSex}</th>
                    <th>${userInfo.uEmail}</th>
                    <th>
                        <fmt:formatDate value="${userInfo.createTime}" pattern="yyyy-MM-dd"/>
                    </th>
                    <th>
                        <fmt:formatDate value="${userInfo.updateTime}" pattern="yyyy-MM-dd"/>
                    </th>
                    <th>
                        <c:if test="${userInfo.uState == 0}">
                            <a href="javascript:;" onclick="operation(${userInfo.uId},'undo');"
                               class="btn btn-primary "><i
                                    class="fa fa-undo"> 解封</i></a>
                            <a href="javascript:;" class="btn btn-danger disabled"><i
                                    class="fa fa-remove"> 封号</i></a>
                        </c:if>
                        <c:if test="${userInfo.uState == 1}">
                            <a href="javascript:;" class="btn btn-primary disabled"><i
                                    class="fa fa-undo"> 解封</i></a>
                            <a href="javascript:;" onclick="operation(${userInfo.uId},'remove');"
                               class="btn btn-danger "><i
                                    class="fa fa-remove"> 封号</i></a>
                        </c:if>

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
                <a href="${pageContext.request.contextPath}/manage/getUsers.do?pageNum=${pageInfo.pageNum-1}">&laquo;</a>
            </li>
        </c:if>
        <c:forEach var="num" begin="${pageInfo.navigateFirstPage}" end="${pageInfo.navigateLastPage}">
            <li><a href="${pageContext.request.contextPath}/manage/getUsers.do?pageNum=${num}">${num}</a></li>
        </c:forEach>
        <c:if test="${pageInfo.pageNum == pageInfo.pages}">
            <li class="disabled"><a href="javascript:;">&raquo;</a></li>
        </c:if>
        <c:if test="${pageInfo.pageNum != pageInfo.pages}">
            <li>
                <a href="${pageContext.request.contextPath}/manage/getUsers.do?pageNum=${pageInfo.pageNum+1}">&raquo;</a>
            </li>
        </c:if>
    </ul>
</div>

<%--信息提示--%>
<div class="modal fade" id="info" tabindex="-1" role="dialog" aria-labelledby="errLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="errLabel">提示</h4>
            </div>
            <div class="modal-body info">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<script>
    function operation(uId, type) {
        manageUser.removeOrUndoUser(uId, type);
    }


</script>
</body>
</html>
