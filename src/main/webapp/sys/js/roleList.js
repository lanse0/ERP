layui.use(['table', 'form', 'tree', 'util'], function () {
    var table = layui.table,
        form = layui.form,
        tree = layui.tree,
        util = layui.util,
        layer = layui.layer,
        $ = layui.jquery;

    //部门初始化
    getDept();
    getDeptAdd();

    //表格渲染
    table.render({
        elem: '#RoleTable',
        url: '/role/getAllRoleList',
        height: 'full-225',
        cellMinWidth: 80,
        cols: [[ //表头
            {type: 'radio'},
            {field: 'id', title: '序号'},
            {field: 'roleName', title: '职位名称'},
            {
                field: 'department', title: '所属部门', templet: function (role) {
                    return role.department.deptName
                }
            },
            {field: 'status', title: '状态', templet: '#checkStatus'}
        ]],
        page: true //是否显示分页
        , limit: 10 //默认分页条数
        , limits: [10, 20, 30] //自定义分页数据选项
        , id: 'RoleTable' //用于绑定模糊查询条件等等
        , /*done:function(res){
            var data = res.data;
        }*/
        done: function () {
            table.resize('RoleTable');
        }
    });

    //监听状态操作
    form.on('switch(statusDemo)', function (obj) {
        var id = this.value;
        var status = obj.elem.checked ? '1' : '2';
        $.ajax({
            url: '/role/updStatus',
            type: 'get',
            data: {
                id: id,
                status: status
            },
            dataType: 'json',
            success: function (resp) {
                if (resp.success) {
                    table.reload('RoleTable', {
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

    //查询
    $('.btn-search').on('click', function () {
        var roleName = $('#roleSer').val();
        var deptNo = $('#deptSer').val();
        table.reload('RoleTable', {
            url: '/role/getAllRoleList',
            method: 'post',
            dataType: 'json',
            where: { //设定异步数据接口的额外参数，任意设
                roleName: roleName,
                deptNo: deptNo
            },
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    //添加
    $('.btn-add').on('click', function () {
        $('.form-reset').click();
        layer.open({
            type: 1,
            shift: 2,
            shade: 0,//遮罩
            title: '添加职位信息',
            area: ['360px', '300px'],
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
        var cs = table.checkStatus('RoleTable');
        var data = cs.data;
        var i = data.length;
        if (i === 1) {
            console.log(data[0]);
            form.val('role-form', data[0]);
            var dept = data[0].department;//data为复杂对象数据 先提取出部门
            $('#department').val(dept.id);//数据回显 修改角色勾选部门
            layer.open({
                type: 1,
                shift: 2,
                shade: 0,
                title: '修改职位信息',
                area: ['360px', '300px'],
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
            layer.msg('请选择一条信息进行修改', {icon: 5});
        }
    });

    //提交监听，submit(save)对应的是提交按钮的lay-filter属性
    form.on('submit(save)', function () {
        var json_data = $("#RoleForm").serializeObject();//将表单获取的值格式化为复杂对象格式的json
        console.log(json_data);
        var id = $('#id').val(); //id的值为空时用户进行了添加操作
        var url = '-';
        if (id != null && id !== "") { //修改
            url = '/role/updRole';
        } else {  //添加
            url = '/role/addRole';
        }
        layer.load(1);
        $.ajax({
            url: url,
            data: JSON.stringify(json_data),
            type: 'post',
            dataType: 'json',
            contentType: "application/json",
            success: function (resp) {
                layer.closeAll('loading');
                var flag = resp.success;
                if (flag) {
                    table.reload('RoleTable', {
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

    //获取模块数据
    function getData() {
        var data = [];
        $.ajax({
            url: "modules/treeload",    //后台数据请求地址
            type: "post",
            async: false,
            success: function (result) {
                data = JSON.parse(result);
            }
        });
        console.log(data);
        return data;
    }
    //获取角色权限数组
    function getModuleArray(roleId){
        var array = [];
        $.ajax({
            url: "/role/getModuleArray",    //后台数据请求地址
            type: "post",
            async: false,
            data:{
                roleId:roleId
            },
            success: function (result) {
                array = JSON.parse(result);
            }
        });
        console.log(array);
        return array;
    }
    //赋值数据回显
    $('.btn-auth').on('click', function () {
        //赋权复选框初始化
        tree.render({
            elem: '#test5',
            checkChirld:false,//是否需要关联子节点 需要修改tree.js文件
            data: getData(),
            id: 'treeId',
            showCheckbox: true,
            click: function (obj) {
                var data = obj.data;  //获取当前点击的节点数据
                // layer.msg('状态：' + obj.state + '<br>节点数据：' + JSON.stringify(data));
            }
        });
        var cs = table.checkStatus('RoleTable');
        var data = cs.data;
        var i = data.length;
        if (i === 1) {
            form.val('auth-form', data[0]);
            var roleId = $('#roleId').val();
            console.log(roleId);
            var array = getModuleArray(roleId);
            tree.setChecked('treeId',array);
            layer.open({
                type: 1,
                shift: 2,
                shade: 0,
                title: '赋权',
                area: ['360px', '400px'],
                closeBtn: false,
                shadeClose: false,
                content: $('#authBox'),
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
            layer.msg('请选择一条信息进行修改', {icon: 5});
        }
    });
    //监听赋值
    form.on('submit(saveAuth)', function (data) {
        console.log(data.field);
        var moduleData = data.field
        // var moduleData = tree.getChecked('treeId');
        console.log(JSON.stringify(moduleData));
        var id = $('#id').val(); //获取操作了哪个角色
        layer.load(1);
        $.ajax({
            url: '/role/addModuleList',
            data: JSON.stringify(moduleData),
            type: 'post',
            dataType: 'json',
            contentType: "application/json",
            success: function (resp) {
                layer.closeAll('loading');
                var flag = resp.success;
                if (flag) {
                    // table.reload('RoleTable', {
                    //     where: {},
                    //     page: {
                    //         curr: 1 //重新从第 1 页开始
                    //     }
                    // });
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

    //部门下拉框初始化方法
    function getDept() {
        $.ajax({
            url: '/dept/getSelectDept',
            dataType: 'json',
            type: 'get',
            success: function (data) {
                $('#deptSer').append(new Option("请选择部门", 0));
                $.each(data.data, function (index, value) {
                    $('#deptSer').append(new Option(value.deptName, value.deptNo));// 下拉菜单里添加元素
                });
                form.render("select");//重新渲染 固定写
            }
        });
    }

    function getDeptAdd() {
        $.ajax({
            url: '/dept/getSelectDept',
            dataType: 'json',
            type: 'get',
            success: function (data) {
                $('#department').append(new Option("请选择部门", 0));
                $.each(data.data, function (index, value) {
                    $('#department').append(new Option(value.deptName, value.id));// 下拉菜单里添加元素
                });
                form.render("select");//重新渲染 固定写
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