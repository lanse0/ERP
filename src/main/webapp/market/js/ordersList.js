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

    //订单表格渲染
    table.render({
        elem: '#OrdersTable',
        url: '/orders/findByOrdersPage',
        height: 'full-90',
        cellMinWidth: 80,
        cols: [[ //表头
            {type: 'radio'},
            {field: 'id', title: '序号',event:'detail',templet: "<div>{{d.id+'(查看详情)'}}</div>"},
            {field: 'ordersNo', title: '订单编号'},
            {field: 'customerName', title: '客户姓名',templet:function (orders) {return orders.customer.customerName}},
            {field: 'phone', title: '联系电话',templet:function (orders) {return orders.customer.phone}},
            {field: 'amount', title: '订单金额'},
            {field: 'orderTime', title: '订购时间', templet: "<div>{{ layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss') }}</div>"},
            {field: 'status', title: '状态', templet:function (orders) { var status =orders.status;switch (status) {case "1":status="未审核";break;
                    case "2":status="审核中";break;case "3":status="审核通过";break;case "4":statsu="审核不通过";break;} return status}},
            {field: 'auditTime', title: '审核时间', templet: "<div>{{ layui.util.toDateString(d.allocateTime, 'yyyy-MM-dd HH:mm:ss') }}</div>"},
            {field: 'empName', title: '审核人员',templet:function (orders) {return orders.emp.empName}}
        ]],
        page: true //是否显示分页
        , limit: 10 //默认分页条数
        , limits: [10, 20, 30] //自定义分页数据选项
        , id: 'OrdersTable' //用于绑定模糊查询条件等等
        , /*done:function(res){
            var data = res.data;
        }*/
        done: function () {
            table.resize('OrdersTable');
        }
    });

    //查询
    $('.btn-search').on('click', function () {
        var ordersNo = $('#ordersNo1').val();
        var customerName = $('#customerName1').val();
        //var dept = $('#dept').val();
        var status = $('#status1').val();
        // console.log(empNo + "," + empName + "," + dept + "," + status);
        table.reload('OrdersTable', {
            url: '/orders/findByOrdersPage',
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
        $.ajax({
            url: '/orders/getOrdersNo',
            dataType: 'json',
            async:true,
            type: 'post',
            success: function (data) {
                //alert(data.message);
             $("#ordersNo").val(data.message);
            }
        });
        form.render();
        $('.form-reset').click();
        // $('#empNo').attr('disabled', false);
        // $('#empNo').removeClass('layui-disabled');
        layer.open({
            type: 1,
            shift: 2,
            shade: 0,//遮罩
            title: '添加人员信息',
            area: ['950px', '600px'],
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
    table.on('tool(person-table)', function(obj) {
        if (obj.event == 'detail') {
            $.ajax({
                url: '/orders/getOrdersById',
                type: 'post',
                data: {
                    id: obj.data.id
                },
                dataType: 'json',
                success: function (resp) {
                    getSDetail(layer,resp.data);
                }
            });

        }
    })

    $('.btn-edit').on('click', function () {
        getProvince('');
        getMaster();
        $.ajax({
            url: '/orders/getOrdersById',
            type: 'post',
            data: {
                id: obj.data.id
            },
            dataType: 'json',
            success: function (resp) {
                getSDetail(layer,resp.data);
            }
        });
        var cs = table.checkStatus('OrdersTable');
        var data = cs.data;
        var i = data.length;
        if (i === 1) {
            console.log(data)
            form.val('orders-form', data[0]);
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


    //删除(注销)
    $('.btn-del').on('click', function () {
        var cs = table.checkStatus('OrdersTable');
        var data = cs.data;
        var i = data.length;
        if (i < 1) {
            layer.msg('请选择需要删除的订单信息', {icon: 5});
            return;
        }
        layer.confirm('确定要注销选中的订单信息吗？', function (index) {
            $.ajax({
                url: '/orders/delOrders',
                type: 'post',
                data: {
                    id: data[0].id
                },
                dataType: 'json',
                success: function (resp) {
                    if (resp.success) {
                        table.reload('OrdersTable', {
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
            $.ajax({
                url: '/orders/getOrdersById',
                type: 'post',
                data: {
                    id: obj.data.id
                },
                dataType: 'json',
                success: function (resp) {
                    getSDetail(layer,resp.data);
                }
            });

        }
    })

    function getStatus(data) {
        var status=null;
        switch (data) {
            case "1":status="未审核";break;
            case "2":status="审核中";break;
            case "3":status="审核通过";break;
            case "4":status="审核不通过";break;

        }
        return status;
    }

    function getSDetail(layer,data){
        $("#detail").html("");
        $("#detail").append(
            "        <li>\n" +
            "            <label>序号</label>\n" +
            "            <cite>"+data.id+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>订单编号</label>\n" +
            "            <cite>"+data.ordersNo+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>客户姓名</label>\n" +
            "            <cite>"+data.customer.customerName+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>客户电话</label>\n" +
            "            <cite>"+data.customer.phone+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>订购时间</label>\n" +
            "            <cite>"+layui.util.toDateString(data.orderTime, 'yyyy-MM-dd HH:mm:ss')+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>订购金额</label>\n" +
            "            <cite>"+data.amount+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>操作人</label>\n" +
            "            <cite>"+data.emp.empName+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>审核状态</label>\n" +
            "            <cite>"+getStatus(data.status)+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>审核内容</label>\n" +
            "            <cite>"+(data.auditContext==null?'':data.auditContext)+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>审核时间</label>\n" +
            "            <cite>"+layui.util.toDateString(data.auditTime, 'yyyy-MM-dd HH:mm:ss')+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>商品品牌</label>\n" +
            "            <cite>"+(data.brand==null?'':data.brand)+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>商品类型</label>\n" +
            "            <cite>"+(data.brandType==null?'':data.brandType)+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>商品型号</label>\n" +
            "            <cite>"+(data.brandModel==null?'':data.brandModel)+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>商品数量</label>\n" +
            "            <cite>"+(data.number==null?'':data.number)+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>商品价格</label>\n" +
            "            <cite>"+(data.price==null?'':data.price)+"</cite>\n" +
            "        </li>\n" +
            "        <li>\n" +
            "            <label>总金额</label>\n" +
            "            <cite>"+data.amount+"</cite>\n" +
            "        </li>");
        layer.open({
            type: 1,
            shift: 2,
            shade: 0,
            title: '详细信息',
            area: ['520px', '520px'],
            closeBtn: false,
            shadeClose: false,
            content: $('#detail'),
            btnAlign: 'c',
            btn: ['关闭'],
            yes: function (index, layero) {
                layer.close(index);
            }
        });
    }


    //提交监听，submit(save)对应的是提交按钮的lay-filter属性  提交修改 或 添加信息
    form.on('submit(save)', function (data) {
        var json_data = $("#OrdersForm").serializeObject();
        console.log(json_data);
        var f = $('#id').val();
        var url = '-';
        if (f!=null&&f!="") { //修改
            url = '/orders/updateOrders';
        } else {  //添加
            url = '/orders/addOrders';
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
                    table.reload('OrdersTable', {
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


    $(function (){
        $("input").blur(function (){
            var sum = parseInt($("#price").val()) * parseInt($("#number").val());
            $("#amount").val(sum);
        })
    })

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

    function today(){//构建方法
        var today=new Date();//new 出当前时间
        var h=today.getFullYear();//获取年
        var m=today.getMonth()+1;//获取月
        var d=today.getDate();//获取日
        var H = today.getHours();//获取时
        var M = today.getMinutes();//获取分
        var S = today.getSeconds();//获取秒
        return h+"-"+m+"-"+d+" "+H+":"+M+":"+S; //返回 年-月-日 时:分:秒
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