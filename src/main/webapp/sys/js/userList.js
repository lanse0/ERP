layui.use(['table', 'form'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery;
    //渲染表单元素
    //form.render();
    //搜索栏下拉框初始化
    $.ajax({
        url: '/dept/getSelectDept',
        dataType: 'json',
        type: 'get',
        success: function (data) {
            //下面会提到这个data是什么值
            //使用循环遍历，给下拉列表赋值
            $.each(data.data, function (index, value) {
                $('#dept').append(new Option(value.deptName, value.deptName));// 下拉菜单里添加元素
            });
            form.render("select");//重新渲染 固定写
        }
    });
    //省份下拉框
    getProvince();
    //省份联动城市
    form.on('select(province)', function (data) {
        getCity(data.value);
        getDept(data.value);
    });
    //城市联动部门
    form.on('select(city)', function (data) {
        getDept(data.value);
    });
    //部门联动职位
    form.on('select(dept1)', function (data) {
        getRole(data.value);
    });

    //表格渲染
    table.render({
        elem: '#EmpTable',
        url: '/users/getAllEmpList',
        height: 'full-90',
        cellMinWidth: 80,
        cols: [[ //表头
            {type: 'radio'},
            {field: 'id', title: '序号'},
            {field: 'empNo', title: '员工编号'},
            {field: 'empName', title: '员工姓名'},
            {field: 'userName', title: '账号'},
            {field: 'phone', title: '联系电话'},
            {field: 'deptName', title: '所属部门'},
            {field: 'roleName', title: '职位'},
            {field: 'sex', title: '性别'},
            {field: 'age', title: '年龄'},
            {field: 'status', title: '状态'},
            {field: 'hireDate', title: '入职时间', width: 120, templet: "<div>{{ layui.util.toDateString(d.hireDate, 'yyyy-MM-dd') }}</div>" },
            // {field: 'termDate', title: '离职时间', width: 120, templet: '<div>{{# if(d.termDate){}} {{layui.util.toDateString(d.termDate, "yyyy-MM-dd") }} {{#} else{}} {{#}}}</div>' }
            {field: 'termDate', title: '离职时间', width: 120, templet: "<div>{{# if(d.termDate){}} {{layui.util.toDateString(d.hireDate, 'yyyy-MM-dd') }} {{#} else{}} {{#}}}</div>" }
        ]],
        page: true //是否显示分页
        , limit: 10 //默认分页条数
        , limits: [10, 20, 30] //自定义分页数据选项
        , id: 'EmpTable' //用于绑定模糊查询条件等等
        , /*done:function(res){
            var data = res.data;
        }*/
        done: function () {
            table.resize('EmpTable');
        }
    });
    //查询
    $('.btn-search').on('click', function () {
        var empNo = $('#empNo1').val();
        var empName = $('#empName1').val();
        var dept = $('#dept').val();
        var status = $('#status').val();
        // console.log(empNo + "," + empName + "," + dept + "," + status);
        table.reload('EmpTable', {
            url: '/users/getAllEmpList',
            method: 'post',
            dataType: 'json',
            where: { //设定异步数据接口的额外参数，任意设
                empNo: empNo,
                empName: empName,
                deptName: dept,
                status: status
            },
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    //添加人员
    $('.btn-add').on('click', function () {
        $('.form-reset').click();
        $('#empNo').attr('disabled', false);
        $('#empNo').removeClass('layui-disabled');
        layer.open({
            type: 1,
            shift: 2,
            shade: 0,//遮罩
            title: '添加人员信息',
            area: ['570px', '540px'],
            closeBtn: false,
            shadeClose: false,
            content: $('#box'),
            btnAlign: 'c',
            btn: ['保存', '关闭'],
            yes: function (index, layero) {
                layero.find('.form-save').click();
                return false; //开启该代码可禁止点击该按钮关闭弹窗
            },
            btn2: function (index, layero) {
                //默认关闭弹窗
            }
        });
        form.render();
    });

    //修改
    $('.btn-edit').on('click', function () {
        var cs = table.checkStatus('EmpTable');
        var data = cs.data;
        var i = data.length;
        if (i === 1) {
            form.val('emp-form', data[0]);
            $('#empNo').attr('disabled', true);
            $('#empNo').addClass('layui-disabled');
            layer.open({
                type: 1,
                shift: 2,
                shade: 0,
                title: '修改人员信息',
                area: ['570px', '540px'],
                closeBtn: false,
                shadeClose: false,
                content: $('#box'),
                btnAlign: 'c',
                btn: ['保存', '关闭'],
                yes: function (index, layero) {
                    layero.find('.form-save').click();
                    return false; //开启该代码可禁止点击该按钮关闭弹窗
                },
                btn2: function (index, layero) {
                    //默认关闭弹窗
                }
            });
            /* 渲染表单 */
            form.render();
        } else {
            layer.msg('请选择一条人员信息进行修改', {icon: 5});
        }
    });

    //删除(离职)
    $('.btn-quit').on('click', function () {
        var cs = table.checkStatus('EmpTable');
        var data = cs.data;//获取单选框勾选的数据
        var i = data.length;//数据条数
        if (i < 1) {//数据条数小于1  用户未勾选数据
            layer.msg('请选择需要毕业的人员', {icon: 5});
            return;
        }
        layer.confirm('确定要毕业选中的人员吗？', function (index) {
            $.ajax({
                url: '/users/quitEmp',
                type: 'post',
                data: {
                    id: data[0].id
                },
                dataType: 'json',
                success: function (resp) {
                    if (resp.success) {
                        table.reload('EmpTable', {
                            where: {},
                            page: {
                                curr: 1 //重新从第 1 页开始
                            }
                        });
                        layer.msg(resp.message, {icon: 6});
                    } else {
                        layer.msg(resp.message, {icon: 5});
                    }
                }
            });
        });
    });

    //提交监听，submit(save)对应的是提交按钮的lay-filter属性
    form.on('submit(save)', function (data) {
        var json_data = $("#EmpForm").serializeObject();
        console.log(json_data);
        var f = $('#empNo').is(":disabled");
        var url = '-';
        if (f) { //修改
            url = '/users/updEmp';
        } else {  //添加
            url = '/users/addEmp';
        }
        layer.load(1);
        $.ajax({
            url: url,
            // data: JSON.stringify(data.field),
            data: JSON.stringify(json_data),
            type: 'post',
            dataType: 'json',
            contentType: "application/json",
            success: function (resp) {
                layer.closeAll('loading');
                var flag = resp.success;
                if (flag) {
                    table.reload('EmpTable', {
                        where: {},
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                    });
                    layer.msg(resp.message, {icon: 6});
                } else {
                    layer.msg(resp.message, {icon: 5});
                }
            },
            error: function () {
                layer.closeAll('loading');
                layer.msg('系统错误，请联系管理员', {icon: 5});
            }
        });
        return false;
    });

    function getProvince() {
        $.ajax({
            url: '/area/getProvince',
            type: 'post',
            dataType: 'json',
            success: function (resp) {
                console.log(resp);
                $("#province").append(new Option("请选择省份", 0));
                $.each(resp.data, function (index, value) {
                    $("#province").append(new Option(value.regionName, value.id));
                });
                form.render("select");
            }
        });
    }

    function getCity(pId) {
        $("#city").html("");
        $.ajax({
            url: '/area/getCityByPId',
            type: 'post',
            data: {id: pId},
            dataType: 'json',
            success: function (resp) {
                $("#city").append(new Option("请选择城市", pId));
                console.log(resp);
                $.each(resp.data, function (index, value) {
                    $("#city").append(new Option(value.regionName, value.id));
                });
                form.render("select");
            }
        });
    }

    function getDept(regionId) {
        //清空之前的内容
        $("#dept1").html("");
        $.ajax({
            url: '/dept/getDeptByRegion',
            type: 'post',
            data: {regionId: regionId},
            dataType: 'json',
            success: function (data) {
                $("#dept1").append(new Option("请选择部门", ''));
                $.each(data.data, function (index, value) {
                    $("#dept1").append(new Option(value.deptName, value.id));
                });
                form.render("select");
            }
        });
    }

    function getRole(deptId) {
        //清空之前的内容
        $("#role").html("");
        $.ajax({
            url: '/role/getRoleByDept',
            type: 'post',
            data: {deptId: deptId},
            dataType: 'json',
            success: function (data) {
                $("#role").append(new Option("请选择职位", ''));
                $.each(data.data, function (index, value) {
                    $("#role").append(new Option(value.roleName, value.id));
                });
                form.render("select");
            }
        });
    }


    //自定义serializeObject ()函数，格式化
    $.fn.serializeObject = function () {
        const o = {};
        const a = this.serializeArray();
        $.each(a, function () {
            //增加嵌套属性支持
            const names = this.name.split(".")
            let temp = o;
            const end = (names.length - 1);
            //为了支持强制指定单值也可以为json array类型
            const jsonType = $('[name="' + this.name + '"]').data("json-type");
            const jsonArray = jsonType && (jsonType === 'array');
            names.forEach((item, index, array) => {
                if (temp[item]) {
                    if (index == end) {
                        if (!temp[item].push) {
                            temp[item] = [temp[item]];
                        }
                        temp[item].push(this.value || '');
                    }
                } else {
                    if (index == end) {
                        temp[item] = jsonArray ? [this.value || ''] : (this.value || '');
                    } else {
                        temp[item] = jsonArray ? [] : {};
                    }
                }
                temp = temp[item];
            })
        });
        return o;
    };

});