<%--
  Created by IntelliJ IDEA.
  User: 54472
  Date: 2017/12/14
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
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
            <h3 class="ui olive header">图书</h3>
        </div>
        <div class="center item">
            <%--<button class="ui orange basic button">电影</button>--%>
                <h3 class="ui pink header">电影</h3>
        </div>
        <div class="center item">
            <%--<button class="ui violet basic button">烹饪</button>--%>
                <h3 class="ui violet header">美味</h3>
        </div>

        <div class="right item">
            <button class="circular ui icon button">
                <i class="icon settings"></i>
            </button>
        </div>
    </div>

    <div class="ui piled segment">
        <h4 class="ui header">A header</h4>
        <p>Te eum doming eirmod, nominati pertinacia argumentum ad his. Ex eam alia facete scriptorem, est autem aliquip detraxit at. Usu ocurreret referrentur at, cu epicurei appellantur vix. Cum ea laoreet recteque electram, eos choro alterum definiebas in. Vim dolorum definiebas an. Mei ex natum rebum iisque.</p>
        <p>Audiam quaerendum eu sea, pro omittam definiebas ex. Te est latine definitiones. Quot wisi nulla ex duo. Vis sint solet expetenda ne, his te phaedrum referrentur consectetuer. Id vix fabulas oporteat, ei quo vide phaedrum, vim vivendum maiestatis in.</p>
        <p>Eu quo homero blandit intellegebat. Incorrupte consequuntur mei id. Mei ut facer dolores adolescens, no illum aperiri quo, usu odio brute at. Qui te porro electram, ea dico facete utroque quo. Populo quodsi te eam, wisi everti eos ex, eum elitr altera utamur at. Quodsi convenire mnesarchum eu per, quas minimum postulant per id.</p>
    </div>

    <div class="ui vertical stripe quote segment aligned row">
        <div class="ui equal width stackable internally celled grid">
            <div class="center aligned row">
                <div class="twelve wide column">
                    <p>图书</p>
                </div>
                <div class="column">
                    <p>热门搜索</p>
                </div>
            </div>
        </div>
    </div>

    <div class="ui vertical stripe quote segment aligned row">
        <div class="ui equal width stackable internally celled grid">
            <div class="center aligned row">
                <div class="twelve wide column">
                    <p>电影</p>
                </div>
                <div class="column">
                    <p>热门搜索</p>
                </div>
            </div>
        </div>
    </div>

    <div class="ui vertical stripe quote segment aligned row">
        <div class="ui equal width stackable internally celled grid">
            <div class="center aligned row">
                <div class="twelve wide column">
                    <p>美味</p>
                </div>
                <div class="column">
                    <p>热门搜索</p>
                </div>
            </div>
        </div>
    </div>

</div>

<script>
    $('.ui.dropdown')
        .dropdown()
    ;
</script>

</body>
</html>
