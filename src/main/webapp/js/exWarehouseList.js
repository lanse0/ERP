layui.use(['table', 'form'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery;
    //表格渲染
    table.render({
        elem: '#PersonTable',
        url:'/exWarehouse/findByPage',
        height: 'full-200',
        cellMinWidth: 80,
        cols: [[ //表头
            {field: 'id', title: '编号'},
            {field: 'id', title: '采购单编号'},
            {field: 'id', title: '金额'},
            {field: 'sName', title: '仓库名称'},
            {field: 'warehouseTime', title: '出库时间',templet: "<div>{{layui.util.toDateString(d.warehouseTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
            },
            {field: 'userName', title: '出库人'},
            {field: 'status', title: '状态',event: 'status1',
                templet: "<div>{{'0'==d.status?'未发货':'1'==d.status?'已发货(进行回款)':'2'==d.status?'已退货':'已回款'}}</div>"},
            {field: 'status', title: '操作',event: 'status2',templet: "<div>{{'0'==d.status?'取消订单':'1'==d.status?'取消订单':''}}</div>"},
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

    table.on('tool(person-table)', function(obj) {
        var title="取消订单";
        if (obj.event == 'status1') {
            if(obj.data.status==1) title="回款";
            else return;
            update(obj,title);
        }
        else if (obj.event == 'status2') {
            if(obj.data.status!=0&&obj.data.status!=1) return;
            obj.data.storehouse.id=0;
           update(obj,title);
        }
    })
    //查询
    $('.btn-search').on('click', function () {
        var p_name = $('#p_name').val();
        table.reload('PersonTable', {
            url: '/exWarehouse/findByPage',
            method: 'post',
            dataType: 'json',
            where: { //设定异步数据接口的额外参数，任意设
                name: p_name
            },
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    //添加人员
    $('.btn-add').on('click', function () {
        $("#id").val(0);
        $('.form-reset').click();
        getStorehouse();
        layer.open({
            type: 1,
            shift: 2,
            shade: 0,
            title: '添加入库信息',
            area: ['366px', '320px'],
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

    //删除
    $('.btn-del').on('click', function () {
        var cs = table.checkStatus('PersonTable');
        var data = cs.data;
        var i = data.length;
        if (i < 1) {
            layer.msg('请选择需要删除的入库信息', {icon: 5});
            return;
        }
        layer.confirm('确定要删除选中的入库信息吗？', function (index) {
            $.ajax({
                url: '/exWarehouse/delStorehouse',
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
        console.log(data.field)
        layer.load(1);
        $.ajax({
            url: "/exWarehouse/addExWarehouse",
            data: JSON.stringify(data.field),
            type: 'post',
            dataType: 'json',
            contentType:"application/json",
            success: function (resp) {
                layer.closeAll();
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
                layer.closeAll();
                layer.msg('系统错误，请联系管理员', {icon: 5});
            }
        });
        return false;
    });
    function getStorehouse(){
        $("#storehouseId").html("");
        $.ajax({
            url: '/storehouse/getAllStorehouse',
            type: 'post',
            data:{},
            dataType:'json',
            async:false,
            success: function (resp) {
                $("#storehouseId").append(new Option("请选择",0));
                console.log(resp);
                $.each(resp.data, function (index, value) {
                    $("#storehouseId").append(new Option(value.name,value.id));
                });
                form.render("select");
            }
        });
    }
    function update(obj,title){
        layer.confirm('确定要'+title+'吗?', function (index) {
            console.log(obj.data)
            $.ajax({
                url: "/exWarehouse/updateExWarehouse",
                data: JSON.stringify(obj.data),
                type: 'post',
                dataType: 'json',
                contentType:"application/json",
                success: function (resp) {
                    layer.closeAll();
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
                    layer.closeAll();
                    layer.msg('系统错误，请联系管理员', {icon: 5});
                }
            });
        })
    }
});
