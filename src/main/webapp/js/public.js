function getSDetail(layer,data){
    $("#detail").html("");
    $("#detail").append("     <li>\n" +
        "            <label>仓库名称</label>\n" +
        "            <cite>"+data.name+"</cite>\n" +
        "        </li>\n" +
        "        <li>\n" +
        "            <label>仓库地址</label>\n" +
        "            <cite>"+data.address+"</cite>\n" +
        "        </li>\n" +
        "        <li>\n" +
        "            <label>所属区域</label>\n" +
        "            <cite>"+data.regionName+"</cite>\n" +
        "        </li>\n" +
        "        <li>\n" +
        "            <label>负责人</label>\n" +
        "            <cite>"+data.masterName+"</cite>\n" +
        "        </li>\n" +
        "        <li>\n" +
        "            <label>联系方式</label>\n" +
        "            <cite>"+data.tel+"</cite>\n" +
        "        </li>\n" +
        "        <li>\n" +
        "            <label>描述</label>\n" +
        "            <cite>"+data.des+"</cite>\n" +
        "        </li>\n" +
        "        <li>\n" +
        "            <label>状态</label>\n" +
        "            <cite>"+(data.status==0?"不可用":"可用")+"</cite>\n" +
        "        </li>\n" +
        "        <li>\n" +
        "            <label>创建人</label>\n" +
        "            <cite>"+data.userName+"</cite>\n" +
        "        </li>\n" +
        "        <li>\n" +
        "            <label>创建时间</label>\n" +
        "            <cite>"+data.createTime+"</cite>\n" +
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
             $("#detail").hide();
        }
    });
}
function storehouseT(table){
    //表格渲染
    table.render({
        elem: '#PersonTable',
        url:'/storehouse/findByPage',
        height: 'full-200',
        cellMinWidth: 80,
        cols: [[ //表头
            {type: 'radio'},
            {field: 'id', title: '编号',event:'detail',templet: "<div>{{d.id+'(查看详情)'}}</div>"},
            {field: 'name', title: '仓库名称'},
            {field: 'masterName', title: '负责人'},
            {field: 'tel', title: '联系电话'},
            {field: 'regionName', title: '所属区域'},
            {field: 'status', title: '状态',templet: "<div>{{d.status==0?'不可用':'可用'}}</div>"},
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
    })
}