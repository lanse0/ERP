<%--
  Created by IntelliJ IDEA.
  User: AJM
  Date: 2022/5/4
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>客户详细信息</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/market/js/customerLsit.js"></script>
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

<div id="viewBox" class="div-hide">
    <form id="formtitle" class="layui-form frm" lay-filter="customerView-form">
        <div class="layui-form-item">
            <label class="layui-form-label">客户编号</label>
            <div class="layui-input-inline">
                <input type="text" id="id" name="id" lay-verify="required" placeholder="客户姓名"
                       autocomplete="off" class="layui-input" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">客户姓名</label>
            <div class="layui-input-inline">
                <input type="text" id="customerName" name="customerName" lay-verify="required" placeholder="客户姓名"
                       autocomplete="off" class="layui-input" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <input type="text" id="sex" name="sex" lay-verify="required" placeholder="客户姓名"
                   autocomplete="off" class="layui-input" readonly="readonly">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-inline">
                <input type="text" id="phone" name="phone" required lay-verify="required" placeholder="电话"
                       autocomplete="off" class="layui-input" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">所属公司</label>
            <div class="layui-input-inline">
                <input type="text" id="company" name="company" required lay-verify="required" placeholder="所属公司"
                       autocomplete="off" class="layui-input" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">所属区域</label>
            <div class="layui-input-inline">
                <input type="text" id="regionName" name="region.regionName" required lay-verify="required" placeholder="所属公司"
                       autocomplete="off" class="layui-input" readonly="readonly">
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-inline">
                <input type="text" id="status" name="status" required lay-verify="required" placeholder="所属公司"
                       autocomplete="off" class="layui-input" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">创建时间</label>
            <div class="layui-input-inline">
            <input type="date" id="createTime" name="createTime" required lay-verify="required" placeholder="创建时间"
            autocomplete="off" class="layui-input" readonly="readonly">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">创建者</label>
            <div class="layui-input-inline">
                <input type="text" id="creator" name="creator" required lay-verify="required" placeholder="创建者"
                       autocomplete="off" class="layui-input" value="" readonly="readonly">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">分配时间</label>
            <div class="layui-input-inline">
                <input type="date" id="allocateTime" name="allocateTime" required lay-verify="required" placeholder="分配时间"
                       autocomplete="off" class="layui-input" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">客服人员</label>
            <div class="layui-input-inline">
                <input type="text" id="customerStaff" name="customerStaff" required lay-verify="required" placeholder="客服人员"
                    autocomplete="off" class="layui-input" value="" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">详细地址</label>
            <div class="layui-input-inline">
                <input type="text" id="address" name="address" required lay-verify="required" placeholder="客服人员"
                       autocomplete="off" class="layui-input" value="" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-inline">
                <input type="text" id="description" name="description" required lay-verify="required" placeholder="客服人员"
                       autocomplete="off" class="layui-input" value="" readonly="readonly">
            </div>
        </div>
        <div>
            <button class="layui-btn  layui-hide" lay-submit lay-filter="back" onclick="window.history.go(-1);"></button>
        </div>
    </form>
</div>

</body>
</html>

