layui.use(['table', 'form'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery;

    //表格渲染
    table.render({
        elem: '#PersonTable',
        url:'/storehouse/findByPage',
        height: 'full-90',
        cellMinWidth: 80,
        cols: [[ //表头
            {type: 'radio'},
            {field: 'id', title: '编号'},
            {field: 'name', title: '仓库名称'},
            {field: 'masterName', title: '负责人'},
            {field: 'tel', title: '联系电话'},
            {field: 'regionName', title: '所属区域'},
            {field: 'status', title: '状态'},
            {field: 'createTime', title: '创建时间',templet: "<div>{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
            },
            {field: 'userName', title: '创建人'}
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
    getProvince('1');
    form.on('select(province1)', function(data){
        getCity('1',data.value);
    });
    form.on('select(province)', function(data){
        getCity('',data.value)
    });
    //查询
    $('.btn-search').on('click', function () {
        var p_name = $('#p_name').val();
        var regionName = $('#city1').val();
        table.reload('PersonTable', {
            url: '/storehouse/findByPage',
            method: 'post',
            dataType: 'json',
            where: { //设定异步数据接口的额外参数，任意设
                name: p_name,
                regionName: regionName
            },
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    //添加人员
    $('.btn-add').on('click', function () {
        $('.form-reset').click();
        getProvince('');
        getMaster();
        $('#pid').removeClass('layui-disabled');
        layer.open({
            type: 1,
            shift: 2,
            shade: 0,
            title: '添加人员信息',
            area: ['402px', '520px'],
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
                url: '/storehouse/delStorehouse',
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
                    table.reload('/storehouse/findByPage', {
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
    function getProvince(p){
        $.ajax({
            url: '/area/getProvince',
            type: 'post',
            dataType:'json',
            success: function (resp) {
                console.log(resp);
                $.each(resp.data, function (index, value) {
                    $("#province"+p).append(new Option(value.regionName,value.id));
                });
                form.render("select");
            }
        });
    }
    function getCity(c,v){
        $("#city"+c).html("");
        $.ajax({
            url: '/area/getCityByPId',
            type: 'post',
            data:{id:v},
            dataType:'json',
            success: function (resp) {
                $("#city"+c).append(new Option("城市",0));
                console.log(resp);
                $.each(resp.data, function (index, value) {
                    $("#city"+c).append(new Option(value.regionName,value.id));
                });
                form.render("select");
            }
        });
        form.render("select");
    }
    function getMaster(){
        $("#masterId").html("<option value=\"0\">请选择</option><option value=\"1\">ki</option><option value=\"2\">kii</option>");
        // $.ajax({
        //     url: '/storehouse/delStorehouse',
        //     type: 'post',
        //     data: {},
        //     dataType: 'json',
        //     success: function (resp) {
        //         if (resp.success) {
        //             table.reload('PersonTable', {
        //                 where: {},
        //                 page: {
        //                     curr: 1 //重新从第 1 页开始
        //                 }
        //             });
        //             layer.msg(resp.message, {icon: 6});
        //         } else {
        //             layer.msg(resp.message, {icon: 5});
        //         }
        //     }
        // });
        form.render("select");
    }
});
