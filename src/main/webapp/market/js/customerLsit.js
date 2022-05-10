layui.use(['table', 'form'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery;
    //渲染表单元素
    form.render();
    //搜索栏下拉框初始化
    $.ajax({
        url: '/dept/getAllDeptList',
        data: {
            limit:100,
            page:1
        },
        dataType: 'json',
        type: 'post',
        success: function (data) {
            //下面会提到这个data是什么值
            //使用循环遍历，给下拉列表赋值
            $.each(data.data, function (index, value) {
                $('#dept').append(new Option(value.deptName, value.id));// 下拉菜单里添加元素

            });
            form.render("select");//重新渲染 固定写
        }
    });

    //分配
    form.on('select(dept)',function (data) {
        getRole(data.value);
    });

    form.on('select(role)',function (data) {
        var value = data.value;
        $.ajax({
            url: '/users/getEmpByRoleId',
            data: {
                roleId:value
            },
            dataType: 'json',
            type: 'post',
            success: function (data) {
                //下面会提到这个data是什么值
                //使用循环遍历，给下拉列表赋值
                $.each(data.data, function (index, value) {
                    $('#emp').append(new Option(value.empName, value.id));// 下拉菜单里添加元素
                });
                form.render("select");//重新渲染 固定写
            }
        });
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
        elem: '#CustomerTable',
        url: '/market/getAllCustomerList',
        height: 'full-90',
        cellMinWidth: 80,
        cols: [[ //表头
            {type: 'radio'},
            {field: 'id', title: '序号'},
            {field: 'customerName', title: '客户姓名'},
            {field: 'sex', title: '性别',templet:"<div>{{d.sex=='1'?'男':'女' }}</div>"},
            {field: 'phone', title: '联系电话'},
            {field: 'company', title: '所属公司'},
            {field: 'regionName', title: '所属区域',templet:function (customer) {return customer.region.regionName}},
            {field: 'status', title: '状态', templet:"<div>{{d.status=='1'?'可用':'不可用' }}</div>"},
            {field: 'createTime', title: '创建时间', templet: "<div>{{ layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss') }}</div>"},
            {field: 'creator', title: '创建人'},
            {field: 'allocateTime', title: '分配时间', templet: "<div>{{ layui.util.toDateString(d.allocateTime, 'yyyy-MM-dd HH:mm:ss') }}</div>"},
            {field: 'empName', title: '客服人员',templet:function (customer) {return customer.emp.empName}}


        ]],
        page: true //是否显示分页
        , limit: 10 //默认分页条数
        , limits: [10, 20, 30] //自定义分页数据选项
        , id: 'CustomerTable' //用于绑定模糊查询条件等等
        , /*done:function(res){
            var data = res.data;
        }*/
        done: function () {
            table.resize('CustomerTable');
        }
    });
    //查询
    $('.btn-search').on('click', function () {
        var company = $('#company1').val();
        var customerName = $('#customerName1').val();
        //var dept = $('#dept').val();
        var status = $('#status1').val();
        // console.log(empNo + "," + empName + "," + dept + "," + status);
        table.reload('CustomerTable', {
            url: '/market/getAllCustomerList',
            method: 'post',
            dataType: 'json',
            where: { //设定异步数据接口的额外参数，任意设
                company: company,
                customerName: customerName,
                //deptName: dept,
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
        // $('#empNo').attr('disabled', false);
        // $('#empNo').removeClass('layui-disabled');
        layer.open({
            type: 1,
            shift: 2,
            shade: 0,//遮罩
            title: '添加人员信息',
            area: ['570px', '600px'],
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
        getProvince('');
        getMaster();
        var cs = table.checkStatus('CustomerTable');
        var data = cs.data;
        var i = data.length;
        if (i === 1) {
            console.log(data)
            form.val('customer-form', data[0]);
            // $('#id').attr('disabled', true);
            // $('#id').addClass('layui-disabled');
            getCity('',data[0].parentId);
            $("#city").val(data[0].regionId)
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

    //分配
    $('.btn-allocate').on('click', function () {
        getMaster();
        var cs = table.checkStatus('CustomerTable');
        var data = cs.data;
        var i = data.length;
        if (i === 1) {
            console.log(data)
            form.val('allocate-form', data[0]);
            layer.open({
                type: 1,
                shift: 2,
                shade: 0,
                title: '分配客服人员信息',
                area: ['570px', '540px'],
                closeBtn: false,
                shadeClose: false,
                content: $('#allocate'),
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

    //删除(注销)
    $('.btn-del').on('click', function () {
        var cs = table.checkStatus('CustomerTable');
        var data = cs.data;
        var i = data.length;
        if (i < 1) {
            layer.msg('请选择需要注销的客户信息', {icon: 5});
            return;
        }
        layer.confirm('确定要注销选中的客户信息吗？', function (index) {
            $.ajax({
                url: '/market/delCustomer',
                type: 'post',
                data: {
                    id: data[0].id
                },
                dataType: 'json',
                success: function (resp) {
                    if (resp.success) {
                        table.reload('CustomerTable', {
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

    //查看详细信息

    table.on('tool(person-table)', function(obj) {
        if (obj.event == 'detail') {
            getSDetail(layer,obj.data);

        }
    })
    function getSDetail(layer,data){
        $("#detail").html("");
        layer.open({
            type: 1,
            shift: 2,
            shade: 0,
            title: '详细信息',
            area: ['520px', '520px'],
            closeBtn: false,
            shadeClose: false,
            content: $('#viewBox'),
            btnAlign: 'c',
            btn: ['关闭'],
            yes: function (index, layero) {
                layer.close(index);
            }
        });
    }
    $('.btn-detail').on('click', function () {
        var cs = table.checkStatus('CustomerTable');
        var data = cs.data;
        var i = data.length;
        if (i === 1) {
            console.log(data)
            form.val('customerView-form', data[0]);
            layer.open({
                type: 1,
                shift: 2,
                shade: 0,
                title: '详细客户信息',
                area: ['570px', '540px'],
                closeBtn: false,
                shadeClose: false,
                content: $('#viewBox'),
                btnAlign: 'c',
                btn: ['关闭'],
                yes: function (index, layero) {
                    layer.close(index);
                }
            });
            /* 渲染表单 */
            form.render();
        } else {
            layer.msg('请选择一条人员信息进行修改', {icon: 5});
        }
    });


    //提交监听，submit(save)对应的是提交按钮的lay-filter属性  提交修改 或 添加信息
    form.on('submit(save)', function (data) {
        var json_data = $("#CustomerForm").serializeObject();
        console.log(json_data);
        var f = $('#id').val();
        var url = '-';
        if (f!=null&&f!="") { //修改
            url = '/market/updateCustomer';
        } else {  //添加
            url = '/market/addCustomer';
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
                    table.reload('CustomerTable', {
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

    //提交监听，submit(save)对应的是提交按钮的lay-filter属性   提交分配信息
    form.on('submit(saveAllocate)', function (data) {
        var json_data = $("#AllocateForm").serializeObject();
        console.log(json_data);
        var url = '-';
        url = '/market/allocateCustomer';
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
                    table.reload('CustomerTable', {
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
    function getMaster(){
        $("#masterId").html("");
        $.ajax({
            url: '/users/getEmpByRoleId',
            type: 'post',
            data:{roleId:4},
            dataType:'json',
            async:false,
            success: function (resp) {
                $("#masterId").append(new Option("请选择",0));
                console.log(resp);
                $.each(resp.data, function (index, value) {
                    $("#masterId").append(new Option(value.empName,value.id));
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