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
                    <div class="ui items">
                        <div class="item">
                            <div class="ui small image">
                                <img src="${movieInfo.get("image")}">
                            </div>
                            <div class="content">
                                <div class="header">${movieInfo.get("alt_title")}</div>
                                <div class="description">
                                    <p><span style="color: #6e7176;">导演：</span><span>${movieInfo.get("director")}</span></p>
                                    <p><span style="color: #6e7176;">编剧：</span><span>${movieInfo.get("writer")}</span></p>
                                    <p><span style="color: #6e7176;">国家：</span><span>${movieInfo.get("country")}</span></p>
                                    <p><span style="color: #6e7176;">类型：</span><span>${movieInfo.get("movie_type")}</span></p>
                                    <p><span style="color: #6e7176;">片长：</span><span>${movieInfo.get("movie_duration")}</span></p>
                                    <p><span style="color: #6e7176;">上映时间：</span><span>${movieInfo.get("pubdate")}</span></p>
                                </div>
                            </div>
                            <div class="ui right floated statistic">
                                <div class="value">
                                    <span style="color: #FEA722">${movieInfo.get("average")}</span>
                                </div>
                                <div class="label">
                                    <span style="color: #6E7176">豆瓣评分</span>
                                </div>
                                <br>
                                <div class="value">
                                    <h2>${movieInfo.get("numRaters")}</h2>
                                </div>
                                <div class="label">
                                    <span style="color: #6E7176">评价人数</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="ui horizontal divider">
                        <span style="color: #6E7176">本片相关</span>
                    </div>
                    <div class="ui accordion">
                        <div class="title">
                            <h4><i class="dropdown icon"></i>
                                演员阵容</h4>
                        </div>
                        <div class="content">
                            <pre style="word-wrap: break-word; white-space: pre-line; white-space: -moz-pre-wrap">
                                ${movieInfo.get("cast")}
                            </pre>
                        </div>
                        <div class="title">
                            <h4><i class="dropdown icon"></i>
                                电影简介</h4>
                        </div>
                        <div class="content">
                            <pre style="word-wrap: break-word; white-space: pre-line; white-space: -moz-pre-wrap">
                                ${movieInfo.get("summary")}
                            </pre>
                        </div>
                    </div>

                    <div class="ui horizontal divider">
                        <span style="color: #6E7176">猜您喜欢</span>
                    </div>
                    <br>
                    <div class="ui five column grid">
                        <c:forEach begin="1" end="5">
                            <div class="column">
                                <div class="ui small image">
                                    <img src="https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2506258944.webp">
                                </div>
                                <br>
                                <div style="text-align:center">
                                    <a href="#">
                                        <h3>book's name</h3>
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

</body>
</html>