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
    <title>电影</title>
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>
</head>

<body>
<%@ include file="headMenu.jsp"%>
<div class="ui attached message" style="background-color: #F0F3F5">
    <%@ include file="movieSearch.jsp"%>
</div>

<br>
<div class="ui container">
    <div class="ui vertical stripe quote segment aligned row">
        <div class="ui equal width stackable internally celled grid">
            <div class="row">
                <div class="twelve wide column">
                    <div style="float: left;">
                        <div class="ui breadcrumb">
                            <a class="section" href="/movies?kind=全部&page=1&sort=default">全部</a>
                            <div class="divider"> / </div>
                            <a class="section" href="/movies?kind=动作&page=1&sort=default">动作</a>
                            <div class="divider"> / </div>
                            <a class="section" href="/movies?kind=科幻&page=1&sort=default">科幻</a>
                            <div class="divider"> / </div>
                            <a class="section" href="/movies?kind=喜剧&page=1&sort=default">喜剧</a>
                            <div class="divider"> / </div>
                            <a class="section" href="/movies?kind=励志&page=1&sort=default">励志</a>
                            <div class="divider"> / </div>
                            <a class="section" href="/movies?kind=大陆&page=1&sort=default">大陆</a>
                        </div>
                    </div>
                    <div style="float: right;">
                        <div class="ui breadcrumb">
                            <a class="section" href="/movies?kind=${kind}&page=1&sort=rate">评分</a>
                        </div>
                    </div>
                     <%--设置当前页的页码--%>
                    <c:set var="currentPageOffset" value="${moviesLists.number + 1}"/>
                    <h5 class="ui horizontal divider header grey header">
                        Page:${currentPageOffset}
                    </h5>
                    <div class="ui twelve column grid">
                        <c:forEach items="${moviesLists.content}" var="movies">
                        <div class="center aligned four wide column">
                            <div class="ui small bordered image">
                                <a class="ui left corner label">
                                    <strong><i class="ui orange icon">${movies.rate}</i></strong>
                                </a>
                                <img src="${movies.image}">
                            </div>
                            <a href="/movie?id=${movies.movieId}" target="_Blank"><span><h3>${movies.movieName}</h3></span></a>
                        </div>
                        </c:forEach>
                    </div>

                    <br>
                    <div style="text-align:center">
                        <c:choose>
                            <c:when test="${moviesLists.first}">
                                首页
                            </c:when>
                            <c:otherwise>
                                <a href="/movies?kind=${kind}&page=1&sort=default">首页</a>
                            </c:otherwise>
                        </c:choose>　　

                        <c:if test="${!moviesLists.first}">
                            <a href="/movies?kind=${kind}&page=${currentPageOffset - 1}&sort=${sort}">上一页</a>
                        </c:if>　　　

                        <c:if test="${!moviesLists.last}">
                            <a href="/movies?kind=${kind}&page=${currentPageOffset + 1}&sort=${sort}">下一页</a>
                        </c:if>　　

                        <c:choose>
                            <c:when test="${moviesLists.last}">
                                尾页
                            </c:when>
                            <c:otherwise>
                                <a href="/movies?kind=${kind}&page=${moviesLists.totalPages}&sort=${sort}">尾页</a>
                            </c:otherwise>
                        </c:choose>　　
                    </div>
                </div>

                <div class="column">
                    <h4>热门收藏 >></h4>
                    <div class="ui divided items">
                        <c:forEach items="${marksList}" var="markMovie" begin="0" end="9">
                            <div class="item">
                                <div class="content">
                                    <a href="/movie?id=${markMovie.movieId}" target="_Blank" class="header">${markMovie.movieName}</a>
                                    <div class="meta">
                                        <span>导演: ${markMovie.director}</span>
                                    </div>
                                </div>
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
    $('.ui.dropdown')
        .dropdown()
    ;
</script>

</body>
</html>
