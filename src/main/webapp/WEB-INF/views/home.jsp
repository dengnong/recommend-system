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
                <div class="ui button">Go</div>
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

        <div class="right item">
            <button class="circular ui icon button">
                <i class="icon settings"></i>
            </button>
        </div>
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
                <div class="aligned row">
                    <div class="twelve wide column">
                        <%--<p>电影</p>--%>
                        <div class="ui divided items">
                            <c:forEach begin="1" end="5">
                                <div class="item">
                                    <div class="ui tiny image">
                                        <img src="../../statics/image/book.jpg">
                                    </div>
                                    <div class="content">
                                        <a class="header">青春万重山</a>
                                        <div class="meta">
                                            <span>献给毕业生的礼物</span>
                                        </div>
                                        <div class="description">
                                            <p></p>
                                        </div>
                                        <div class="extra">
                                            “我”在迪士尼乐园陪孩子度假，突然接到一位同学的婚讯电话。远离集体生活多年的“我”念起大学时代的美好时光。过山车从百米高空坠落，
                                            在失重的虚慌中，“我”体味到时光飞逝的悸痛。蓦然回首，热泪盈眶，记忆的碎片在眼前一一浮现。
                                            大学四年，从入校到毕业，“我”历经踌躇满志，困顿迷茫，至落寞离场。“我”遇到的一些人，
                                            经历的一些事从入校到毕业，“我”历经踌躇满志，困顿迷茫，至落寞离场。“我”遇到的一些人，
                                            经历的一些事
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
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
                <div class="center aligned row">
                    <div class="twelve wide column">
                        <div class="ui three column grid">
                            <c:forEach begin="1" end="6">
                                <div class="column">
                                    <div class="ui link cards">
                                        <div class="card">
                                            <div class="ui centered image">
                                                <img src="https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2507566212.webp">
                                            </div>
                                            <div class="content">
                                                <div class="header">奇门遁甲</div>
                                                <div class="meta">
                                                    <a>导演: 袁和平</a>
                                                </div>
                                                <div class="description">
                                                    动作 / 奇幻
                                                </div>
                                            </div>
                                            <div class="extra content">
                                                <div class="extra">
                                                    <div class="ui star rating" data-rating="3"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
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
                                                <div class="visible content">红烧肉</div>
                                                <div class="hidden content">
                                                    现在就学
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <img src="../../statics/image/food.jpg">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="four wide column">
                    <div class="ui card">
                        <div class="ui slide masked reveal image">
                            <img src="../../statics/image/food.jpg" class="visible content">
                            <img src="../../statics/image/food.jpg" class="hidden content">
                        </div>
                    </div>
                </div>
                <div class="four wide column">
                    <div class="four wide column">
                        <div class="ui special cards">
                            <div class="card">
                                <div class="blurring dimmable image">
                                    <div class="ui dimmer">
                                        <div class="content">
                                            <div class="center">
                                                <div class="ui big animated fade button" tabindex="0">
                                                    <div class="visible content">红烧肉</div>
                                                    <div class="hidden content">
                                                        现在就学
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <img src="../../statics/image/food.jpg">
                                </div>
                            </div>
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

</body>
</html>
