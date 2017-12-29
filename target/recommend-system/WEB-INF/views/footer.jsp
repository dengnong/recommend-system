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
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>
</head>

<body>
<h4 class="ui horizontal divider header grey header">END</h4>
<div class="ui container">
    <div class="ui stackable inverted divided equal height stackable grid">
        <div class="center aligned row">
            <div class="four wide column">
                <h4 class="ui header">关于</h4>
            </div>
            <div class="four wide column">
                <h4 class="ui header">服务</h4>
            </div>
            <div class="four wide column">
                <h4 class="ui header">页脚</h4>
            </div>
            <div class="four wide column">
                <button class="circular ui big icon button" onclick="toTop();">
                    <i class="icon arrow up"></i>
                </button>
            </div>
        </div>
    </div>
</div>

<script>
    var timer = null;
    function toTop(){
        cancelAnimationFrame(timer);
        timer = requestAnimationFrame(function fn(){
            var oTop = document.body.scrollTop || document.documentElement.scrollTop;
            if(oTop > 0){
                scrollTo(0,oTop-200);
                timer = requestAnimationFrame(fn);
            }else{
                cancelAnimationFrame(timer);
            }
        });
    }
</script>

</body>
</html>
