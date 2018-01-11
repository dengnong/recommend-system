<%--
  Created by IntelliJ IDEA.
  User: 54472
  Date: 2017/12/14
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>
    <script src="../../statics/js/home.js"></script>
</head>

<body>

<div class="ui container">

    <div class="ui menu">
        <div class="item">

            <div class="ui right action left icon input">
                <i class="search icon"></i>
                <input type="text" placeholder="Search">
                <div class="ui basic floating dropdown button">
                    <div class="text">图书</div>
                    <i class="dropdown icon"></i>
                    <div class="menu">
                        <div class="item">图书</div>
                        <div class="item">电影</div>
                        <div class="item">美味</div>
                    </div>
                </div>
                <div class="ui dropdown button">Go</div>
            </div>

        </div>

        <div class="center item">
            <%--<button class="ui green basic button">图书</button>--%>
            <a href="#bookSegment"><h3 class="ui olive header">图书</h3></a>
        </div>
        <div class="center item">
            <%--<button class="ui orange basic button">电影</button>--%>
            <a href="#filmSegment"><h3 class="ui pink header">电影</h3></a>
        </div>
        <div class="center item">
            <%--<button class="ui violet basic button">烹饪</button>--%>
            <a href="#foodSegment"><h3 class="ui violet header">美味</h3></a>
        </div>

        <c:choose>
            <c:when test="${!empty sessionScope.userInfo}">
                <div class="right item">
                    <div class="circular ui right pointing icon dropdown button">
                        <i class="icon heart"></i>
                        <div class="menu">
                            <div class="item">
                                <div class="ui red empty circular label"></div>
                                书架
                            </div>
                            <div class="item">
                                <div class="ui blue empty circular label"></div>
                                影墙
                            </div>
                            <div class="item">
                                <div class="ui yellow empty circular label"></div>
                                食谱
                            </div>
                            <div class="divider"></div>
                            <div class="item">
                                <i class="sign out icon"></i>
                                登出
                            </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="right item">
                    <div class="circular ui right pointing icon dropdown button" onclick="toSignIn();">
                        <i class="icon sign in"></i>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="ui info message">
        <i class="close icon"></i>
        <div class="header">
            这就是你想要的吗？
        </div>
        <ul class="list">
            <li>很高兴再次见到你。</li>
            <li>你真的知道了吗？</li>
        </ul>
    </div>
    <div class="ui segment" id="bookSegment">
        <div class="ui vertical stripe quote segment aligned row">
            <div class="ui equal width stackable internally celled grid">
                <div class="row">
                    <div class="twelve wide column">
                        <div class="ui divided items">
                            <c:forEach items="${randomBooks}" var="books" begin="0" end="19">
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
                                <a href="/books?kind=全部&page=1&sort=defalut" target="_Blank" style="text-align:center">
                                    <i class="add icon"></i>
                                    点击查看更多书籍
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="column">
                        <p>热门搜索</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="ui segment" id="filmSegment">
        <div class="ui vertical stripe quote segment aligned row">
            <div class="ui equal width stackable internally celled grid">
                <div class="row">
                    <div class="twelve wide column">
                        <div class="ui three column grid">
                            <c:forEach items="${moviesShowing}" var="movies" begin="0" end="5">
                                <div class="column">
                                    <div class="ui link cards">
                                        <div class="card">
                                            <div class="ui centered image">
                                                <img src="${movies.get("imageLarge")}">
                                            </div>
                                            <div class="center aligned content">
                                                <div class="header">${movies.get("movieName")}</div>
                                                <div class="meta">
                                                    <a href="${movies.get("directorUrl")}">导演: ${movies.get("directorName")}</a>
                                                </div>
                                                <%--<div class="description">--%>
                                                    <%--${movies.get("label")}--%>
                                                <%--</div>--%>
                                            </div>
                                            <div class="extra center aligned content">
                                                <div class="extra">
                                                    <div class="ui star rating"
                                                         data-rating="${movies.get("rating")}"
                                                         data-max-rating="5">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <br>
                        <div style="text-align:center">
                            <a href="/movies?kind=全部&page=1&sort=defalut" target="_Blank" style="text-align:center">
                                <i class="add icon"></i>
                                点击查看更多电影
                            </a>                        </div>
                    </div>
                    <div class="column">
                        <p>热门搜索</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="ui segment" id="foodSegment">
        <div class="ui vertical stripe quote segment aligned row">
            <div class="ui equal width stackable internally celled grid">
                <div class="four wide column">
                    <div class="ui special cards">
                        <div class="card">
                            <div class="blurring dimmable image">
                                <div class="ui dimmer">
                                    <div class="content">
                                        <div class="center">
                                            <div class="ui big animated fade button" tabindex="0">
                                                <div class="visible content">家常菜谱</div>
                                                <div class="hidden content">
                                                    现在就学
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <img src="../../statics/image/jiachangcai.jpg">
                            </div>
                        </div>
                    </div>
                    <div class="ui card">
                        <a class="ui slide masked reveal image" href="#">
                            <img src="http://s1.st.meishij.net/p2/20171215/20171215094351_200.jpg" class="visible content">
                            <img src="http://s1.st.meishij.net/p2/20171213/20171213150931_448.jpg" class="hidden content">
                        </a>
                    </div>
                </div>
                <div class="four wide column">
                    <div class="ui card">
                        <a class="ui slide masked reveal image" href="#">
                            <img src="http://s1.st.meishij.net/p2/20171219/20171219135346_290.jpg" class="visible content">
                            <img src="http://s1.st.meishij.net/p2/20171219/20171219135108_948.jpg" class="hidden content">
                        </a>
                    </div>
                    <div class="ui special cards">
                        <div class="card">
                            <div class="blurring dimmable image">
                                <div class="ui dimmer">
                                    <div class="content">
                                        <div class="center">
                                            <div class="ui big animated fade button" tabindex="0">
                                                <div class="visible content">中华菜系</div>
                                                <div class="hidden content">
                                                    现在就学
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <img src="http://s1.ig.meishij.net/p/20171227/0e18a214b66b1350d8684a6c45c6525a.jpg">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="four wide column">
                    <div class="ui special cards">
                        <div class="card">
                            <div class="blurring dimmable image">
                                <div class="ui dimmer">
                                    <div class="content">
                                        <div class="center">
                                            <div class="ui big animated fade button" tabindex="0">
                                                <div class="visible content">甜品点心</div>
                                                <div class="hidden content">
                                                    现在就学
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <img src="../../statics/image/tianpin.jpg">
                            </div>
                        </div>
                    </div>
                    <div class="ui card">
                        <a class="ui slide masked reveal image" href="#">
                            <img src="http://s1.st.meishij.net/p2/20171211/20171211121401_704.jpg" class="visible content">
                            <img src="http://s1.st.meishij.net/p2/20171213/20171213114839_834.jpg" class="hidden content">
                        </a>
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

<script>
    $('.message .close')
        .on('click', function() {
            $(this)
                .closest('.message')
                .transition('fade')
            ;
        });
</script>

<script>
    $('.ui.rating')
        .rating('disable')
    ;
</script>

<script>
    $('.special.cards .image').dimmer({
        on: 'hover'
    });
</script>

<script>
    $('.shape').shape();
</script>

<script>
    $('.ui.dropdown')
        .dropdown()
    ;
</script>

</body>
</html>
