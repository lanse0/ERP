<%--
  Created by IntelliJ IDEA.
  User: AJM
  Date: 2022/5/4
  Time: 21:54
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
        function allottipOpen() {
            $("#allottip").fadeIn(200);
        }
        function allottipclose() {
            $("#allottip").fadeOut(200);
        }
    </script>
</head>

<body>
<div class="place"> <span>位置：</span>
    <ul class="placeul">
        <li>营销管理</li>
        <li>客户管理</li>
        <li>基本内容</li>
    </ul>
</div>
<div class="rightinfo">
    <form action="" method="post">
        <ul class="tools">
            <li> 公司名称:
                <input type="text" size="12" />
            </li>
            <li> 客户姓名:
                <input type="text" size="12" />
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
            <li> 状态：
                <select>
                    <option>请选择     </option>
                    <option value="1">可用</option>
                    <option value="0">不可用</option>
                </select>
            </li>
            <li> 是否分配：
                <select>
                    <option>请选择     </option>
                    <option value="1">已分配</option>
                    <option value="0">未分配</option>
                </select>
            </li>
            <li class="subBut" onclick="window.location.href='customerList.html'"><img src="../../images/t06.png" />查询</li>
            <li class="subBut" onclick="window.location.href='customerAdd.html'"><img src="../../images/t01.png" />添加</li>
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
                <th>状态</th>
                <th>创建时间</th>
                <th>创建人</th>
                <th>分配时间</th>
                <th>客户人员</th>
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
                <td>可用</td>
                <td>2013-09-09 15:05:05</td>
                <td>管理员</td>
                <td></td>
                <td></td>
                <td>
                    <a href="customerView.html" class="tablelink">查看详情</a>
                    <a href="customerUpdate.html" class="tablelink">修改</a>
                    <a href="javascript:void(0)" class="tablelink" onclick="tipOpen('是否确认注销此条信息？')">注销</a>
                    <a href="javascript:void(0);" class="tablelink" onclick="allottipOpen()">分配</a>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>张永祥</td>
                <td>女</td>
                <td>17370897894</td>
                <td>腾讯公司</td>
                <td>江苏南京</td>
                <td>不可用</td>
                <td>2013-09-09 15:05:05</td>
                <td>管理员</td>
                <td>2013-09-09 15:05:05</td>
                <td>关羽</td>
                <td>
                    <a href="customerView.html" class="tablelink">查看详情</a>
                    <a href="javascript:void(0)" class="tablelink" onclick="tipOpen('是否确认恢复此条信息？')">恢复</a>
                    <a href="javascript:void(0);" class="tablelink" onclick="allottipOpen()">分配</a>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>王金平</td>
                <td>男</td>
                <td>17370899727</td>
                <td>阿里巴巴</td>
                <td>江苏南京</td>
                <td>可用</td>
                <td>2013-09-09 15:05:05</td>
                <td>管理员</td>
                <td></td>
                <td></td>
                <td>
                    <a href="customerView.html" class="tablelink">查看详情</a>
                    <a href="customerUpdate.html" class="tablelink">修改</a>
                    <a href="javascript:void(0)" class="tablelink" onclick="tipOpen('是否确认注销此条信息？')">注销</a>
                    <a href="javascript:void(0);" class="tablelink" onclick="allottipOpen()">分配</a>
                </td>
            </tr>
            <tr>
                <td>4</td>
                <td>张永祥</td>
                <td>女</td>
                <td>17370897894</td>
                <td>腾讯公司</td>
                <td>江苏南京</td>
                <td>不可用</td>
                <td>2013-09-09 15:05:05</td>
                <td>管理员</td>
                <td>2013-09-09 15:05:05</td>
                <td>关羽</td>
                <td>
                    <a href="customerView.html" class="tablelink">查看详情</a>
                    <a href="javascript:void(0)" class="tablelink" onclick="tipOpen('是否确认恢复此条信息？')">恢复</a>
                    <a href="javascript:void(0);" class="tablelink" onclick="allottipOpen()">分配</a>
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
    <!-- 提示框 -->
    <div id="tip" class="tip">
        <div class="tiptop"><span>提示信息</span><a onclick="tipClose()"></a></div>
        <div class="tipinfo"> <span><img src="../../images/ticon.png" /></span>
            <div class="tipright">
                <p></p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite> </div>
        </div>
        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" onclick="tipClose()" />
            &nbsp;
            <input name="" type="button"  class="cancel" value="取消" onclick="tipClose()" />
        </div>
    </div>
    <!-- 审批提示框 -->
    <div id="allottip" class="tip">
        <div class="tiptop">
            <span>提示信息</span><a onclick="allottipclose()"></a>
        </div>
        <div class="tipinfo1">

            部门：
            <select class="dfselect" disabled="disabled">
                <option>请选择</option>
                <option selected="selected">市场部</option>
                <option>采购部</option>
                <option>财务部</option>
            </select>
            <p/>
            职位：
            <select class="dfselect">
                <option>请选择</option>
                <option>一组组员</option>
                <option>二组组员</option>
                <option>三组组员</option>
            </select>
            <p/>
            姓名：
            <select class="dfselect">
                <option>请选择</option>
                <option>刘备</option>
                <option>曹操</option>
            </select>
            <p/>
        </div>
        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" onclick="allottipclose()" />
            &nbsp;
            <input name="" type="button"  class="cancel" value="取消" onclick="allottipclose()" />
        </div>
    </div>
</div>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>

