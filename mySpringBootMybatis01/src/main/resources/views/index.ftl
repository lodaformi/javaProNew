<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>随机点名器</title>
    <style type="text/css">
        #parent {
            background-color: orangered;
            height: 500px;
            border-radius: 10px;
            width: 700px;
            margin: 100px auto;
            position: relative;
        }

        #box {
            margin: auto;
            width: 400px;
            font-size: 66px;
            border: 1px solid black;
            font-weight: bold;
            height: 94px;
            border-radius: 20px;
            text-align: center;
            background-color: antiquewhite;
            position: absolute;
            margin-top: 100px;
            margin-left: 140px;
        }

        #bt {
            margin: auto;
            border-radius: 10px;
            background-color: #aa5500;
            width: 200px;
            text-align: center;
            margin-top: 300px;
            margin-left: 240px;
            color: #070000;
            font-weight: bold;
            font-size: 25px;
            cursor: pointer;
        }
    </style>
    <script type="text/javascript">
        var namelist = ["来宪龙", "李泽文", "黎锦沛", "黑海涛", "景山松",
            "蒋祖禹", "屈明", "徐火飞", "彭江明", "李逢华",
            "刘成龙", "顾凯", "万伟锋", "王锋", "陈瑶",
            "淡一炎", "李联胜", "高艳琪", "张春生", "李桁", "孙德胜"
        ];
        var mytime = null;

        function doit() {
            var bt = window.document.getElementById("bt");
            if (mytime == null) {
                bt.style.backgroundColor = "#ff0000";
                bt.innerHTML = "停止";
                show();
            } else {
                bt.style.backgroundColor = "#aa5500";
                bt.innerHTML = "开始";
                clearTimeout(mytime);
                mytime = null;
            }
        }

        function show() {
            var box = window.document.getElementById("box");
            var num = Math.floor((Math.random() * 100000)) % namelist.length;
            box.innerHTML = namelist[num];
            mytime = setTimeout("show()", 50);
        }
    </script>
</head>

<body>
<div id="parent">
    <div id="box">随机点名器</div>
    <button id="bt" onclick="doit()">开始</button>
</div>
</body>
</html>
