<%--
  Created by IntelliJ IDEA.
  User: 26584
  Date: 2022/4/29
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="place"> <span>位置：</span>
    <ul class="placeul">
        <li>仓库管理</li>
        <li>仓库管理</li>
        <li>添加仓库</li>
    </ul>
</div>
<div class="formbody">
    <div class="formtitle"><span>仓库信息</span></div>
    <form action="/storehouse/addStorehouse" method="post">
    <ul class="forminfo">
        <li>
            <label>仓库名称</label>
            <input name="name" type="text" class="dfinput" />
            <i>必填，不能超过30个字符</i>
        </li>
        <li>
            <label>仓库地址</label>
            <input name="address" type="text" class="dfinput" />
            <i>必填，不能超过50个字符</i>
        </li>
        <li>
            <label>所属区域</label>
            <select name="provinceId" class="dfselect">
                <option value="1">请选择</option>
            </select>
            省
            <select name="cityId" class="dfselect">
                <option value="1">请选择</option>
            </select>
            市
            <i>必选</i>
        </li>
        <li>
            <label>负责人</label>
            <select name="masterId" class="dfselect">
                <option value="1">请选择</option>
            </select>
            <i>只能是财务部仓库管理员职位</i>
        </li>
        <li>
            <label>联系方式</label>
            <input name="tel" type="text" class="dfinput" />
            <i>必填，不能超过30个字符</i>
        </li>
        <li>
            <label>描述</label>
            <textarea name="des" class="textinput"></textarea>
            <i>可选</i>
        </li>
        <li>
            <label>状态</label>
            <select name="status" class="dfselect">
                <option value="1">可用</option>
                <option value="2">不可用</option>
            </select>
            <i>必选</i>
        </li>
        <li>
            <label>&nbsp;</label>
            <input type="submit" class="btn" value="确定"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="btn" value="返回" onclick="window.location.href='storageList.html'"/>
        </li>
    </ul>
    </form>
</div>
</body>
</html>
