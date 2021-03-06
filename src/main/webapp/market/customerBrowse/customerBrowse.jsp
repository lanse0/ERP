<%--
  Created by IntelliJ IDEA.
  User: AJM
  Date: 2022/5/4
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>客户管理</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/market/js/customerBrowse.js"></script>
    <style>
        .layui-form-label.layui-required:after {
            content: '*';
            color: red;
            font-weight: bold;
            position: absolute;
            top: 5px;
            left: 15px;
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
            <td style="width: 140px;">
                <input type="text" id="company1" placeholder="公司名称" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td style="width: 140px;">
                <input type="text" id="customerName1" placeholder="客户姓名" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td  style="width: 100px;">
                <select id="province1" lay-filter="province1" lay-verify="required">
                    <option value="" selected>所属区域</option>
                </select>
            </td>
            <td style="width: 100px;">
                <select id="city1" lay-filter="city1" lay-verify="required">
                    <option value="" selected>所属区域</option>
                </select>
            </td>
            <td width="10">&nbsp;</td>

            <td>
                <button class="layui-btn btn-search"><i class="layui-icon">&#xe615;</i>查询</button>

                <%--<button class="layui-btn btn-detail"><i class="layui-icon">&#xe615;</i>查看详情</button>--%>
            </td>
        </tr>
    </table>
</blockquote>
<!--数据表格-->
<input type="hidden" id="cId">
<table id="CustomerBrowseTable" class="layui-hide" lay-filter="person-table"></table>

<ul id="detail" class="forminfo"></ul>




</body>
</html>

