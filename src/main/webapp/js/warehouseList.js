layui.use(['table', 'form'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery;
    //表格渲染
    table.render({
        elem: '#PersonTable',
        url:'/warehouse/findByPage',
        height: 'full-200',
        cellMinWidth: 80,
        cols: [[ //表头
            {field: 'id', title: '编号',event:'detail',templet: "<div>{{d.id+'(查看详情)'}}</div>"},
            {field: 'id', title: '采购单编号'},
            {field: 'id', title: '金额'},
            {field: 'sName', title: '仓库名称'},
            {field: 'warehouseTime', title: '入库时间',templet: "<div>{{layui.util.toDateString(d.warehouseTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
            },
            {field: 'userName', title: '入库人'},
            {field: 'status', title: '状态', event:'status', templet:'#checkStatus'},
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
    form.on('submit(showS)', function(data){
        $.ajax({
            url: '/storehouse/getStorehouseById',
            type: 'post',
            data: {
                id: $("#sDId").val()
            },
            dataType: 'json',
            success: function (resp) {
                console.log(resp.data);
                getSDetail(layer,resp.data);
            }
        });
    })
    form.on('select(status)', function(data){
        table.reload('PersonTable', {
            url: '/warehouse/findByPage',
            method: 'post',
            dataType: 'json',
            where: { //设定异步数据接口的额外参数，任意设
                status: data.value
            },
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });
    table.on('tool(person-table)', function(obj) {
        if (obj.event == 'detail') {
            getDetail(obj.data);
            layer.open({
                type: 1,
                shift: 2,
                shade: 0,
                title: '详细信息',
                area: ['520px', '520px'],
                closeBtn: false,
                shadeClose: false,
                content: $('#box2'),
                btnAlign: 'c',
                btn: ['关闭'],
                yes: function (index, layero) {
                    layer.closeAll();
                }
            });
        }
        if (obj.event == 'status') {
                $.ajax({
                    url: "/warehouse/updateWarehouse",
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
        }
    })
    //查询
    $('.btn-search').on('click', function () {
        var p_name = $('#p_name').val();
        table.reload('PersonTable', {
            url: '/warehouse/findByPage',
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
                url: '/warehouse/delStorehouse',
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
    form.render("select");
    //提交监听，submit(save)对应的是提交按钮的lay-filter属性
    form.on('submit(save)', function (data) {
        console.log(data.field)
        layer.load(1);
        $.ajax({
            url: "/warehouse/addWarehouse",
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
    function getDetail(data){
        $("#sDId").val(data.storehouse.id);
        $("#box2").html("");
        $("#box2").append("  <ul class=\"forminfo\">\n" +
            "    <li>\n" +
            "      <label>采单编号</label>\n" +
            "      <cite>"+0+"</cite>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <label>采购时间</label>\n" +
            "      <cite>"+0+"</cite>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <label>总金额</label>\n" +
            "       <cite>"+0+"</cite>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <label>操作人</label>\n" +
            "      <cite>"+0+"</cite>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <label>入货仓库</label>\n" +
            "      <cite><a lay-submit lay-filter=\"showS\" title=\"点击查看客户详细信息\" class=\"tablelink\">"+data.storehouse.name+"</a></cite>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <label>入库时间</label>\n" +
            "      <cite>"+data.warehouseTime+"</cite>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <label>入库人</label>\n" +
            "      <cite>"+data.user.empName+"</cite>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <label>入库状态</label>\n" +
            "      <cite>"+('0'==data.status?'未入库':'已入库')+"</cite>\n" +
            "    </li>\n" +
            "  </ul>\n" +
            "  <table class=\"tablelist\">\n" +
            "      <thead>\n" +
            "        <tr>\n" +
            "          <th>序号</th>\n" +
            "          <th>品牌</th>\n" +
            "          <th>类型</th>\n" +
            "          <th>型号</th>\n" +
            "          <th>厂商</th>\n" +
            "          <th>数量</th>\n" +
            "          <th>单位</th>\n" +
            "          <th>单价</th>\n" +
            "          <th>金额</th>\n" +
            "        </tr>\n" +
            "      </thead>\n" +
            "      <tbody>\n" +
            "        <tr>\n" +
            "          <td>1</td>\n" +
            "          <td>联想</td>\n" +
            "          <td>笔记本电脑</td>\n" +
            "          <td>T470</td>\n" +
            "          <td>北京联想科技股份有限公司</td>\t\n" +
            "          <td>10</td>\n" +
            "          <td>台</td>\n" +
            "          <td>9998</td>\n" +
            "          <td>99980</td>\n" +
            "        </tr>\n" +
            "        <tr>\n" +
            "          <td>2</td>\n" +
            "          <td>联想</td>\n" +
            "          <td>笔记本电脑</td>\n" +
            "          <td>X260</td>\n" +
            "          <td>北京联想科技股份有限公司</td>\t\n" +
            "          <td>5</td>\n" +
            "          <td>台</td>\n" +
            "          <td>5500</td>\n" +
            "          <td>27500</td>\n" +
            "        </tr>\n" +
            "      </tbody>\n" +
            "  </table>");
    }
});
