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
    <title>${bookInfo.get("title")}</title>
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>
    <script src="../../statics/js/mark.js"></script>
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
                    <div class="ui items">
                        <div class="item">
                            <div class="ui small image">
                                <img src="${bookInfo.get("image")}">
                            </div>
                            <div class="content">
                                <div class="header">${bookInfo.get("title")}</div>
                                <div class="description">
                                    <p><span style="color: #6e7176;">作者：</span><span>${bookInfo.get("author").replace("[", "").replace("]","").replace("\"","")}</span></p>
                                    <p><span style="color: #6e7176;">出版社：</span><span>${bookInfo.get("publisher")}</span></p>
                                    <p><span style="color: #6e7176;">出版年：</span><span>${bookInfo.get("pubdate")}</span></p>
                                    <p><span style="color: #6e7176;">页数：</span><span>${bookInfo.get("pages")}</span></p>
                                    <p><span style="color: #6e7176;">定价：</span><span>${bookInfo.get("price")}</span></p>
                                    <p><span style="color: #6e7176;">ISBN：</span><span>${bookInfo.get("isbn13")}</span></p>
                                    <p><span style="color: #6e7176;">丛书：</span><span>${bookInfo.get("series_title")}</span></p>
                                </div>
                            </div>
                            <div class="ui right floated statistic">
                                <div class="value">
                                    <span style="color: #FEA722">${bookInfo.get("average")}</span>
                                </div>
                                <div class="label">
                                    <span style="color: #6E7176">豆瓣评分</span>
                                </div>
                                <br>
                                <div class="value">
                                    <h2>${bookInfo.get("numRaters")}</h2>
                                </div>
                                <div class="label">
                                    <span style="color: #6E7176">评价人数</span>
                                </div>
                                <%-- 收藏标记 --%>
                                <br><br>
                                <input type="hidden" id="markInit" name="markInit" value="${marks}">
                                <input type="hidden" id="type" name="type" value="book">
                                <input type="hidden" id="itemId" name="bookId" value="${bookId}">
                                <input type="hidden" id="userInfo" name="userInfo" value="${sessionScope.get("userInfo")}">
                                <div class="ui massive heart rating" id="markTag" data-max-rating="1" onclick="markChange();"></div>
                                <div class="label">
                                    <span style="color: #6E7176">like</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="ui horizontal divider">
                        <span style="color: #6E7176">本书相关</span>
                    </div>
                    <div class="ui accordion">
                        <div class="title">
                            <h4><i class="dropdown icon"></i>
                                内容简介</h4>
                        </div>
                        <div class="content">
                            <pre style="word-wrap: break-word; white-space: pre-line; white-space: -moz-pre-wrap">
                                ${bookInfo.get("summary")}
                            </pre>
                        </div>
                        <div class="title">
                            <h4><i class="dropdown icon"></i>
                                作者简介</h4>
                        </div>
                        <div class="content">
                            <pre style="word-wrap: break-word; white-space: pre-line; white-space: -moz-pre-wrap">
                                ${bookInfo.get("author_intro")}
                            </pre>
                        </div>
                    </div>

                    <div class="ui horizontal divider">
                        <span style="color: #6E7176">猜您喜欢</span>
                    </div>
                    <br>
                    <div class="ui five column grid">
                        <c:forEach items="${recommendBook}" var="recommendBooks">
                            <div class="column">
                                <div class="ui small image">
                                    <img class="ui centered image" src="${recommendBooks.bookImg}">
                                </div>
                                <br>
                                <div style="text-align:center">
                                    <a href="/book?id=${recommendBooks.bookId}" target="_Blank">
                                        <h4>${recommendBooks.bookName}</h4>
                                    </a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                </div>

                <div class="column">
                    <div style="background-color: #f4f4f4">
                        111
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

<script>
    var init = 0;
    var flag = $('#markInit').val();
    if(flag === "true") {
        init = 1;
        $('#markTag')
            .rating({
                initialRating: 1,
                maxRating: 1
            })
        ;
    } else {
        $('#markTag')
            .rating({
                initialRating: 0,
                maxRating: 1
            })
        ;
    }
</script>

<script>
    function markChange() {
        if(init === 1) {
            mark(init);
            init = 0;
        } else {
            mark(init);
            init = 1;
        }
    }
</script>

</body>
</html>
