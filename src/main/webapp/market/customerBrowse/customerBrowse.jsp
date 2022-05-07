<%--
  Created by IntelliJ IDEA.
  User: AJM
  Date: 2022/5/6
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>客户管理</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../../js/jquery.js"></script>
    <script type="text/javascript">
        function tipOpen(content) {
            $(".tipright p").text(content);
            $("#tip").fadeIn(200);
        }
        function tipClose() {
            $("#tip").fadeOut(200);
        }
    </script>
</head>

<body>
<div class="place"> <span>位置：</span>
    <ul class="placeul">
        <li>营销管理</li>
        <li>客户浏览</li>
        <li>基本内容</li>
    </ul>
</div>
<div class="rightinfo">
    <form action="" method="post">
        <ul class="tools">
            <li> 公司名称:
                <input type="text" />
            </li>
            <li> 客户姓名:
                <input type="text" />
            </li>
            <li> 所属区域：
                <select>
                    <option>请选择省份</option>
                    <option>北京</option>
                    <option>江苏</option>
                    <option>天津</option>
                </select>
                <select>
                    <option>请选择城市</option>
                    <option>北京</option>
                    <option>南京</option>
                    <option>天津</option>
                </select>
            </li>
            <li class="subBut" onclick="window.location.href='customerList.html'"><img src="../../images/t06.png" />查询</li>
        </ul>
        <table class="tablelist">
            <thead>
            <tr>
                <th>序号</th>
                <th>客户姓名</th>
                <th>性别</th>
                <th>联系电话</th>
                <th>所属公司</th>
                <th>所属区域</th>
                <th>分配时间</th>
                <th>客服人员</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>王金平</td>
                <td>男</td>
                <td>17370899727</td>
                <td>阿里巴巴</td>
                <td>江苏南京</td>
                <td>2013-09-09 15:05:05</td>
                <td>管理员</td>
                <td>
                    <a href="customerView.html" class="tablelink">查看详情</a>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>张永祥</td>
                <td>女</td>
                <td>17370897894</td>
                <td>腾讯公司</td>
                <td>江苏南京</td>
                <td>2013-09-09 15:05:05</td>
                <td>管理员</td>
                <td>
                    <a href="customerView.html" class="tablelink">查看详情</a>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>王金平</td>
                <td>男</td>
                <td>17370899727</td>
                <td>阿里巴巴</td>
                <td>江苏南京</td>
                <td>2013-09-09 15:05:05</td>
                <td>管理员</td>
                <td>
                    <a href="customerView.html" class="tablelink">查看详情</a>
                </td>
            </tr>
            <tr>
                <td>4</td>
                <td>张永祥</td>
                <td>女</td>
                <td>17370897894</td>
                <td>腾讯公司</td>
                <td>江苏南京</td>
                <td>2013-09-09 15:05:05</td>
                <td>管理员</td>
                <td>
                    <a href="customerView.html" class="tablelink">查看详情</a>
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
