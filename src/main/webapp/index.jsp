<%--
  Created by IntelliJ IDEA.
  User: 76339
  Date: 2017/7/23
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <%@ include file="common/head.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<style>

</style>
<body>

<%@include file="common/navbar.jsp" %>

<div id="myCarousel" class="carousel slide container-center">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0"
            class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner" style="height: 300px;">
        <div class="item active">
            <img src="${pageContext.request.contextPath}/imgs/test/05d922a0b0c5518dba4e5d295dccf269.jpg" width="100%" height="100%" alt="First slide">

            <div class="carousel-caption">标题 1</div>
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/imgs/test/599fcefbadff1a87cc5db85f97390422.jpg" alt="Second slide">
            <div class="carousel-caption">标题 2</div>
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/imgs/test/822bf40142d5efa3652a19c077fd9210.jpg" alt="Third slide">
            <div class="carousel-caption">标题 3</div>
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="carousel-control left" href="#myCarousel"
       data-slide="prev">&lsaquo;</a>
    <a class="carousel-control right" href="#myCarousel"
       data-slide="next">&rsaquo;</a>
    <!-- 控制按钮 -->
    <%--<div style="text-align:center;">
        <input type="button" class="btn start-slide" value="Start">
        <input type="button" class="btn pause-slide" value="Pause">
        <input type="button" class="btn prev-slide" value="Previous Slide">
        <input type="button" class="btn next-slide" value="Next Slide">
        <input type="button" class="btn slide-one" value="Slide 1">
        <input type="button" class="btn slide-two" value="Slide 2">
        <input type="button" class="btn slide-three" value="Slide 3">
    </div>--%>
</div>

<div class="container-center list-container">
    <div class="row">
        <div class="left-content col-xs-9 ">
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="left-img">
                        <a href="#">
                            <img class="img-rounded" src="${pageContext.request.contextPath}/imgs/test/599fcefbadff1a87cc5db85f97390422.jpg" width="200"
                                 height="150">
                        </a>
                    </div>
                    <div class="right-text">
                        <div class="text">
                            <a href="#"><h3>生死狙击第二季 全集Shooter迅雷下载</h3></a>
                            <span>导演: 西蒙·赛伦·琼斯 主演: 瑞恩·菲利普 / 珊特尔·范圣滕 / 辛希亚·阿戴-罗宾森 类型: 剧情 / 动作 制片国家/地区: 美国 语言: 英语 首播: 2017-07-18(美国)
                    季数:...</span>
                        </div>
                        <div class="msg">
                            <span> <i class="fa fa-calendar"> 17年03月20日</i></span>
                            <span> <i class="fa fa-eye"> 12</i></span>
                            <span> <i class="fa fa-comment"> 23</i></span>
                        </div>
                    </div>

                </li>
            </ul>


            <ul class="list-group">
                <li class="list-group-item">
                    <div class="left-img">
                        <a href="#">
                            <img class="img-rounded" src="${pageContext.request.contextPath}/imgs/test/599fcefbadff1a87cc5db85f97390422.jpg" width="200"
                                 height="150">
                        </a>
                    </div>
                    <div class="right-text">
                        <div class="text">
                            <a href="#"><h3>生死狙击第二季 全集Shooter迅雷下载</h3></a>
                            <span>导演: 西蒙·赛伦·琼斯 主演: 瑞恩·菲利普 / 珊特尔·范圣滕 / 辛希亚·阿戴-罗宾森 类型: 剧情 / 动作 制片国家/地区: 美国 语言: 英语 首播: 2017-07-18(美国)
                    季数:...</span>
                        </div>
                        <div class="msg">
                            <span><i class="fa fa-calendar">17年03月20日</i></span>
                            <span><i class="fa fa-eye">12</i></span>
                            <span><i class="fa fa-comment">23</i></span>
                        </div>
                    </div>

                </li>
            </ul>

            <ul class="pager">
                <li class="previous"><a href="#">&larr; Older</a></li>
                <li class="next"><a href="#">Newer &rarr;</a></li>
            </ul>
        </div>


        <div class="right-content-top col-xs-3">
            <ul class="list-group">
                <li class="list-group-item"><font color="red" size="4">最新文章</font> </li>
                <li class="list-group-item clearfix">
                    <div class="pull-left"><a href="">格林童话</a></div>
                    <div class="pull-right "><a href="javascript:void(0);">2012-12-12</a></div>
                </li>
                <li class="list-group-item clearfix">
                    <div class="pull-right"><a href="">>>>查看更多</a></div>
                </li>
            </ul>
        </div>

        <div class="right-content-top col-xs-3">
            <ul class="list-group">
                <li class="list-group-item"><font color="red" size="4">热门文章</font> </li>
                <li class="list-group-item clearfix">
                    <div class="pull-left"><a href="">格林童话</a></div>
                    <div class="pull-right "><a href="javascript:void(0);">2012-12-12</a></div>
                </li>
                <li class="list-group-item clearfix">
                    <div class="pull-right"><a href="">>>>查看更多</a></div>
                </li>
            </ul>
        </div>

    </div>
    <%--<div class="well well-lg">
        <div class="pull-left"><a href="#"><img src="imgs/test/599fcefbadff1a87cc5db85f97390422.jpg" width="150"
                                                height="150"></a></div>
        <div class="pull-right"><h4>生死狙击第二季 全集Shooter迅雷下载</h4></div>

    </div>--%>
</div>
<%@include file="common/footer.jsp" %>
<%@include file="common/js.jsp" %>
</body>
</html>
