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
    <link href="../../css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/exWarehouseList.js"></script>
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
            <td><select id="status" lay-filter="status" lay-verify="required">
                <option value="">状态</option>
                <option value="0">未发货</option>
                <option value="1">已发货</option>
                <option value="2">已退货</option>
                <option value="3">已回款</option>
            </select></td>
            <td width="10">&nbsp;</td>
            <td>
                <input type="text" id="p_name" placeholder="仓库名称" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td>
                <button class="layui-btn btn-search"><i class="layui-icon">&#xe615;</i>查询</button>
               <button class="layui-btn layui-btn-normal btn-add"><i class="layui-icon">&#xe654;</i>添加</button>
            </td>
        </tr>
    </table>
</blockquote>
<!--数据表格-->
<table id="PersonTable" class="layui-hide" lay-filter="person-table">

</table>

<!--人员表单-->
<input type="hidden" id="sDId">
<div id="box2" class="div-hide"></div>
<ul id="detail" class="forminfo"></ul>
<div id="box" class="div-hide">
    <form id="PersonForm" class="layui-form frm" lay-filter="person-form">
        <input type="hidden" name="id" id="id"/>
        <input type="hidden" name="orderId" value="1"/>
        <div class="layui-form-item">
            <label class="layui-form-label">订单编号</label>
            <div class="layui-input-block">
                <select id="ordersNo" name="ordersId" lay-verify="required">
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">仓库名称</label>
            <div class="layui-input-block">
                <select id="storehouseId" name="storehouseId" lay-verify="required">
                </select>
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
