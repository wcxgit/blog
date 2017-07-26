<%--
  Created by IntelliJ IDEA.
  User: 76339
  Date: 2017/7/24
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>left</title>
    <%@ include file="/common/head.jsp" %>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title text-center">
            模块导航
        </h3>
    </div>
    <div class="panel-body">
        <ul class="list-group">
            <li class="list-group-item"><a href="${pageContext.request.contextPath}/manage/getNavBars.do" target="main">导航栏内容管理</a>
            </li>
            <li class="list-group-item"><a href="${pageContext.request.contextPath}/manage/getUsers.do" target="main">用户管理</a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
