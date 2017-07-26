<%--
  Created by IntelliJ IDEA.
  User: 76339
  Date: 2017/7/23
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <%@ include file="/common/head.jsp" %>
</head>
<body>
<%@include file="/common/navbar.jsp" %>
<div class="container-center">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
            <li><a href="javascript:;">注册</a></li>
        </ol>
        <div class="jumbotron">
            <div class="container-center">
                <form id="form" class="form-horizontal " role="form">
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <label for="username" class="col-sm-2 control-label">用户名 <span
                                class="text-danger">*</span></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="username" name="uName" placeholder="请输用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <label class="col-sm-2 control-label">性别 <span
                                class="text-danger">*</span></label>
                        <label class="checkbox-inline">
                            <input type="radio" name="uSex" value="男" checked>男
                        </label>
                        <label class="checkbox-inline">
                            <input type="radio" name="uSex" value="女">女
                        </label>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <label for="email" class="col-sm-2 control-label">邮箱 <span
                                class="text-danger">*</span></label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="email" name="uEmail" placeholder="请输入邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <label for="password" class="col-sm-2 control-label">密码 <span
                                class="text-danger">*</span></label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="password" name="uPassword"
                                   placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <label for="rePassword" class="col-sm-2 control-label">确认密码 <span
                                class="text-danger">*</span></label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="rePassword" name="rePassword"
                                   placeholder="请再次输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-offset-2 col-sm-4">
                            <button type="button" id="register" class="btn btn-primary">提交注册</button>
                            <span class="label label-danger" id="test" style="margin-left: 12px;"></span>
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
    $("#register").click(function () {
        regist.register();
    });
</script>
</body>
</html>
