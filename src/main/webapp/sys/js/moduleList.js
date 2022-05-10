layui.use(['table', 'form'], function () {
    var table = layui.table,
        form = layui.form,
        layer = layui.layer,
        $ = layui.jquery;

    //初始化父模块下拉框
    getParent();

    //表格渲染
    table.render({
        elem: '#ModuleTable',
        url: '/modules/getAllModulesList',
        height: 'full-225',
        cellMinWidth: 80,
        cols: [[ //表头
            {type: 'radio'},
            {field: 'id', title: '序号'},
            {field: 'moduleName', title: '模块名称'},
            {field: 'parent', title: '父模块', templet:function (module) {
                    if(module.parent!=null){
                        return module.parent.moduleName;
                    }
                    return '无';
                }},
            {field: 'url', title: 'URL'},
            {field: 'status', title: '状态', templet:'#checkStatus', unresize:true}
        ]],
        page: true //是否显示分页
        , limit: 10 //默认分页条数
        , limits: [10, 20, 30] //自定义分页数据选项
        , id: 'ModuleTable' //用于绑定模糊查询条件等等
        , /*done:function(res){
            var data = res.data;
        }*/
        done: function () {
            table.resize('ModuleTable');
        }
    });

    //监听状态操作
    form.on('switch(statusDemo)',function(obj){
        var id = this.value;
        var status = obj.elem.checked?'1':'2';
        // layer.tips(this.value + ' ' + this.name + ':' + obj.elem.checked, obj.othis);
        $.ajax({
            url: '/modules/updStatus',
            type: 'get',
            data:{
                id:id,
                status:status
            },
            dataType:'json',
            success:function (resp) {
                if (resp.success) {
                    table.reload('ModuleTable', {
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
        var moduleName = $('#moduleSer').val();
        table.reload('ModuleTable', {
            url: '/modules/getAllModulesList',
            method: 'post',
            dataType: 'json',
            where: { //设定异步数据接口的额外参数，任意设
                moduleName: moduleName
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
            title: '添加模块信息',
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
        var cs = table.checkStatus('ModuleTable');
        var data = cs.data;
        var i = data.length;
        if (i === 1) {
            form.val('module-form', data[0]);
            layer.open({
                type: 1,
                shift: 2,
                shade: 0,
                title: '修改模块信息',
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
        var json_data = $("#ModuleForm").serializeObject();//将表单获取的值格式化为复杂对象格式的json
        console.log(json_data);
        var id = $('#id').val(); //id的值为空时用户进行了添加操作
        var url = '-';
        if (id!=null&&id!=="") { //修改
            url = '/modules/updModule';
        } else {  //添加
            url = '/modules/addModule';
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
                    table.reload('ModuleTable', {
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

    //初始化父模块下拉框
    function getParent() {
        $.ajax({
            url: '/modules/getSelect',
            dataType: 'json',
            type: 'get',
            success: function (data) {
                $('#parent').append(new Option("请选择父模块", 0));
                $.each(data.data, function (index, value) {
                    $('#parent').append(new Option(value.moduleName, value.id));// 下拉菜单里添加元素
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