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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/storehouseList.js"></script>
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
            <td>
                        <select id="province1" lay-filter="province1" lay-verify="required">
                        </select>
            </td>
            <td>
                <select id="city1"  lay-filter="city1"  lay-verify="required">
                </select>
            </td>
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
<!--人员表单-->
<div id="box" class="div-hide">
    <form id="PersonForm" class="layui-form frm" lay-filter="person-form">
        <input type="hidden" name="id" id="id"/>
        <div class="layui-form-item">
            <label class="layui-form-label">仓库名称</label>
            <div class="layui-input-inline">
                <input type="text" name="name" required lay-verify="required" placeholder="仓库名称"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">仓库地址</label>
            <div class="layui-input-inline">
                <input type="text" name="address" required lay-verify="required" placeholder="仓库地址"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">所属区域</label>
            <div class="layui-input-block">
                <select id="province" name="parentId" lay-filter="province" lay-verify="required">
                </select>
            </div>
            <div class="layui-input-block">
                <select id="city" name="regionId" lay-verify="required">
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">负责人</label>
            <div class="layui-input-block">
                <select id="masterId" name="masterId" lay-verify="required">
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系方式</label>
            <div class="layui-input-inline">
                <input type="text" name="tel" required lay-verify="required" placeholder="联系方式"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-inline">
               <textarea name="des" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <input name="status" value="1" title="可用" checked type="radio">
            <input name="status" value="0" title="不可用" type="radio">
        </div>
        <div>
            <button class="layui-btn form-save layui-hide" lay-submit lay-filter="save"></button>
            <button type="reset" class="layui-btn form-reset layui-hide"></button>
        </div>
    </form>
</div>
</body>
</html>
