<%--
  Created by IntelliJ IDEA.
  User: loda
  Date: 2022/11/10
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title"><span class="glyphicon glyphicon-signal"></span>&nbsp;数据报表 </div>
        <div class="container-fluid">
            <div class="row" style="padding-top: 20px;">
                <div class="col-md-12">
                    <%-- 柱状图的容器 --%>
                    <div id="monthChart" style="height: 500px"></div>

                    <%-- 百度地图的加载 --%>
                    <h3 align="center">用户地区分布图</h3>
                    <%-- 百度地图的容器 --%>
                    <div id="baiduMap" style="height: 600px;width: 100%;"></div>

                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="statics/echarts/echarts.min.js"></script>
<%-- 引用百度地图API文件，需要申请百度地图对应ak密钥--%>
<script type="text/javascript" src="https://api.map.baidu.com/api?v=1.0&&type=webgl&ak=yrxymYTyuefnxNtXbZcMU8phABXtu6TG"></script>
<script type="text/javascript">
    $.ajax({
       type: "get",
       url: "report",
       data: {
           actionName: "month"
       },
       success: function (result) {
           console.log(result);
           if (result.statusCode == 1) {
               var month = result.rsObj.monthArray;
               var dataCnt = result.rsObj.dataArray;
               loadMonthChart(month, dataCnt);
           }

       }
    });

    function loadMonthChart(month, dataCnt) {
        var chartDom = document.getElementById('monthChart');
        var myChart = echarts.init(chartDom);
        var option;

        // 指定图表的配置项和数据
        // X轴显示名称
        var dataAxis = month;
        // Y轴的数据
        var data = dataCnt;

        var yMax = 30;
        var dataShadow = [];
        for (let i = 0; i < data.length; i++) {
            dataShadow.push(yMax);
        }
        var option = {
            title: {
                text: '按月统计',
                subtext: '通过月份查询对应的云记数量',
                left:'center' // 标题对齐方式，center表示居中
            },
            // 提示框
            tooltip:{},
            xAxis: {
                data: dataAxis,
                axisTick: {
                    show: false
                },
                axisLine: {
                    show: false
                }
            },
            yAxis: {
                axisLine: {
                    show: false
                },
                axisTick: {
                    show: false
                },
                axisLabel: {
                    color: '#999'
                }
            },
            dataZoom: [
                {
                    type: 'inside'
                }
            ],
            series: [
                { // For shadow
                    type: 'bar', // 柱状图
                    data: data, // Y轴的数据
                    itemStyle: {
                        color: 'rgba(0,0,0,0.05)'
                    },
                    barGap: '-100%',
                    barCategoryGap: '40%',
                    data: dataShadow,
                    animation: false
                },
                {
                    type: 'bar',
                    showBackground: true,
                    itemStyle: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                            { offset: 0, color: '#83bff6' },
                            { offset: 0.5, color: '#188df0' },
                            { offset: 1, color: '#188df0' }
                        ])
                    },
                    emphasis: {
                        itemStyle: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                { offset: 0, color: '#2378f7' },
                                { offset: 0.7, color: '#2378f7' },
                                { offset: 1, color: '#83bff6' }
                            ])
                        }
                    },
                    data: data
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        option && myChart.setOption(option);
    }

    /**
     * 通过用户发布的坐标查询
     */
    $.ajax({
        type:"get",
        url:"report",
        data:{
            actionName:"location"
        },
        success:function (result){
            console.log(result);
            if (result.statusCode == 1) {
                // 加载百度地图
                loadBaiduMap(result.rsObj)
            }
        }
    });


    /**
     * 加载百度地图
     */
    function loadBaiduMap(markers) {
        // 加载地图实例
        var map = new BMapGL.Map("baiduMap");
        // 设置地图的中心点
        var point = new BMapGL.Point(116.404, 39.915);
        // 地图初始化，BMapGL.Map.centerAndZoom()方法要求设置中心点坐标和地图级别
        map.centerAndZoom(point, 10);
        // 开启鼠标滚轮缩放
        map.enableScrollWheelZoom(true);
        // 添加比例尺控件
        var zoomCtrl = new BMapGL.ZoomControl();
        map.addControl(zoomCtrl);

        // 判断是否有点标记
        if (markers != null && markers.length > 0) { // 集合中第一个坐标时用户当前所在位置，其他的事云记记录中的对应的经纬度
            // 将用户所在的位置设置为中心点
            map.centerAndZoom(new BMapGL.Point(markers[0].lon, markers[0].lat), 10);
            // 循环在地图上添加点标记
            for (var i = 1; i < markers.length; i++) {
                // 创建点标记
                var marker = new BMapGL.Marker(new BMapGL.Point(markers[i].lon, markers[i].lat));
                // 在地图上添加点标记
                map.addOverlay(marker);
            }
        }
    }

</script>
