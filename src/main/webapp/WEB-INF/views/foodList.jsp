<%--
  Created by IntelliJ IDEA.
  User: 54472
  Date: 2017/12/14
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>美食烹饪</title>
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>
</head>

<body>
<%@ include file="headMenu.jsp"%>
<div class="ui attached message" style="background-color: #EDF4EB">
    <%@ include file="foodSearch.jsp"%>
</div>

<br>
<div class="ui container">
    <div class="ui vertical stripe quote segment aligned row">
        <div class="ui equal width stackable internally celled grid">
            <div class="row">
                <div class="four wide column">
                    <div class="ui fluid vertical pointing menu">
                        <a class="item active">
                            所有菜品
                        </a>
                        <a class="item">
                            中华菜系
                        </a>
                        <a class="item">
                            家常菜
                        </a>
                        <a class="item">
                            甜品
                        </a>
                        <a class="item">
                            人气佳肴
                        </a>
                    </div>
                    <div class="ui styled fluid accordion">
                        <div class="active title">
                            <i class="dropdown icon"></i>
                            烹饪难度
                        </div>
                        <div class="active content">
                            <div class="ui middle aligned animated selection list">
                                <div class="item">
                                    <img class="ui avatar image" src="/statics/image/level1.png">
                                    <div class="content">
                                        <div class="header">新手上路</div>
                                    </div>
                                </div>
                                <div class="item">
                                    <img class="ui avatar image" src="/statics/image/level2.png">
                                    <div class="content">
                                        <div class="header">孰能生巧</div>
                                    </div>
                                </div>
                                <div class="item">
                                    <img class="ui avatar image" src="/statics/image/level3.png">
                                    <div class="content">
                                        <div class="header">技艺高超</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="title">
                            <i class="dropdown icon"></i>
                            烹饪方式
                        </div>
                        <div class="content">
                            <div class="ui horizontal link list">
                                <p></p>
                                <a class="ui circular label">爆</a>
                                <a class="ui circular label">炒</a>
                                <a class="ui circular label">炖</a>
                                <a class="ui circular label">干煸</a>
                                <a class="ui circular label">干锅</a>
                                <a class="ui circular label">拌</a>
                                <a class="ui circular label">煲</a>
                                <a class="ui circular label">煎</a>
                                <a class="ui circular label">酱</a>
                                <a class="ui circular label">烤</a>
                                <a class="ui circular label">烙</a>
                                <a class="ui circular label">烧</a>
                                <a class="ui circular label">炸</a>
                                <a class="ui circular label">蒸</a>
                                <a class="ui circular label">煮</a>
                            </div>
                        </div>
                        <div class="title">
                            <i class="dropdown icon"></i>
                            口味
                        </div>
                        <div class="content">
                            <div class="ui horizontal link list">
                                <p></p>
                                <a class="ui circular label">葱香味</a>
                                <a class="ui circular label">豆瓣味</a>
                                <a class="ui circular label">果味</a>
                                <a class="ui circular label">黑椒味</a>
                                <a class="ui circular label">家常味</a>
                                <a class="ui circular label">酱香味</a>
                                <a class="ui circular label">椒麻味</a>
                                <a class="ui circular label">麻酱味</a>
                                <a class="ui circular label">麻辣味</a>
                                <a class="ui circular label">奶香味</a>
                                <a class="ui circular label">甜味</a>
                                <a class="ui circular label">五香味</a>
                                <a class="ui circular label">咸香味</a>
                                <a class="ui circular label">香辣味</a>
                                <a class="ui circular label">鱼香味</a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="twelve wide column">
                    <div class="ui three column grid">
                        <c:forEach begin="1" end="3">
                            <div class="column">
                                <div class="ui fluid image">
                                    <a class="ui teal right ribbon label">规格</a>
                                    <img src="http://images.meishij.net/p/20120524/4d40c4b26ff9ea3b96b1f8c27cf433a4_150x150.jpg">
                                </div>
                                <a class="ui slide masked reveal image" href="#">
                                    <div class="visible content">
                                        <div style="background-color: #F3F2F0">
                                            <h3>五香牛肉</h3>
                                            <p>人气：999</p>
                                        </div>
                                    </div>
                                    <div class="hidden content">
                                        222
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp" %>

</div>

<script>
    $('.ui.accordion')
        .accordion()
    ;
</script>

</body>
</html>
