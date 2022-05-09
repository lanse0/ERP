layui.use(['table', 'form','laydate'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery,
        laydate = layui.laydate;
    laydate.render({
        elem: '#date'
    });
    laydate.render({
        elem: '#date1'
    });
    //表格渲染
    table.render({
        elem: '#PersonTable',
        url:'/warehouse/findByPage2',
        height: 'full-200',
        cellMinWidth: 80,
        cols: [[ //表头
            {field: 'sId', title: '编号',event:'detail',templet: "<div>{{d.id+'(查看详情)'}}</div>"},
            {field: 'sName', title: '仓库名称'},
            {field: 'userName', title: '负责人'},
            {field: 'regionName', title: '所属区域'},
            {field: 'sum', title: '入库数量'},
            {field: 'sum', title: '金额'}
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
        if (obj.event == 'detail') {

        }})
    getProvince('1');
    form.on('select(province1)', function(data){
        getCity('1',data.value);
        table.reload('PersonTable', {
            url: '/warehouse/findByPage2',
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
    form.on('select(city1)', function(){
        table.reload('PersonTable', {
            url: '/warehouse/findByPage2',
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
            url: '/warehouse/findByPage2',
            method: 'post',
            dataType: 'json',
            where: { //设定异步数据接口的额外参数，任意设
                name: p_name,
                beginTime:$("#date").val(),
                endTime:$("#date1").val()
            },
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
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
});
