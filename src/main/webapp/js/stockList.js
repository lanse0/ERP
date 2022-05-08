layui.use(['table', 'form'], function () {
    var table = layui.table,
        form = layui.form,
        $ = layui.jquery;
    //表格渲染
    table.render({
        elem: '#PersonTable',
        url:'/stock/findByPage',
        height: 'full-200',
        cellMinWidth: 80,
        cols: [[ //表头
            {field: 'id', title: '编号'},
            {field: 'sName', title: '仓库名称'},
            {field: 'sName', title: '商品品牌'},
            {field: 'sName', title: '商品类型'},
            {field: 'sName', title: '商品名称'},
            {field: 'sName', title: '厂商名称'},
            {field: 'sum', title: '负责人'},

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
    //查询
    $('.btn-search').on('click', function () {
        var p_name = $('#p_name').val();
        table.reload('PersonTable', {
            url: '/stock/findByPage',
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
});
