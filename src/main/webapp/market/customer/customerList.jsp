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
                <td  style="width: 100px;">
                    <select id="status1" name="status">
                        <option value="" selected>选择状态</option>
                        <option value="1">可用</option>
                        <option value="2">不可用</option>
                    </select>
                </td>
                <td width="10">&nbsp;</td>
                <td>
                    <button class="layui-btn btn-search"><i class="layui-icon">&#xe615;</i>查询</button>
                    <button class="layui-btn layui-btn-normal btn-add"><i class="layui-icon">&#xe654;</i>添加</button>
                    <button class="layui-btn layui-btn-warm btn-edit"><i class="layui-icon">&#xe642;</i>修改</button>
                    <button class="layui-btn layui-btn-warm btn-allocate"><i class="layui-icon">&#xe642;</i>分配</button>
                    <button class="layui-btn layui-btn-danger btn-del"><i class="layui-icon">&#xe640;</i>注销</button>
                    <%--<button class="layui-btn btn-detail"><i class="layui-icon">&#xe615;</i>查看详情</button>--%>



                </td>
            </tr>
        </table>
    </blockquote>
    <!--数据表格-->
    <input type="hidden" id="cId">
    <table id="CustomerTable" class="layui-hide" lay-filter="person-table"></table>
    <!--人员表单-->
    <div id="box" class="div-hide">
        <form id="CustomerForm" class="layui-form frm" lay-filter="customer-form">
            <input type="hidden" id="id" name="id">
            <div class="layui-form-item">
                <label class="layui-form-label">客户姓名</label>
                <div class="layui-input-inline">
                    <input type="text" id="customerName" name="customerName" lay-verify="required" placeholder="客户姓名"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <input name="sex" value="1" title="男" checked type="radio">
                <input name="sex" value="0" title="女" type="radio">
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="phone" name="phone" required lay-verify="required" placeholder="电话"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">所属公司</label>
                <div class="layui-input-inline">
                    <input type="text" id="company" name="company" required lay-verify="required" placeholder="所属公司"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">所属区域</label>
                <div class="layui-input-inline" style="width: 130px;">
                    <select id="province" lay-filter="province" lay-verify="required">
                    </select>
                </div>
                <div class="layui-input-inline" style="width: 130px;">
                    <select id="city" name="region.id" lay-filter="city" lay-verify="required">
                    </select>
                </div>

            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">状态</label>
                <div class="layui-input-inline" style="width: 130px;">
                    <select id="status" name="status">
                        <option value="" selected>选择状态</option>
                        <option value="1">可用</option>
                        <option value="2">不可用</option>
                    </select>
                </div>
            </div>
            <%--<div class="layui-form-item">--%>
                <%--<label class="layui-form-label">创建时间</label>--%>
                <%--<div class="layui-input-inline">--%>
                    <%--<input type="date" id="createTime" name="createTime" required lay-verify="required" placeholder="创建时间"--%>
                           <%--autocomplete="off" class="layui-input">--%>
                <%--</div>--%>
            <%--</div>--%>

            <div class="layui-form-item">
                <label class="layui-form-label">创建者</label>
                <div class="layui-input-inline">
                    <input type="text" id="creator" name="creator" required lay-verify="required" placeholder="创建者"
                           autocomplete="off" class="layui-input" value="">
                </div>
            </div>

            <%--<div class="layui-form-item">--%>
                <%--<label class="layui-form-label">分配时间</label>--%>
                <%--<div class="layui-input-inline">--%>
                    <%--<input type="date" id="allocateTime" name="allocateTime" required lay-verify="required" placeholder="分配时间"--%>
                           <%--autocomplete="off" class="layui-input">--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="layui-form-item">--%>
                <%--<label class="layui-form-label">客服人员</label>--%>
                <%--&lt;%&ndash;<div class="layui-input-inline" style="width: 130px;">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;&lt;%&ndash;<select id="customerStaff" lay-filter="customerStaff">&ndash;%&gt;&ndash;%&gt;--%>
                    <%--&lt;%&ndash;&lt;%&ndash;</select>&ndash;%&gt;&ndash;%&gt;--%>
                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                <%--<div class="layui-input-inline">--%>
                    <%--<input type="text" id="customerStaff" name="customerStaff" required lay-verify="required" placeholder="客服人员"--%>
                           <%--autocomplete="off" class="layui-input" value="">--%>
                <%--</div>--%>
            <%--</div>--%>
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
                <button class="layui-btn form-save layui-hide" lay-submit lay-filter="saveAllocate"></button>
                <button type="reset" class="layui-btn form-reset layui-hide"></button>
            </div>
        </form>
    </div>


</body>
</html>

