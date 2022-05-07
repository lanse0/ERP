<%--
  Created by IntelliJ IDEA.
  User: AJM
  Date: 2022/5/6
  Time: 22:01
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
        <li>订购单管理</li>
        <li>修改</li>
    </ul>
</div>
<div class="formbody">
    <div class="formtitle"><span>订购单信息</span></div>
    <ul class="forminfo">
        <li>
            <label>订单编号</label>
            <input name="" type="text" value="DJ201711180001" readonly="readonly" class="roinput" />
            <i>自动生成不能编辑</i>
        </li>
        <li>
            <label>客户姓名</label>
            <input name="" type="text" value="王金平"  class="dfinput" />
            <i>不能为空</i>
        </li>
        <li>
            <label>订购时间</label>
            <input name="" type="text" value="2017-11-18 15:36:10" readonly="readonly" class="roinput" />
            <i>不能编辑</i>
        </li>
        <li>
            <label>创建人</label>
            <input name="" type="text" value="马云" readonly="readonly" class="roinput" />
            <i>不能编辑</i>
        </li>
        <li>
            <label>审核状态</label>
            <input type="text" value="未审核" readonly="readonly" class="roinput" />
            <input name="" type="hidden" value="1" />
            <i>初始状态，不能编辑</i>
        </li>
        <li>
            <label>总金额</label>
            <input name="" type="text" value="9876582" readonly="readonly" class="roinput" />
            <i>自动运算，不能编辑</i>
        </li>
        <li>
            <input type="button" value="新增" class="smallbtn" />
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="删除" class="smallbtn" />
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="保存" class="smallbtn" />
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="返回" class="smallbtn" onclick="window.location.href='orderList.html'"/>
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
            <td>
                <select>
                    <option>请选择</option>
                    <option selected="selected">联想</option>
                    <option>海尔</option>
                    <option>小米</option>
                </select>
            </td>
            <td>
                <select>
                    <option>请选择</option>
                    <option selected="selected">笔记本电脑</option>
                    <option>台式电脑</option>
                    <option>手机</option>
                </select>
            </td>
            <td>
                <select>
                    <option>请选择</option>
                    <option>X260</option>
                    <option>E470</option>
                    <option selected="selected">T470</option>
                </select>
            </td>
            <td><input type="text" value="10" /></td>
            <td>台</td>
            <td><input type="text" value="9998" /></td>
            <td><input type="text" value="99980" /></td>
        </tr>
        <tr>
            <td>2</td>
            <td>
                <select>
                    <option>请选择</option>
                    <option selected="selected">联想</option>
                    <option>海尔</option>
                    <option>小米</option>
                </select>
            </td>
            <td>
                <select>
                    <option>请选择</option>
                    <option selected="selected">笔记本电脑</option>
                    <option>台式电脑</option>
                    <option>手机</option>
                </select>
            </td>
            <td>
                <select>
                    <option>请选择</option>
                    <option selected="selected">X260</option>
                    <option>E470</option>
                    <option>T470</option>
                </select>
            </td>
            <td><input type="text" value="5" /></td>
            <td>台</td>
            <td><input type="text" value="5500" /></td>
            <td><input type="text" value="27500" /></td>
        </tr>
        </tbody>
    </table>
</div>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>

