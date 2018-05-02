<%--
  Created by IntelliJ IDEA.
  User: 54472
  Date: 2017/11/12
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>
    <script src="../../statics/js/login.js"></script>

    <style type="text/css">
        .ui.card {
             height: 270px;
        }

        .ui.stacked.segment {
            height: 300px;
        }

        .ui.raised.segment {
            background-color: #f9f9f9;
            width: 720px;
            position: absolute;
            left: 50%;
            top: 50%;
            margin: -220px 0 0 -360px;
            font-family: 'microsoft yahei' ,Arial,sans-serif;
        }

        body {
            background-image: url("../../statics/image/login.jpg");
            background-size: cover;
        }
    </style>

</head>

<body>
<div class="ui raised segment">
    <div class="ui breadcrumb">
        <div class="section">LOGIN</div>
        <div class="divider"> / </div>
        <a class="active section" onclick="register();">REGISTER</a>
    </div>
    <div class="ui two column grid basic segment">
        <div class="column">
            <div class="ui blue stacked segment">
                <form class="ui form" id="form" name="form">
                    <div class="field">
                        <lebel>your account</lebel>
                        <div class="ui left icon input">
                            <input type="text" name="account" id="account">
                            <i class="user icon"></i>
                        </div>
                    </div>
                    <div class="field">
                        <lebel>password</lebel>
                        <div class="ui left icon input">
                            <input type="password" name="password" id="password">
                            <i class="lock icon"></i>
                        </div>
                    </div>
                    <div class="fluid ui submit button" onclick="submit();">Submit</div>
                    <div class="ui error message"></div>
                </form>
            </div>
        </div>
        <div class="column">
            <div class="ui red stacked segment">
                <c:set var="book" value="${bookList}"/>
                <div class="ui card">
                    <div class="content">
                        <div class="center aligned header"><a href="/book?id=${book.bookId}" target="_Blank" class="header" style="color: black">《${book.bookName}》</a></div>
                        <%--<div class="meta">${book.bookAuthor}</div>--%>
                        <div class="description">
                            ${book.introduction}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="ui vertical divider"><i class="unlinkify icon"></i></div>

    <!-- modal -->
    <div class="ui small modal">
        <div class="ui stackable inverted divided equal height stackable grid">
            <div class="ui two column grid basic segment">
                <div class="ui row">
                    <div class="column">
                        <div class="ui centered green header">
                            Register
                        </div>
                        <div class="ui segment">
                            <form class="ui form" id="registerForm" name="registerForm">
                                <div class="field">
                                    <lebel>your account</lebel>
                                    <div class="ui left icon input">
                                        <input type="text" name="regAccount" id="regAccount">
                                        <i class="user icon"></i>
                                    </div>
                                </div>
                                <div class="field">
                                    <lebel>password</lebel>
                                    <div class="ui left icon input">
                                        <input type="password" name="regPassword" id="regPassword">
                                        <i class="lock icon"></i>
                                    </div>
                                </div>
                                <div class="field">
                                    <lebel>password</lebel>
                                    <div class="ui left icon input">
                                        <input type="password" name="regRePassword" id="regRePassword">
                                        <i class="lock icon"></i>
                                    </div>
                                </div>
                                <div class="ui error message"></div>
                                <div class="extra content">
                                    <div class="ui two buttons">
                                        <div class="ui basic green submit button" onclick="regSubmit();">register</div>
                                        <div class="ui basic red button" onclick="cancel();">cancel</div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="column">
                        <div class="ui centered red header">
                            What's your interested in?
                        </div>
                        <div class="ui segment">
                            <select class="ui fluid search dropdown" multiple="" id="selection">
                                <option value="动作">动作</option>
                                <option value="喜剧">喜剧</option>
                                <option value="青春">青春</option>
                                <option value="惊悚">惊悚</option>
                                <option value="成龙">成龙</option>
                                <option value="张艺谋">张艺谋</option>
                                <option value="郭敬明">郭敬明</option>
                                <option value="红烧肉">红烧肉</option>
                                <option value="白菜">白菜</option>
                                <option value="水煮鱼">水煮鱼</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
         </div>
    </div>
</div>

<%--下拉框初始化--%>
<script>
    $('.ui.dropdown')
        .dropdown()
    ;
</script>

<script>

</script>

</body>
</html>
