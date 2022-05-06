layui.use(['table', 'form'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery;
    //渲染表单元素
    form.render();
    //下拉框初始化
    $.ajax({
        url: '/dept/getSelectDept',
        dataType: 'json',
        type: 'get',
        success: function (data) {
            console.log(data);//下面会提到这个data是什么值
            //使用循环遍历，给下拉列表赋值
            $.each(data.data, function (index, value) {
                // console.log(value.department_id);
                $('#dp').append(new Option(value.department_name, value.department_id));// 下拉菜单里添加元素
            });
            layui.form.render("select");//重新渲染 固定写
        }
    });
    //表格渲染
    table.render({
        elem: '#EmpTable',
        url:'/users/getAllEmpList',
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
            {field: 'hireDate', title: '入职时间'},
            {field: 'termDate', title: '离职时间'}
        ]],
        page: true //是否显示分页
        , limit: 10 //默认分页条数
        , limits: [10, 20, 30] //自定义分页数据选项
        , id: 'PersonTable' //用于绑定模糊查询条件等等
        , /*done:function(res){
            var data = res.data;
        }*/
        done: function () {
            table.resize('PersonTable');
        }
    });
    //查询
    $('.btn-search').on('click', function () {
        var p_name = $('#p_name').val();
        var p_id = $('#p_id').val();
        table.reload('PersonTable', {
            url: 'getAllPersonList',
            method: 'post',
            dataType: 'json',
            where: { //设定异步数据接口的额外参数，任意设
                name: p_name,
                id: p_id
            },
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    //添加人员
    $('.btn-add').on('click', function () {
        $('.form-reset').click();
        $('#pid').attr('disabled', true);
        $('#pid').removeClass('layui-disabled');
        layer.open({
            type: 1,
            shift: 2,
            title: '添加人员信息',
            area: ['370px', '340px'],
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
        var cs = table.checkStatus('PersonTable');
        var data = cs.data;
        var i = data.length;
        if (i === 1) {
            form.val('person-form', data[0]);
            $('#pid').attr('disabled', true);
            $('#pid').addClass('layui-disabled');
            layer.open({
                type: 1,
                shift: 2,
                title: '修改人员信息',
                area: ['370px', '340px'],
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

    //删除
    $('.btn-del').on('click', function () {
        var cs = table.checkStatus('PersonTable');
        var data = cs.data;
        var i = data.length;
        if (i < 1) {
            layer.msg('请选择需要删除的人员信息', {icon: 5});
            return;
        }
        layer.confirm('确定要删除选中的人员信息吗？', function (index) {
            $.ajax({
                url: 'deletePerson',
                type: 'post',
                data: {
                    id: data[0].id
                },
                dataType: 'json',
                success: function (resp) {
                    if (resp.success) {
                        table.reload('PersonTable', {
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
        var f = $('#pid').is(":disabled");
        var url = '-';
        if (f) { //修改
            url = 'updatePerson';
        } else {  //添加
            url = 'addPerson';
        }
        layer.load(1);
        $.ajax({
            url: url,
            data: JSON.stringify(data.field),
            type: 'post',
            dataType: 'json',
            contentType:"application/json",
            success: function (resp) {
                layer.closeAll('loading');
                var flag = resp.success;
                if (flag) {
                    table.reload('PersonTable', {
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
});