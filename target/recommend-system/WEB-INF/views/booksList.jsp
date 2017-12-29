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
    <title>图书</title>
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>
</head>

<body>

<div class="ui attached message" style="background-color: #F7F6EF">
    <div class="ui container">
        <div class="ui stackable inverted divided equal height stackable grid">
            <div class="center aligned row">
                <div class="four wide column">
                    <h1 class="ui brown header"><span><i class="icon book"></i>图书</span></h1>
                </div>
                <div class="eight wide column">
                    <div class="ui mini fluid action input">
                        <input type="text" placeholder="搜索...">
                        <button class="ui icon button">
                            <i class="search icon"></i>
                        </button>
                    </div>
                </div>
                <div class="four wide column">
                    <h4 class="ui header">页脚</h4>
                </div>
            </div>
        </div>
    </div>
</div>

</div>
<br>
<div class="ui container">
        <div class="ui vertical stripe quote segment aligned row">
        <div class="ui equal width stackable internally celled grid">
            <div class="row">
                <div class="twelve wide column">
                    <div style="float: left;">
                        <div class="ui breadcrumb">
                            <a class="section">全部</a>
                            <div class="divider"> / </div>
                            <a class="section">小说</a>
                            <div class="divider"> / </div>
                            <a class="section">武侠</a>
                            <div class="divider"> / </div>
                            <a class="section">推理</a>
                        </div>
                    </div>
                    <div style="float: right;">
                        <div class="ui breadcrumb">
                            <a class="section">评分</a>
                            <div class="divider"> / </div>
                            <a class="section">热度</a>
                        </div>
                    </div>
                    <%-- 设置当前页的页码 --%>
                    <c:set var="currentPageOffset" value="${bookLists.number + 1}"/>
                    <h5 class="ui horizontal divider header grey header">
                        Page:${currentPageOffset}
                    </h5>
                    <div class="ui divided items">
                        <c:forEach items="${bookLists.content}" var="books">
                            <div class="item">
                                <div class="ui tiny image">
                                    <a href="${books.bookUrl}" target="view_window"><img src="${books.bookImg}"></a>
                                </div>
                                <div class="content">
                                    <a href="${books.bookUrl}" class="header">${books.bookName}</a>
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
                                <c:when test="${bookLists.first}">
                                    首页
                                </c:when>
                                <c:otherwise>
                                    <a href="/bookslist/${kind}/1">首页</a>
                                </c:otherwise>
                            </c:choose>　　

                            <c:if test="${bookLists.hasPrevious()}">
                                <a href="/bookslist/${kind}/${currentPageOffset - 1}">上一页</a>
                            </c:if>　　　

                            <c:if test="${bookLists.hasNext()}">
                                <a href="/bookslist/${kind}/${currentPageOffset + 1}">下一页</a>
                            </c:if>　　

                            <c:choose>
                                <c:when test="${bookLists.last}">
                                    尾页
                                </c:when>
                                <c:otherwise>
                                    <a href="/bookslist/${kind}/${bookLists.totalPages}">尾页</a>
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
</body>
</html>
