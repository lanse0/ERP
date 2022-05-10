layui.use(['table', 'form'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery;
    //搜索栏下拉框初始化
    getProvince();
    //省份联动城市
    form.on('select(province)', function (data) {
        getCity(data.value);
    });

    //表格渲染
    table.render({
        elem: '#DeptTable',
        url: '/dept/getAllDeptList',
        height: 'full-225',
        cellMinWidth: 80,
        cols: [[ //表头
            {type: 'radio'},
            {field: 'id', title: '序号'},
            {field: 'deptNo', title: '部门编号'},
            {field: 'deptName', title: '部门名称'},
            {field: 'region', title: '所属地区', templet:function (dept) {
                    return dept.region.regionName
                }},
            {field: 'status', title: '状态', templet:'#checkStatus', unresize:true}
        ]],
        page: true //是否显示分页
        , limit: 10 //默认分页条数
        , limits: [10, 20, 30] //自定义分页数据选项
        , id: 'DeptTable' //用于绑定模糊查询条件等等
        , done: function () {
            table.resize('DeptTable');
        }
    });

    //监听状态操作
    form.on('switch(statusDemo)',function(obj){
        var id = this.value;
        var status = obj.elem.checked?'1':'2';
        // layer.tips(this.value + ' ' + this.name + ':' + obj.elem.checked, obj.othis);
        $.ajax({
            url: '/dept/updStatus',
            type: 'get',
            data:{
                id:id,
                status:status
            },
            dataType:'json',
            success:function (resp) {
                if (resp.success) {
                    table.reload('DeptTable', {
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
        var deptName = $('#deptSer').val();
        var provinceId = $('#provinceSer').val();
        var cityId = $('#citySer').val();
        table.reload('DeptTable', {
            url: '/dept/getAllDeptList',
            method: 'post',
            dataType: 'json',
            where: { //设定异步数据接口的额外参数，任意设
                deptName: deptName,
                provinceId: provinceId,
                cityId: cityId
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
            title: '添加部门信息',
            area: ['440px', '340px'],
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
        var cs = table.checkStatus('DeptTable');
        var data = cs.data;
        var i = data.length;
        if (i === 1) {
            form.val('dept-form', data[0]);
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

    //提交监听，submit(save)对应的是提交按钮的lay-filter属性
    form.on('submit(save)', function () {
        var json_data = $("#DeptForm").serializeObject();//将表单获取的值格式化为复杂对象格式的json
        console.log(json_data);
        var id = $('#id').val(); //id的值为空时用户进行了添加操作
        var url = '-';
        if (id!=null&&id!=="") { //修改
            url = '/dept/updDept';
        } else {  //添加
            url = '/dept/addDept';
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
                    table.reload('DeptTable', {
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

    //省份下拉框初始化方法
    function getProvince() {
        $.ajax({
            url: '/area/getProvince',
            type: 'post',
            dataType: 'json',
            success: function (resp) {
                console.log(resp);
                $(".province").append(new Option("请选择省份", 0));
                $.each(resp.data, function (index, value) {
                    $(".province").append(new Option(value.regionName, value.id));
                });
                form.render("select");
            }
        });
    }
    //城市下拉框初始化方法
    function getCity(pId) {
        $(".city").html("");
        $.ajax({
            url: '/area/getCityByPId',
            type: 'post',
            data: {id: pId},
            dataType: 'json',
            success: function (resp) {
                $(".city").append(new Option("请选择城市", pId));
                $.each(resp.data, function (index, value) {
                    $(".city").append(new Option(value.regionName, value.id));
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