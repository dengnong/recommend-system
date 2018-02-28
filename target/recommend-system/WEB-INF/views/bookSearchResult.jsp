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
                    <%-- 设置当前页的页码 --%>
                    <c:set var="currentPageOffset" value="${bookLists.number + 1}"/>
                    <h5 class="ui horizontal divider header grey header">
                        本站结果
                    </h5>
                    <div class="ui divided items">
                        <c:forEach items="${bookLists.content}" var="books">
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
                    </div>
                </div>
                <div class="column">
                    <h5 class="ui horizontal divider header grey header">
                        网络结果
                    </h5>
                    <div class="ui divided items">
                        <c:forEach items="${doubanLists}" var="doubanBooks" begin="0" end="9">
                            <div class="item">
                                <div class="content">
                                    <a href="${doubanBooks.get("alt")}" target="_Blank" class="header">${doubanBooks.get("title")}</a>
                                    <div class="meta">
                                        <span>作者：${doubanBooks.get("author")}</span>
                                    </div>
                                    <div class="description">
                                        <p>出版：${doubanBooks.get("publisher")}</p>
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
