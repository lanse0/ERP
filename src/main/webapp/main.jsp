<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>信息管理系统</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <script src="js/jquery.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs">
            <a class="layui-logo" href="main.jsp" target="_parent">
                <img class="layui-logo" src="images/logo.png" title="系统首页"/>
            </a>
        </div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"
                         class="layui-nav-img">
                    ${sessionScope.user.empName}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">Settings</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/users/exit">退出</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="javascript:;" onclick="showBody('index.html')">首页</a></li>
                <c:forEach items="${sessionScope.moduleList}" var="module">
                    <c:if test="${empty module.parent}">
                        <li class="layui-nav-item">
                            <a class="" href="javascript:;">${module.moduleName}</a>
                            <c:forEach items="${sessionScope.moduleList}" var="chile">
                                <c:if test="${module.id == chile.parent.id}">
                                    <dl class="layui-nav-child">
                                        <dd><a href="javascript:;"
                                               onclick="showBody('${chile.url}')">${chile.moduleName}</a>
                                        </dd>
                                    </dl>
                                </c:if>
                            </c:forEach>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div id="body" style="padding: 15px;">内容主体区域。记得修改 layui.css 和 js 的路径</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        <span>仅供学习交流，请勿用于任何商业用途</span>
        <i class="layui-layout-right">版权归北京千锋互联科技所有，技术交流QQ：149141730 刘老师</i>
    </div>
</div>
<script src="layui/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function () {
        var element = layui.element
            , layer = layui.layer
            , util = layui.util;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function (othis) {
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            , menuRight: function () {
                layer.open({
                    type: 1
                    , content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    , area: ['260px', '100%']
                    , offset: 'rt' //右上角
                    , anim: 5
                    , shadeClose: true
                });
            }
        });
    });
    window.onload = function () {
        $("#body").load('index.html');
    }

    function showBody(url) {
        $("#body").load(url);
    }
</script>
</body>
</html>