<%--
  Created by IntelliJ IDEA.
  User: AJM
  Date: 2022/5/4
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="place"> <span>位置：</span>
    <ul class="placeul">
        <li>营销管理</li>
        <li>客户管理</li>
        <li>添加</li>
    </ul>
</div>
<div class="formbody">
    <div class="formtitle"><span>客户信息</span></div>
    <ul class="forminfo">
        <li>
            <label>姓名</label>
            <input name="" type="text" class="dfinput" />
            <i>必填，不能超过30个字符</i>
        </li>
        <li>
            <label>性别</label>
            <cite>
                <input name="" type="radio" value="1" checked="checked" />男
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input name="" type="radio" value="2" />女
            </cite>
        </li>
        <li>
            <label>所属公司名称</label>
            <input name="" type="text" class="dfinput" />
            <i>必填，不能超过30个字符</i>
        </li>
        <li>
            <label>联系方式</label>
            <input name="" type="text" class="dfinput" />
            <i>必填，不能超过30个字符</i>
        </li>
        <li>
            <label>联系地址</label>
            <input name="" type="text" class="dfinput" />
            <i>必填，不能超过130个字符</i>
        </li>
        <li>
            <label>所属区域</label>
            <select class="dfselect">
                <option>请选择</option>
                <option>北京</option>
                <option>江苏</option>
                <option>天津</option>
            </select>
            省
            <select class="dfselect">
                <option>请选择</option>
                <option>北京</option>
                <option>南京</option>
                <option>天津</option>
            </select>
            市
            <i>必选</i>
        </li>
        <li>
            <label>描述</label>
            <textarea class="textinput"></textarea>
            <i>可选</i>
        </li>
        <li>
            <label>状态</label>
            <select class="dfselect">
                <option value="1">可用</option>
                <option value="0">不可用</option>
            </select>
            <i>必选</i>
        </li>
        <li>
            <label>创建人</label>
            <input name="" type="text" value="马云" readonly="readonly" class="roinput" />
            <i>不能编辑</i>
        </li>
        <li>
            <label>创建时间</label>
            <input name="" type="text" value="2017-11-18 15:36:10" readonly="readonly" class="roinput" />
            <i>不能编辑</i>
        </li>
        <li>
            <label>&nbsp;</label>
            <input name="" type="button" class="btn" value="确定"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input name="" type="button" class="btn" value="返回" onclick="window.location.href='customerList.html'"/>
        </li>
    </ul>
</div>
</body>
</html>

