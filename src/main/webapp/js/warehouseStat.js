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
            {field: 'sId', title: '编号',event:'detail',templet: "<div>{{d.sId+'(查看详情)'}}</div>"},
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
            $("#top").hide();
            table.render({
                elem: '#PersonTable',
                url: '/warehouse/findByPage',
                height: 'full-200',
                where: { //设定异步数据接口的额外参数，任意设
                    name: obj.data.sName,
                },
                cellMinWidth: 80,
                cols: [[ //表头
                    {field: 'id', title: '编号', event: 'detail2', templet: "<div>{{d.id+'(查看详情)'}}</div>"},
                    {field: 'sName', title: '仓库名称'},
                    {field: 'id', title: '采购单编号'},
                    {field: '', title: '商品数量'},
                    {field: 'id', title: '金额'},
                    {
                        field: 'warehouseTime',
                        title: '入库时间',
                        templet: "<div>{{layui.util.toDateString(d.warehouseTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                    },
                    {field: 'userName', title: '入库人'}
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
        }
            if (obj.event == 'detail2') {
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
        })
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
    function getDetail(data){
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
            "      <label>审核状态</label>\n" +
            "      <cite>"+0+"</cite>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <label>审核意见</label>\n" +
            "      <cite>"+0+"</cite>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <label>审核人</label>\n" +
            "      <cite>"+0+"</cite>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <label>审核时间</label>\n" +
            "      <cite>"+0+"</cite>\n" +
            "    </li>\n" +
            "    <li>\n" +
            "      <label>入货仓库</label>\n" +
            "      <cite><a href=\"../storage/storageView.html\" title=\"点击查看客户详细信息\" class=\"tablelink\">"+data.storehouse.name+"</a></cite>\n" +
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
