<%--
  Created by IntelliJ IDEA.
  User: 54472
  Date: 2017/12/14
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>

</head>

<body>
<div class="ui mini attached inverted menu" style="background-color: #515151">
    <a class="item">
        首页
    </a>
    <a class="item">
        图书
    </a>
    <a class="item">
        电影
    </a>
    <a class="item">
        美食
    </a>
    <div class="right menu">
        <c:choose>
            <c:when test="${!empty sessionScope.userInfo}">
                <a class="item">
                    书架
                </a>
                <a class="item">
                    影墙
                </a>
                <a class="item">
                    食谱
                </a>

                <div class="ui dropdown item">
                    ${sessionScope.userInfo}
                    <div class="menu">
                        <div class="item">注销登录</div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <a class="item">
                    书架
                </a>
                <a class="item">
                    影墙
                </a>
                <a class="item">
                    食谱
                </a>
                <a class="item">
                    亲，请登录
                </a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
