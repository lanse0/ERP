<%--
  Created by IntelliJ IDEA.
  storehouse: 26584
  Date: 2022/4/28
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/storehouse/findByPage" method="post">
<input type="submit" value="提交">
</form>
<form action="/storehouse/delStorehouse" method="post">
    <input  id="id">
    <input type="submit" value="提交">
</form>
<form action="/storehouse/upload" method="post" enctype="multipart/form-data">
    <input type="text" name="id">
    <input type="file" name="photoSource">
    <input type="submit" value="提交">
</form>
<table width="800px" border="1px" cellpadding="0" cellspacing="0" align="center">
    <tr>
        <td>id</td><td>name</td><td>address</td><td>tel</td><td>describe</td><td>status</td><td>createTime</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="storehouse">
        <tr>
            <td>${storehouse.id}</td>
            <td>${storehouse.name}</td>
            <td>${storehouse.address}</td>
            <td>${storehouse.tel}</td>
            <td>${storehouse.des}</td>
            <td>${storehouse.status}</td>
            <td><fmt:formatDate value="${storehouse.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7">
            共 ${pageInfo.total}条记录，每页显示 ${pageInfo.pageSize} 条
            当前第 ${pageInfo.pageNum}页, 共 ${pageInfo.pages}页

            <a href="${pageContext.request.contextPath}/storehouse/findByPage?pageNum=1">首页</a>
            <c:if test="${pageInfo.hasPreviousPage}">
                <a href="${pageContext.request.contextPath}/storehouse/findByPage?pageNum=${pageInfo.prePage}">上一页</a>
            </c:if>
            <c:if test="${pageInfo.hasNextPage}">
                <a href="${pageContext.request.contextPath}/storehouse/findByPage?pageNum=${pageInfo.nextPage}">下一页</a>
            </c:if>
            <a href="${pageContext.request.contextPath}/storehouse/findByPage?pageNum=${pageInfo.pages}">尾页</a>
        </td>
    </tr>
</table>
</body>
</html>
