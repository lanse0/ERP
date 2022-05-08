layui.use(['table'],function () {
    var table = layui.table,
        $ = layui.jquery;
    //渲染表格数据
    table.render({
        elem: '#RegionTable',
        url: '/area/getAllRegionList',
        height: 'full-90',
        cellMinWidth: 80,
        cols: [[ //表头
            {field: 'id', title: '序号'},
            {field: 'parentReg.regionCode', title: '省编号', templet:function (region) {
                    return region.parentReg.regionCode
                }},
            {field: 'parentReg.regionName', title: '省名称', templet:function (region) {
                    return region.parentReg.regionName
                }},
            {field: 'regionCode', title: '市编号'},
            {field: 'regionName', title: '市名称'}
        ]],
        page: true //是否显示分页
        , limit: 10 //默认分页条数
        , limits: [10, 20, 30] //自定义分页数据选项
        , id: 'RegionTable' //用于绑定模糊查询条件等等
        // , done:function(res){
        //     var data = res.data;
        // }
        ,done: function () {
            table.resize('RegionTable');
        }
    });
});