<%--
  Created by IntelliJ IDEA.
  User: 76339
  Date: 2017/7/23
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <%@ include file="/common/head.jsp" %>
</head>
<body>
<%@include file="/common/navbar.jsp" %>
<div class="container-center">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
            <li><a href="javascript:;">登录</a></li>
        </ol>
        <div class="jumbotron">
            <div class="container-center">
                <form id="form" class="form-horizontal " role="form">
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <label for="username" class="col-sm-2 control-label">用户名 <span
                                class="text-danger">*</span></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="username" name="uName"
                                   style="width: 246px;display: inline-block;" placeholder="请输用户名">
                            <span id="name" style="color:red;"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <label for="password" class="col-sm-2 control-label">密码 <span
                                class="text-danger">*</span></label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="password" name="uPassword"
                                   style="width: 246px;display: inline-block;" placeholder="请输入密码">
                            <span id="word" style="color:red;"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <label for="code" class="col-sm-2 control-label">验证码 <span class="text-danger">*</span></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="code" name="code"
                                   style="width: 122px;display: inline-block;" placeholder="请输入验证码">
                            <img src="${pageContext.request.contextPath}/getCheckImage" onclick="change();" id="myimg"
                                 style="cursor: pointer;"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-offset-2 col-sm-4">

                            <button type="button" id="log" class="btn btn-default">登录</button>
                            <a href="" style="margin-left: 5px;">忘记密码</a>
                            <span class="label label-danger" id="test" style="margin-left: 5px;font-size: 20px;"></span>
                            <span style="color: red;" id="chkLogin"></span>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="/common/js.jsp" %>
<script src="${pageContext.request.contextPath}/js/user.js"></script>
<script>
    function change() {
        login.toGetCheckImage($("#myimg"));
    }

    $("#log").click(function () {
        login.login();
    });
</script>
</body>
</html>
