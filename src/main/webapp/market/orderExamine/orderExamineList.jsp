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
    <title>客户管理</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../../js/jquery.js"></script>

<body>
<div class="place"> <span>位置：</span>
    <ul class="placeul">
        <li>营销管理</li>
        <li>订购单审核管理</li>
        <li>基本内容</li>
    </ul>
</div>
<div class="rightinfo">
    <form action="" method="post">
        <ul class="tools">
            <li> 订单编号:
                <input type="text" />
            </li>
            <li> 客户姓名:
                <input type="text" />
            </li>
            <li> 订购时间:
                <input type="text" />-<input type="text" />
            </li>
            <li> 金额:
                <input type="text" class="stinput" />-<input type="text" class="stinput" />
            </li>
            <li class="subBut" onclick="window.location.href='orderList.html'"><img src="../../images/t06.png" />查询</li>
        </ul>
        <table class="tablelist">
            <thead>
            <tr>
                <th>序号</th>
                <th>订单编号</th>
                <th>客户姓名</th>
                <th>联系电话</th>
                <th>订购时间</th>
                <th>金额</th>
                <th>操作人</th>
                <th>审核状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>DJ201701270001</td>
                <td>王金平</td>
                <td>17370899727</td>
                <td>2017-01-25 15:05:05</td>
                <td>￥9,876,582</td>
                <td>关羽</td>
                <td>审核中</td>
                <td>
                    <a href="orderExamine.html" class="tablelink">审核</a>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>DJ201701270002</td>
                <td>张永祥</td>
                <td>17370899727</td>
                <td>2017-01-25 15:05:05</td>
                <td>￥9,876,582</td>
                <td>关羽</td>
                <td>审核中</td>
                <td>
                    <a href="orderExamine.html" class="tablelink">审核</a>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="pagin">
            <div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
            <ul class="paginList">
                <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
                <li class="paginItem"><a href="javascript:;">1</a></li>
                <li class="paginItem current"><a href="javascript:;">2</a></li>
                <li class="paginItem"><a href="javascript:;">3</a></li>
                <li class="paginItem"><a href="javascript:;">4</a></li>
                <li class="paginItem"><a href="javascript:;">5</a></li>
                <li class="paginItem more"><a href="javascript:;">...</a></li>
                <li class="paginItem"><a href="javascript:;">10</a></li>
                <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
            </ul>
        </div>
    </form>
</div>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>

