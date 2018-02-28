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
    <title>电影搜索</title>
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>
</head>

<body>
<%@ include file="headMenu.jsp"%>
<div class="ui attached message" style="background-color: #F7F6EF">
    <%@ include file="movieSearch.jsp"%>
</div>

<br>
<div class="ui container">
    <div class="ui vertical stripe quote segment aligned row">
        <div class="ui equal width stackable internally celled grid">
            <div class="row">
                <div class="twelve wide column">
                    <h5 class="ui horizontal divider header grey header">
                        本站结果
                    </h5>
                    <div class="ui divided items">
                        <c:forEach items="${movieLists.content}" var="movies">
                            <div class="item">
                                <div class="ui tiny image">
                                    <a href="${movies.url}" target="view_window"><img src="${movies.image}"></a>
                                </div>
                                <div class="content">
                                    <a href="/movie?id=${movies.movieId}" target="_Blank" class="header">${movies.movieName}</a>
                                    <div class="meta">
                                        <p>类型：${movies.kind}</p>
                                    </div>
                                    <div class="description">
                                        <p>导演：${movies.director}</p>
                                        <p>主演：${movies.actors}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="column">
                    <h5 class="ui horizontal divider header grey header">
                        网络结果
                    </h5>
                    <div class="ui divided items">
                        <c:forEach items="${doubanLists}" var="doubanMovies" begin="0" end="9">
                            <div class="item">
                                <div class="content">
                                    <a href="${doubanMovies.get("alt")}" target="_Blank" class="header">${doubanMovies.get("title")}</a>
                                    <div class="meta">
                                        <span>导演：${doubanMovies.get("director")}</span>
                                    </div>
                                    <div class="description">
                                        <span>类型：${doubanMovies.get("genres")}</span>
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
