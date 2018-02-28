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
    <title></title>
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>
    <script src="../../statics/js/movieSearch.js"></script>
</head>

<body>
<div class="ui container">
    <div class="ui stackable inverted divided equal height stackable grid">
        <div class="center aligned row">
            <div class="four wide column">
                <h1 class="ui blue header"><span><i class="icon film"></i>电影</span></h1>
            </div>
            <div class="eight wide column">
                <div class="ui mini fluid action input">
                    <input type="text" id="searchKey" placeholder="搜索..." HaoyuSug="599888033C1C46A3B085C76869A0A23B">
                    <button class="ui icon button" onclick="movieSearch();">
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
</body>
<script charset="UTF-8" src="http://www.92find.com/inteltip.js"></script>
</html>
