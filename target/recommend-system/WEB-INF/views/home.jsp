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
                        <div class="item">烹饪</div>
                    </div>
                </div>
                <div class="ui button">Go</div>
            </div>

        </div>

        <div class="center item">
            <button class="ui green basic button">图书</button>
        </div>
        <div class="center item">
            <button class="ui orange basic button">电影</button>
        </div>
        <div class="center item">
            <button class="ui violet basic button">烹饪</button>
        </div>

        <div class="right item">
            <button class="circular ui icon button">
                <i class="icon settings"></i>
            </button>
        </div>
    </div>

    <div class="ui vertical stripe quote segment aligned row">
        <div class="ui equal width stackable internally celled grid">
            <div class="center aligned row">
                <div class="column">
                    <p>11111111111</p>
                </div>
                <div class="column">
                    <p>22222222222</p>
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
