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
    <title>书架</title>
    <link href="../../statics/css/semantic.css" rel="stylesheet" type="text/css"/>
    <script src="../../statics/js/jquery-3.2.1.min.js"></script>
    <script src="../../statics/js/semantic.min.js"></script>
    <link href="../../statics/css/stage.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<%@ include file="headMenu.jsp"%>
<div class="ui container">
    <div class="stage">
        <ul class="books-list">
            <c:forEach items="${books}" var="book">
                <li><img src="${book}"></li>
            </c:forEach>
        </ul>
        <div class="desk"></div>
        <div class="desk-shadow"></div>
    </div>
</div>
</body>
</html>
