<%--
  Created by IntelliJ IDEA.
  User: AJM
  Date: 2022/5/6
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../../js/jquery.js"></script>
</head>

<body>
<div class="place"> <span>位置：</span>
    <ul class="placeul">
        <li>营销管理</li>
        <li>订购单审核管理</li>
        <li>审核</li>
    </ul>
</div>
<div class="formbody">
    <div class="formtitle"><span>订购单审核</span></div>
    <ul class="forminfo">
        <li>
            <label>订单编号</label>
            <cite>DJ201711180001</cite>
        </li>
        <li>
            <label>客户姓名</label>
            <cite><a href="../../market/customer/customerView.html" title="点击查看客户详细信息" class="tablelink">王金平</a></cite>
        </li>
        <li>
            <label>联系电话</label>
            <cite>17370899727</cite>
        </li>
        <li>
            <label>订购时间</label>
            <cite>2017-11-18 15:36:10</cite>
        </li>
        <li>
            <label>总金额</label>
            <cite>￥9,876,582</cite>
        </li>
        <li>
            <label>操作人</label>
            <cite>关羽</cite>
        </li>
    </ul>
    <table class="tablelist">
        <thead>
        <tr>
            <th>序号</th>
            <th>品牌</th>
            <th>类型</th>
            <th>型号</th>
            <th>数量</th>
            <th>单位</th>
            <th>单价</th>
            <th>金额</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>联想</td>
            <td>笔记本电脑</td>
            <td>T470</td>
            <td>10</td>
            <td>台</td>
            <td>9998</td>
            <td>99980</td>
        </tr>
        <tr>
            <td>2</td>
            <td>联想</td>
            <td>笔记本电脑</td>
            <td>X260</td>
            <td>5</td>
            <td>台</td>
            <td>5500</td>
            <td>27500</td>
        </tr>
        </tbody>
    </table>
    <ul class="forminfo">
        <li>
            <label>审核意见</label>
            <textarea class="textinput"></textarea>
        </li>
        <li>
            <label>审核状态</label>
            <select class="dfselect">
                <option>请选择</option>
                <option value="3">通过</option>
                <option value="4">不通过</option>
            </select>
        </li>
        <li>
            <label>&nbsp;</label>
            <input name="" type="button" class="btn" value="审核"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input name="" type="button" class="btn" value="返回" onclick="window.location.href='customerList.html'"/>
        </li>
    </ul>
    <script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
    </script>
</body>
</html>

