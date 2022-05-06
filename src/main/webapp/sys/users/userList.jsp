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
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
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
<div class="place"><span>位置：</span>
    <ul class="placeul">
        <li><a href="#">系统管理</a></li>
        <li><a href="#">用户管理</a></li>
    </ul>
</div>
<div class="rightinfo">
    <form action="" method="post">
        <ul class="tools">
            <li><label>员工编号:</label>
                <input type="text"/>
            </li>
            <li><label>员工姓名:</label>
                <input type="text"/>
            </li>
            <li><label>所属部门：</label>
                <select name="">
                    <option>请选择部门</option>
                    <option value="">研发</option>
                    <option value="">销售</option>
                    <option value="">财务</option>
                </select>
            </li>
            <li><label>状态：</label>
                <select name="">
                    <option>请选择</option>
                    <option value="1">在职</option>
                    <option value="0">离职</option>
                </select>
            </li>
            <li class="subBut" onclick=""><img src="images/t06.png"/>查询</li>
            <li class="subBut" onclick="showBody('sys/users/userAdd.html')"><img src="images/t01.png"/>添加</li>
        </ul>
        <tablze class="tablelist">
            <thead>
            <tr>
                <th>序号</th>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>联系电话</th>
                <th>所属部门</th>
                <th>职位</th>
                <th>性别</th>
                <th>年龄</th>
                <th>状态</th>
                <th>入职时间</th>
                <th>离职时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>2</td>
                <td>9528</td>
                <td>唐寅</td>
                <td>17370899727</td>
                <td>研发部</td>
                <td>高级工程师</td>
                <td>男</td>
                <td>28</td>
                <td>在职</td>
                <td>2013-09-09 15:05:05</td>
                <td>2013-09-09 15:05:05</td>
                <td>
                    <a href="userUpdate.html" class="tablelink">修改</a>
                </td>
            </tr>
            </tbody>
        </tablze>
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
    <!-- 提示框 -->
    <div id="tip" class="tip">
        <div class="tiptop"><span>提示信息</span><a onclick="tipClose()"></a></div>
        <div class="tipinfo"><span><img src="images/ticon.png"/></span>
            <div class="tipright">
                <p></p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite></div>
        </div>
        <div class="tipbtn">
            <input name="" type="button" class="sure" value="确定" onclick="tipClose()"/>
            &nbsp;
            <input name="" type="button" class="cancel" value="取消" onclick="tipClose()"/>
        </div>
    </div>
</div>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
