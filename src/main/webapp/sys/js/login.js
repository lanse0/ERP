layui.use(['form'], function () {
    var form = layui.form,
        $ = layui.jquery;

    $('.loginbtn').on('click', function () {
        checkLogin();
    });
    $('#codeImg').on('click',function () {
        console.log(Math.random());
        $('#codeImg').attr('src','/captcha/verification?id='+Math.random());
    });

    //验证通过后进行登陆验证
    function login(userName, password, checkCode) {
        $.ajax({
            url: '/users/login',
            type: 'post',
            data: {
                userName: userName,
                password: password,
                code: checkCode
            },
            dataType: 'json',
            success: function (resp) {
                let flag = resp.success;
                if (flag) {
                    window.location.href='/main.jsp';
                } else {
                    layer.msg(resp.message, {icon: 5});
                }
            }
        });
    }
    //登陆输入验证
    function checkLogin() {
        let uf = $('#userName').val();
        let pf = $('#password').val();
        let cf = $('#checkCode').val();
        if (uf === '') {
            alert("请输入账号!");
            return;
        }
        if (pf === '') {
            alert("请输入密码！");
            return;
        }
        if (cf === '' || cf === '验证码') {
            alert("请输入验证码!");
            return;
        }
        login(uf, pf, cf);
    }
});