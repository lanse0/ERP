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
    <title>订购单管理</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/market/js/ordersList.js"></script>

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
                <button class="layui-btn layui-btn-normal btn-add"><i class="layui-icon">&#xe654;</i>添加</button>
                <button class="layui-btn layui-btn-warm btn-edit"><i class="layui-icon">&#xe642;</i>修改</button>
                <button class="layui-btn layui-btn-danger btn-del"><i class="layui-icon">&#xe640;</i>删除</button>
                <%--<button class="layui-btn btn-detail"><i class="layui-icon">&#xe615;</i>查看详情</button>--%>



            </td>
        </tr>
    </table>
</blockquote>
<!--数据表格-->
<input type="hidden" id="cId">
<table id="OrdersTable" class="layui-hide" lay-filter="person-table"></table>
<!--人员表单-->
<div id="box" class="div-hide">
    <form id="OrdersForm" class="layui-form frm" lay-filter="orders-form">
        <input type="hidden" id="id" name="id">
        <div class="layui-form-item">
            <label class="layui-form-label">订单编号</label>
            <div class="layui-input-inline">
                <input type="text" id="ordersNo" name="ordersNo" lay-verify="required" placeholder="订单编号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">客户编号</label>
            <div class="layui-input-inline">
                <input type="text" id="customerId" name="customer.id" lay-verify="required" placeholder="客户编号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">操作人编号</label>
            <div class="layui-input-inline">
                <input type="text" id="empId" name="emp.id" lay-verify="required" placeholder="客户编号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <%--<div class="layui-form-item">--%>
            <%--<label class="layui-form-label">客户姓名</label>--%>
            <%--<div class="layui-input-inline">--%>
                <%--<input type="text" id="customerName" name="customer.customerName" lay-verify="required" placeholder="客户姓名"--%>
                       <%--autocomplete="off" class="layui-input">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="layui-form-item">--%>
            <%--<label class="layui-form-label">联系电话</label>--%>
            <%--<div class="layui-input-inline">--%>
                <%--<input type="text" id="phone" name="customer.phone" required lay-verify="required" placeholder="联系电话"--%>
                       <%--autocomplete="off" class="layui-input">--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-inline" style="width: 130px;">
                <select id="status" name="status">
                    <option value="1"selected>未审核</option>
                    <option value="2">审核中</option>
                    <option value="3">审核通过</option>
                    <option value="4">审核不通过</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">订购时间</label>
            <div class="layui-input-inline">
            <input type="text" id="orderTime" name="orderTime" required lay-verify="required" placeholder="订购时间"
            autocomplete="off" class="layui-input" value="<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime())%>"
            readonly="readonly">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">商品序号</label>
            <div class="layui-input-inline">
                <input type="text" id="Bid" name="Bid" required lay-verify="required" placeholder="商品序号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品品牌</label>
            <div class="layui-input-inline">
                <input type="text" id="brand" name="brand" required lay-verify="required" placeholder="商品品牌"
                       autocomplete="off" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品类型</label>
            <div class="layui-input-inline">
                <input type="text" id="brandType" name="brandType" required lay-verify="required" placeholder="商品类型"
                       autocomplete="off" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品型号</label>
            <div class="layui-input-inline">
                <input type="text" id="brandModel" name="brandModel" required lay-verify="required" placeholder="商品型号"
                       autocomplete="off" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品单价</label>
            <div class="layui-input-inline">
                <input type="text" id="price" name="price" required lay-verify="required" placeholder="商品单价"
                       autocomplete="off" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品数量</label>
            <div class="layui-input-inline">
                <input type="text" id="number" name="number" required lay-verify="required" placeholder="商品数量"
                       autocomplete="off" class="layui-input" >
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">订单金额</label>
            <div class="layui-input-inline">
                <input type="text" id="amount" name="amount" required lay-verify="required" placeholder="订单金额"
                       autocomplete="off" class="layui-input" value="" readonly="readonly">
            </div>
        </div>

        <div>
            <button class="layui-btn form-save layui-hide" lay-submit lay-filter="save"></button>
            <button type="reset" class="layui-btn form-reset layui-hide"></button>
        </div>
    </form>
</div>
<ul id="detail" class="forminfo"></ul>
<!--分配表单-->
<div id="allocate" class="div-hide">
    <form id="AllocateForm" class="layui-form frm" lay-filter="allocate-form">
        <input type="hidden" name="id">
        <div class="layui-form-item">
            <label class="layui-form-label">部门</label>
            <div class="layui-input-inline" style="width: 130px;">
                <select id="dept" name="" lay-filter="dept" lay-verify="required">
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职位</label>
            <div class="layui-input-inline" style="width: 130px;">
                <select id="role" lay-filter="role" lay-verify="required">
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline" style="width: 130px;">
                <select id="emp" name="emp.id">
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

