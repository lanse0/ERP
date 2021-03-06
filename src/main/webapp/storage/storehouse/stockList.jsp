<%--
  Created by IntelliJ IDEA.
  User: 26584
  Date: 2022/5/2
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>仓库管理</title>
    <!-- 引入外部css和js文件 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/stockList.js"></script>
    <style>
        .layui-form-label.layui-required:after{
            content:'*';
            color:red;
            font-weight: bold;
            position: absolute;
            top:5px;
            left:15px;
        }

        .frm {
            margin-top: 20px;
        }

        .div-hide {
            display: none;
        }
    </style>
</head>
<body>
<blockquote class="layui-elem-quote layui-text layui-form">
    <table>
        <tr>
            <td width="10">&nbsp;</td>
            <td>
                <input type="text" id="p_name" placeholder="仓库名称" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td>
                <button class="layui-btn btn-search"><i class="layui-icon">&#xe615;</i>查询</button>
            </td>
        </tr>
    </table>
</blockquote>
<!--数据表格-->
<table id="PersonTable" class="layui-hide" lay-filter="person-table"></table>
    </form>
</div>
</body>
</html>
