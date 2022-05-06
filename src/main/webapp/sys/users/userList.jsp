<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-COMPATIBLE" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户管理</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/sys/js/userList.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
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
<%--<div class="place"><span>位置：</span>--%>
<%--    <ul class="placeul">--%>
<%--        <li><a href="#">系统管理</a></li>--%>
<%--        <li><a href="#">用户管理</a><<a href=""></a>
<%--    </ul>--%>
<%--</div>--%>
<blockquote class="layui-elem-quote layui-text layui-form">
    <table>
        <tr>
            <td>
                <input type="text" id="empNo" placeholder="编号" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td>
                <input type="text" id="empName" placeholder="姓名" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td>
                <select id="dept" name="dept">
                    <option value="" selected>请选择部门</option>
                </select>
            </td>
            <td width="10">&nbsp;</td>
            <td>
                <select id="status" name="status">
                    <option value="" selected>选择状态</option>
                    <option value="1">在职</option>
                    <option value="0">离职</option>
                </select>
            </td>
            <td width="10">&nbsp;</td>
            <td>
                <button class="layui-btn btn-search"><i class="layui-icon">&#xe615;</i>查询</button>
                <button class="layui-btn layui-btn-normal btn-add"><i class="layui-icon">&#xe654;</i>添加</button>
                <button class="layui-btn layui-btn-warm btn-edit"><i class="layui-icon">&#xe642;</i>修改</button>
                <button class="layui-btn layui-btn-danger btn-quit"><i class="layui-icon">&#xe640;</i>离职</button>
            </td>
        </tr>
    </table>
</blockquote>
<!--数据表格-->
<table id="EmpTable" class="layui-hide" lay-filter="person-table"></table>
<!--人员表单-->
<div id="box" class="div-hide">
    <form id="PersonForm" class="layui-form frm" lay-filter="person-form">
        <div class="layui-form-item">
            <label class="layui-form-label">编号</label>
            <div class="layui-input-inline">
                <input type="text" id="pid" name="id" placeholder="编号"
                       autocomplete="off" class="layui-input" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" required lay-verify="required" placeholder="姓名"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-inline">
                <input type="text" name="age" required lay-verify="required" placeholder="年龄"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <input name="sex" value="男" title="男" checked type="radio">
            <input name="sex" value="女" title="女" type="radio">
        </div>
        <div>
            <button class="layui-btn form-save layui-hide" lay-submit lay-filter="save"></button>
            <button type="reset" class="layui-btn form-reset layui-hide"></button>
        </div>
    </form>
</div>
</body>
</html>
