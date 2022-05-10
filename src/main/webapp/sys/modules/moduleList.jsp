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
    <title>模块管理</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/sys/js/moduleList.js"></script>
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
<blockquote class="layui-elem-quote layui-text layui-form">
    <table>
        <tr>
            <td>
                <input type="text" id="moduleSer" placeholder="模块名称" autocomplete="off" class="layui-input ipt1">
            </td>
            <td width="10">&nbsp;</td>
            <td>
                <button class="layui-btn btn-search"><i class="layui-icon">&#xe615;</i>查询</button>
                <button class="layui-btn layui-btn-normal btn-add"><i class="layui-icon">&#xe654;</i>添加</button>
                <button class="layui-btn layui-btn-warm btn-edit"><i class="layui-icon">&#xe642;</i>修改</button>
            </td>
        </tr>
    </table>
</blockquote>
<!--数据表格-->
<table id="ModuleTable" class="layui-hide" lay-filter="module-table"></table>
<script type="text/html" id="checkStatus">
    <input type="checkbox" name="status" value="{{d.id}}" lay-skin="switch" lay-text="正常|禁用"
           lay-filter="statusDemo" {{ d.status == 1 ? 'checked':''}}>
</script>
<!--表单-->
<div id="box" class="div-hide">
    <form id="ModuleForm" class="layui-form frm" lay-filter="module-form">
        <input type="text" id="id" name="id" class="layui-hide">
        <div class="layui-form-item">
            <label class="layui-form-label">模块名称</label>
            <div class="layui-input-inline">
                <input type="text" id="moduleName" name="moduleName" lay-verify="required" placeholder="名称"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">父模块</label>
            <div class="layui-input-inline">
                <select id="parent" name="parent.id">
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">URL</label>
            <div class="layui-input-inline">
                <input type="text" id="url" name="url" lay-verify="required" placeholder="URL"
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