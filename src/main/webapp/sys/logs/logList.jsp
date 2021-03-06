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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/sys/js/logList.js"></script>
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
            <td>
                <input type="text" id="empNoSer" placeholder="员工编号" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td>
                <input type="text" id="empNameSer" placeholder="员工姓名" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td>
                <input type="text" id="contentSer" placeholder="日志内容" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td>
                <input type="text" id="deptSer" placeholder="操作模块" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td>
                <input type="date" id="minTimeSer" placeholder="操作时间" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;—</td>
            <td>
                <input type="date" id="maxTimeSer" placeholder="操作时间" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td>
                <button class="layui-btn btn-search"><i class="layui-icon">&#xe615;</i>查询</button>
            </td>
        </tr>
    </table>
</blockquote>
<!--数据表格-->
<table id="LogTable" class="layui-hide" lay-filter="log-table"></table>
<!--人员表单-->
<div id="box" class="div-hide">
    <form id="EmpForm" class="layui-form frm" lay-filter="emp-form">
        <input type="text" id="Id" name="id" class="layui-hide">
        <div class="layui-form-item">
            <label class="layui-form-label">编号</label>
            <div class="layui-input-inline">
                <input type="text" id="empNo" name="empNo" lay-verify="required" placeholder="编号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" id="empName" name="empName" required lay-verify="required" placeholder="姓名"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-inline">
                <input type="text" id="userName" name="userName" required lay-verify="required" placeholder="账号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" id="password" name="password" required lay-verify="required" placeholder="密码"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-inline">
                <input type="text" id="phone" name="phone" required lay-verify="required" placeholder="电话"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">部门</label>
            <div class="layui-input-inline" style="width: 130px;">
                <select id="province" lay-filter="province">
                </select>
            </div>
            <div class="layui-input-inline" style="width: 130px;">
                <select id="city" lay-filter="city">
                </select>
            </div>
            <div class="layui-input-inline" style="width: 130px;">
                <select id="dept1" name="dept.id" lay-filter="dept1" lay-verify="required">
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职位</label>
            <div class="layui-input-inline">
                <%--                <select id="role" name="role.id" data-json-type="array">--%>
                <select id="role" name="role.id" lay-verify="required">
                    <option class="layui-disabled" value="">先选择部门</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">生日</label>
            <div class="layui-input-inline">
                <input type="date" id="birthDay" name="birthDay" required lay-verify="required" placeholder="生日"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <input name="sex" value="1" title="男" checked type="radio">
            <input name="sex" value="0" title="女" type="radio">
        </div>
        <div>
            <button class="layui-btn form-save layui-hide" lay-submit lay-filter="save"></button>
            <button type="reset" class="layui-btn form-reset layui-hide"></button>
        </div>
    </form>
</div>
</body>
</html>