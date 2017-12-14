<%--
  Created by IntelliJ IDEA.
  User: 54472
  Date: 2017/11/12
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>

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
            background-image: url("/statics/image/login.jpg");
            background-size: cover;
        }
    </style>

</head>

<body>
<div class="ui raised segment">
    <div class="ui breadcrumb">
        <div class="section">LOGIN</div>
        <div class="divider"> / </div>
        <a class="active section">REGISTER</a>
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
                    <div class="fluid ui submit button">Submit</div>
                    <div class="ui error message"></div>
                </form>
            </div>
        </div>
        <div class="center aligned column">
            <div class="ui red stacked segment">
            <div class="ui card">
                <div class="content">
                    <div class="header">《${title}》</div>
                    <div class="meta">${catalog}</div>
                    <div class="description">
                        ${sub2}...
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
    <div class="ui vertical divider"><i class="unlinkify icon"></i></div>
</div>

<script>
    $(document).ready(function () {
        $('.ui.form').form({
            account: {
                identifier: 'account',
                rules: [
                    {
                        type: 'empty',
                        prompt: '用户名必填！'
                    }
                ]
            },
            password: {
                identifier: 'password',
                rules: [
                    {
                        type: 'length[6]',
                        prompt: '密码最少6位！'
                    }
                ]
            }
        }, {
            inline: true,
            on: 'submit'
        })

        ;

    });
</script>

</body>

</html>
