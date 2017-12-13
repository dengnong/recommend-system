<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: Chung Junbin
  Date: 2016-09-02 14:35
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>分页</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <style type="text/css">
        table {
            border: 1px;
            margin: 2px auto;
            width: 700px;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:choose>
    <c:when test="${not empty requestScope.page}">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>注册日期</th>
                <th>是否有效</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.page.content}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.createTime}</td>
                    <td>${user.valid}</td>
                    <td><a href="${pageContext.request.contextPath}/user/${user.id}/delete">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
                <%-- 设置当前页的页码 --%>
            <c:set var="currentPageOffset" value="${requestScope.page.number }"/>
            <tr>
                <td colspan="5">
                    共 ${requestScope.page.totalElements} 条记录　　
                    当前第 ${currentPageOffset + 1} 页　　

                    <c:choose>
                        <c:when test="${requestScope.page.isFirst()}">
                            首页
                        </c:when>
                        <c:otherwise>
                            <a href="${contextPath}/user/page/0/10">首页</a>
                        </c:otherwise>
                    </c:choose>　　

                    <c:if test="${requestScope.page.hasPrevious()}">
                        <a href="${contextPath}/user/page/${currentPageOffset - 1}/10">上一页</a>
                    </c:if>　　

                    <select id="forwardPage">
                        <c:forEach begin="1" end="${requestScope.page.totalPages}" var="pageNumber">
                            <option value="${pageNumber}">${pageNumber}</option>
                        </c:forEach>
                    </select>　　

                    <c:if test="${requestScope.page.hasNext()}">
                        <a href="${contextPath}/user/page/${currentPageOffset + 1}/10">下一页</a>
                    </c:if>　　

                    <c:choose>
                        <c:when test="${requestScope.page.isLast()}">
                            尾页
                        </c:when>
                        <c:otherwise>
                            <a href="${contextPath}/user/page/${requestScope.page.totalPages}/10">尾页</a>
                        </c:otherwise>
                    </c:choose>　　

                </td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        当前没有数据
    </c:otherwise>
</c:choose>

<script type="text/javascript">
    $(function () {
        var forwardPage = $("#forwardPage");
        forwardPage.on("change", function () {
            var pageOffset = forwardPage.val() - 1;
            var pageSize = 10;
            window.location.href = "${contextPath}/user/page/" + pageOffset + "/" + pageSize;
        });
    });
</script>
</body>
</html>
