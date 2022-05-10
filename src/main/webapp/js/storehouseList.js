layui.use(['table', 'form'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery;
    storehouseT(table);
    table.on('tool(person-table)', function(obj) {
        if (obj.event == 'detail') {
            getSDetail(layer,obj.data);

        }
    })
    getProvince('1');
    form.on('select(province1)', function(data){
        getCity('1',data.value);
        table.reload('PersonTable', {
            url: '/storehouse/findByPage',
            method: 'post',
            dataType: 'json',
            where: { //设定异步数据接口的额外参数，任意设
                regionP: data.value
            },
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });
    form.on('select(province)', function(data){
        getCity('',data.value)
    });
    form.on('select(city1)', function(){
        table.reload('PersonTable', {
            url: '/storehouse/findByPage',
            method: 'post',
            dataType: 'json',
            where: { //设定异步数据接口的额外参数，任意设
                regionName: $("#city1").val()
            },
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });
    //查询
    $('.btn-search').on('click', function () {
        var p_name = $('#p_name').val();
        table.reload('PersonTable', {
            url: '/storehouse/findByPage',
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
        getProvince('');
        getMaster();
        layer.open({
            type: 1,
            shift: 2,
            shade: 0,
            title: '添加仓库信息',
            area: ['366px', '520px'],
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
        var cs = table.checkStatus('PersonTable');
        var data = cs.data;
        var i = data.length;
        if (i === 1) {
            console.log(data)
            form.val('person-form', data[0]);
            getCity('',data[0].parentId);
            $("#city").val(data[0].regionId);
            layer.open({
                type: 1,
                shift: 2,
                shade: 0,
                title: '修改仓库信息',
                area: ['366px', '520px'],
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
            });form.render();
        } else {
            layer.msg('请选择一条仓库信息进行修改', {icon: 5});
        }
    });

    //删除
    $('.btn-del').on('click', function () {
        var cs = table.checkStatus('PersonTable');
        var data = cs.data;
        var i = data.length;
        if (i < 1) {
            layer.msg('请选择需要删除的仓库信息', {icon: 5});
            return;
        }
        layer.confirm('确定要删除选中的仓库信息吗？', function (index) {
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
        console.log(data.field)
        var f=$("#id").val();
        console.log("ki"+f)
        var url = '/storehouse/';
        if (f==0) { //修改
            url += 'addStorehouse';
        } else {  //添加
            url += 'updateStorehouse';
        }
        layer.load(1);
        $.ajax({
            url: url,
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
    function getProvince(p){
        $("#province"+p).html("");
        $.ajax({
            url: '/area/getProvince',
            type: 'post',
            dataType:'json',
            async:false,
            success: function (resp) {
                console.log(resp);
                $("#province"+p).append(new Option("省",0));
                $.each(resp.data, function (index, value) {
                    $("#province"+p).append(new Option(value.regionName,value.id));
                });
                form.render("select");
            }});}
    function getCity(c,v){
        $("#city"+c).html("");
        $.ajax({
            url: '/area/getCityByPId',
            type: 'post',
            data:{id:v},
            dataType:'json',
            async:false,
            success: function (resp) {
                $("#city"+c).append(new Option("市",0));
                console.log(resp);
                $.each(resp.data, function (index, value) {
                    $("#city"+c).append(new Option(value.regionName,value.id));
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

});
