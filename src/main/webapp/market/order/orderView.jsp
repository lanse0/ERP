<%--
  Created by IntelliJ IDEA.
  User: AJM
  Date: 2022/5/4
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>订购单审核管理</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/market/js/ordersView.js"></script>

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
    <script type="text/javascript">

    </script>
</head>

<body>
<blockquote class="layui-elem-quote layui-text layui-form">
    <table>
        <tr>
            <td style="width: 300px;">
                <input type="text" id="ordersNo1" placeholder="订单编号" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td style="width: 300px;">
                <input type="text" id="customerName1" placeholder="客户姓名" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <%--<td  style="width: 100px;">--%>
                <%--<select id="province1" lay-filter="province1" lay-verify="required">--%>
                    <%--<option value="" selected>所属区域</option>--%>
                <%--</select>--%>
            <%--</td>--%>
            <%--<td style="width: 100px;">--%>
                <%--<select id="city1" lay-filter="city1" lay-verify="required">--%>
                    <%--<option value="" selected>所属区域</option>--%>
                <%--</select>--%>
            <%--</td>--%>
            <td width="10">&nbsp;</td>
            <%--<td  style="width: 100px;">--%>
                <%--<select id="status1" name="status">--%>
                    <%--<option value="" selected>选择状态</option>--%>
                    <%--<option value="1">可用</option>--%>
                    <%--<option value="2">不可用</option>--%>
                <%--</select>--%>
            <%--</td>--%>
            <td width="10">&nbsp;</td>
            <td>
                <button class="layui-btn btn-search"><i class="layui-icon">&#xe615;</i>查询</button>

                <button class="layui-btn layui-btn-warm btn-audit"><i class="layui-icon">&#xe642;</i>审核</button>
            </td>
        </tr>
    </table>
</blockquote>
<!--数据表格-->
<input type="hidden" id="cId">
<table id="OrdersTable" class="layui-hide" lay-filter="person-table"></table>



<ul id="detail" class="forminfo"></ul>
<!--分配表单-->
<div id="audit" class="div-hide">
    <form id="AuditForm" class="layui-form frm" lay-filter="audit-form">
        <input type="hidden" name="id">
        <div class="layui-form-item">
            <label class="layui-form-label">审核状态</label>
            <div class="layui-input-inline" style="width: 200px;">
                <select id="status" name="status">
                    <option value="1"selected>未审核</option>
                    <option value="2">审核中</option>
                    <option value="3">审核通过</option>
                    <option value="4">审核不通过</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">审核内容</label>
            <div class="layui-input-inline" style="width: 200px;">
                <input type="text" id="auditContext" name="auditContext" required lay-verify="required" placeholder="审核内容"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div>
            <button class="layui-btn form-save layui-hide" lay-submit lay-filter="save"></button>
            <button type="reset" class="layui-btn form-reset layui-hide"></button>
        </div>
    </form>
</div>


</body>
</html>

