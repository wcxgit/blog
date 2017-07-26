<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/tag.jsp" %>
<%@include file="/common/js.jsp" %>
<div class="topBar">
    <div class="container-center">
        <c:if test="${sessionScope.user == null}">
            <a id="regist" href="javascript:;"><i class="fa fa-user"> 注册</i></a>
            <a id="login" href="javascript:;"><i class="fa fa-sign-in"> 登录</i></a>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <a id="detail" href="javascript:;"><i class="fa fa-user-circle-o"> 欢迎您: <font
                    color="black">${user.uName}</font></i></a>
              <a id="signOut" href="javascript:void(0);"><i class="fa fa-sign-out"> 注销</i></a>
        </c:if>
    </div>
</div>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-center">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">blog</a>
            </div>
            <div>
                <ul class="nav navbar-nav">

                </ul>
            </div>
        </div>
    </div>
</nav>
<script>
    $(function () {
        initBar.init();
    });

    $("#login").click(function () {
        login.toLogin();
    });

    $("#regist").click(function () {
        regist.init();
    });

    $("#signOut").click(function () {

    });

</script>