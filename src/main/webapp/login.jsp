<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>ERP仓储管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>ERP仓储管理系统</span>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>

    <div class="loginbox loginbox1">

        <ul>
            <li><input name="userName" id="userName" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
            <li><input name="password" id="password" type="password" class="loginpwd" value="123" onclick="JavaScript:this.value=''"/></li>
            <li class="yzm">
                <span><input name="checkCode" id="checkCode" type="text" value="验证码"
                             onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite>
            </li>
            <li>
                <input name="" type="button" class="loginbtn" value="登录"
                       onclick="checkLogin()"/>
                <label><input name="" type="checkbox" value="" checked="checked"/>记住密码</label>
                <label><a href="#">忘记密码？</a></label>
            </li>
        </ul>


    </div>

</div>


<div class="loginbm">版权归北京千锋互联科技所有，仅供学习交流，勿用于任何商业用途</div>

<script type="text/javascript">
    function login() {
        javascript:window.location='main.jsp';
    }

    //登陆表单验证
    function checkLogin(){
        let uf = $('#userName').val();
        let pf = $('#password').val();
        let cf = $('#checkCode').val();
        if (uf===''){
            alert("请输入账号!");
            return;
        }
        if (pf===''){
            alert("请输入密码！");
            return;
        }
        if (cf===''||cf==='验证码'){
            alert("请输入验证码!");
            return;
        }
        login();
    }
</script>
</body>

</html>
