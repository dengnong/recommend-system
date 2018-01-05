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
    <title>图书</title>
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>
</head>

<body>
<%@ include file="headMenu.jsp"%>
<div class="ui attached message" style="background-color: #F7F6EF">
    <%@ include file="bookSearch.jsp"%>
</div>

<br>
<div class="ui container">
    <div class="ui vertical stripe quote segment aligned row">
        <div class="ui equal width stackable internally celled grid">
            <div class="row">
                <div class="twelve wide column">
                    <div style="float: left;">
                        <div class="ui breadcrumb">
                            <a class="section" href="/book?kind=全部&page=1&sort=default">全部</a>
                            <div class="divider"> / </div>
                            <a class="section" href="/book?kind=小说&page=1&sort=default">小说</a>
                            <div class="divider"> / </div>
                            <a class="section" href="/book?kind=武侠&page=1&sort=default">武侠</a>
                            <div class="divider"> / </div>
                            <a class="section" href="/book?kind=推理&page=1&sort=default">推理</a>
                        </div>
                    </div>
                    <div style="float: right;">
                        <div class="ui breadcrumb">
                            <a class="section" href="/book?kind=${kind}&page=1&sort=rate">评分</a>
                            <div class="divider"> / </div>
                            <a class="section" href="/book?kind=${kind}&page=1&sort=count">热度</a>
                        </div>
                    </div>
                    <%-- 设置当前页的页码 --%>
                    <c:set var="currentPageOffset" value="${bookLists.page + 1}"/>
                    <h5 class="ui horizontal divider header grey header">
                        Page:${currentPageOffset}
                    </h5>
                    <div class="ui divided items">
                        <c:forEach items="${bookLists.pageList}" var="books">
                            <div class="item">
                                <div class="ui tiny image">
                                    <a href="${books.bookUrl}" target="view_window"><img src="${books.bookImg}"></a>
                                </div>
                                <div class="content">
                                    <a href="/book?id=${books.bookId}" target="_Blank" class="header">${books.bookName}</a>
                                    <div class="meta">
                                        <span>${books.bookAuthor}</span>
                                    </div>
                                    <div class="description">
                                        <p>${books.introduction}</p>
                                    </div>
                                    <div class="extra">
                                        <span class="ui tiny orange header">${books.bookRate}</span>
                                        <span>(${books.rateCount}人参与评价)</span>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                        <div style="text-align:center">
                            <c:choose>
                                <c:when test="${bookLists.firstPage}">
                                    首页
                                </c:when>
                                <c:otherwise>
                                    <a href="/book?kind=${kind}&page=1&sort=default">首页</a>
                                </c:otherwise>
                            </c:choose>　　

                            <c:if test="${!bookLists.firstPage}">
                                <a href="/book?kind=${kind}&page=${currentPageOffset - 1}&sort=${sort}">上一页</a>
                            </c:if>　　　

                            <c:if test="${!bookLists.lastPage}">
                                <a href="/book?kind=${kind}&page=${currentPageOffset + 1}&sort=${sort}">下一页</a>
                            </c:if>　　

                            <c:choose>
                                <c:when test="${bookLists.lastPage}">
                                    尾页
                                </c:when>
                                <c:otherwise>
                                    <a href="/book?kind=${kind}&page=${bookLists.pageCount + 1}&sort=${sort}">尾页</a>
                                </c:otherwise>
                            </c:choose>　　
                        </div>

                    </div>
                </div>
                <div class="column">
                    <p>热门搜索</p>
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
