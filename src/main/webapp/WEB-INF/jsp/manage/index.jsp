<%--
  Created by IntelliJ IDEA.
  User: 76339
  Date: 2017/7/24
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>后台管理</title>
<frameset rows="15%,*">
    <frame src="${pageContext.request.contextPath}/forward/top.do" noresize="noresize" scrolling="no" frameborder="no"/>
    <frameset cols="15%,*">
        <frame src="${pageContext.request.contextPath}/forward/left.do" noresize="noresize" frameborder="no"/>
        <frame src="${pageContext.request.contextPath}/forward/main.do" noresize="noresize" frameborder="no"
               name="main"/>
    </frameset>
</frameset>
</html>
