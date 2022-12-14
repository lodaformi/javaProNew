layui.use(['table','layer',"form"],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    //用户展示
    //加载用户数据表格
    var  tableIns = table.render({
        //数据表格的id，用于头工具栏获取，达到多选条目的目的
        id : "loginInfoTable",
        //容器元素的ID属性值
        elem: '#infoList',
        //容器的高度full-差值
        height: 'full-125',
        //单元格最小的宽度
        cellMinWidth : 95,
        //访问数据的URL(后台的数据接口)
        url : ctx +'/loginInfo/list',
        //开启分页
        page : true,
        //默认每页显示的数量
        limit : 10,
        //每页页数的可选项
        limits : [10,15,20,25],

        //表头
        cols : [[
            //field：要求field属性值与返回的数据中对应字段的属性值保持一致
            //title：设置列的标题
            //sort：是否允许排序（默认false）
            //fixed: 固定列
            {type: "checkbox", fixed:"center"}, //复选框
            {field: "id", title:'编号',fixed:"true"},
            {field: 'username', title: '用户名称',align:"center"},
            {field: 'tLoginIp', title: '登陆IP', align:'center'},
            {field: 'tLoginTime', title: '登陆时间',  align:'center'},
        ]]
    });

    // 多条件搜索
    //点击搜索按钮时，数据表格重载，将文本框中的值，传递给后台的url
    $(".search_btn").on("click",function(){
        console.log( $("input[name='loginDateTime']").val())
        //表格重载，多条件查询
        tableIns.reload({
            page: {
                curr: 1 //重新从第 1 页开始
            },
            //表单文本框值的获取方法，元素的val()方法
            where: {
                //属性选择器
                tLoginTime: $("input[name='loginDateTime']").val(),  //用户名
            }
        })
    });
});