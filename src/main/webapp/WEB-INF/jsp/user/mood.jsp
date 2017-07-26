<%--
  Created by IntelliJ IDEA.
  User: 76339
  Date: 2017/7/25
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>心情物语</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mood.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fileinput/css/fileinput.min.css">
    <%@include file="/common/head.jsp" %>
    <%@include file="/common/js.jsp" %>

</head>
<body>
<%@include file="/common/navbar.jsp" %>
<div class="container-center">
    <div class="row">
        <div class="col-sm-8">
            <div class="panel panel-info ">
                <div class="panel-heading">
                    <h3 class="panel-title">开始记录心情吧🙂</h3>
                </div>
                <div class="panel-body">
                    <form role="form" id="form">
                        <div class="form-group">
                            <div class="comment">
                                <div class="com_form">
                                    <textarea class="form-control" placeholder="记录此刻心情,我会为你珍藏哦" id="saytext"
                                              name="cContent" rows="3"></textarea>
                                    <p class="add"><a class="btn btn-default emotion"><i class="fa fa-meh-o">
                                        添加表情</i></a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="panel-footer clearfix">
                    <input type="button" id="sub_btn" class="btn btn-primary pull-right" value="帮我珍藏心情"/>
                </div>
            </div>

            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">您以前的心情在这里哦</h3>
                </div>
                <div class="panel-body">
                    <div class="well well-sm">
                        <ul class="list-group mood-list">
                            <li class="list-group-item">
                                免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册免费域名注册
                                <span class="label label-info pull-right">2012年3月25日</span></li>
                            <li class="list-group-item">免费 Window 空间托管</li>
                            <li class="list-group-item">图像的数量</li>
                            <li class="list-group-item">24*7 支持</li>
                            <li class="list-group-item">每年更新成本</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <%--最近心情--%>
        <div class="panel panel-info col-sm-4">
            <div class="panel-heading">
                <h3 class="panel-title">最近心情</h3>
            </div>
            <div class="panel-body">
                <div class="well well-sm">
                    <ul class="list-group">
                        <li class="list-group-item">
                            免费 Window 空间托管
                            <span class="label label-info pull-right">2012年3月25日</span></li>
                        <li class="list-group-item">免费 Window 空间托管</li>
                        <li class="list-group-item">图像的数量</li>
                        <li class="list-group-item">24*7 支持</li>
                        <li class="list-group-item">每年更新成本</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<%--信息提示--%>
<div class="modal fade" id="info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">提示</h4>
            </div>
            <div class="modal-body"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<script src="${pageContext.request.contextPath}/qqFace/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/qqFace/js/jquery.qqFace.js"></script>
<script src="${pageContext.request.contextPath}/js/user.js"></script>
<script>
    //表情插件
    $(function () {
        $('.emotion').qqFace({
            id: 'facebox',
            assign: 'saytext',
            path: '/qqFace/arclist/'	//表情存放的路径
        });
    });

    //提交信息信息
    $("#sub_btn").click(function () {
        mood.saveMood();
    });
</script>
</body>
</html>
