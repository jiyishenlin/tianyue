<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${contextpath }/tool/easyui-1.7/jquery.min.js"></script>
<script type="text/javascript">
var row = 10;//10行
var col = 10;//10列
var num = 20;//20个地雷
//构建棋盘二维数组
var map = new Array(row);
for(var i = 0;i<10;i++){
	map[i] = new Array(col);
}
for(var i = 0;i<row;i++){
	for(var j = 0;j<col;j++){
		map[i][j]=0;
	}
}
 window.onload = function(){ 
	document.getElementById("up").oncontextmenu=Youji; 
}

var min=0;
function start(){
	var init=self.setInterval("clock()",1000);
}
function clock(){
	min++;
	$("#tip span").last().text(min+" s");
}
function Youji(){
	return false;
}
$(function(){
	init_map();
	init_lei();
	
	$("button").click(function(){
		start();
		$("#top").removeClass("addtop");
		$("#toptip").removeClass("addtoptip");
	});
	$(".space").mousedown(function(e){
		if(e.which == 1){//左键
			var c = $(this).attr("class");
			if(c.indexOf("hongqi")<0){
				$(this).removeClass('addup');
			}
			var x = c.substring(6,7);
			var y = c.substring(7,8);
			if(map[x][y] == 9){
				$("#top").addClass("addtop");
				$("#toptip").addClass("addtoptip");
				$("#toptip span").text("游戏结束！");
				
			}
			alert(point);
		}else if(e.which == 3){//右键
			var c = $(this).attr("class");
			if(c.indexOf("hongqi") < 0 && c.indexOf("addup") > 0){
				$(this).addClass('hongqi');
			}else{
				$(this).removeClass('hongqi');
			}
		}
	});
	
})
function init_map(){
	var down = $('#down>table');
	var up = $('#up>table');
	var str='';
	for(var i=0;i<10;i++){
		str += "<tr>";
		for(var j=0;j<10;j++){
			str += "<td><div class='space "+i+j+"'></div></td>";
		}
		str += "</tr>";
	}
	down.html(str);
	up.html(str);
	$('#up>table>tbody>tr>td>div').addClass('addup');
	$("#top").addClass("addtop");
	$("#toptip").addClass("addtoptip");
}


function init_lei(){
	

/* 	//构建棋盘二维数组
	var map = new Array(row);
	for(var i = 0;i<10;i++){
		map[i] = new Array(col);
	}
	for(var i = 0;i<row;i++){
		for(var j = 0;j<col;j++){
			map[i][j]=0;
		}
	} */
	//随机产生num个地雷
	var point = new Array(num);
	for(var i = 0; i< num; i++){
		var x = random(0, 10);
		var y = random(0, 10);
		var p = x+""+y;
		var jump = false;
		for(var j=0;j<point.length;j++){
			if(point[j] == p){
				i--;
				jump = true;
				break;
			}
		}
		if(jump){
			continue;
		}
		point[i] = p;
	}
	//向二维数组添加地雷坐标
	for(var i = 0;i< num;i++){
		var x = point[i].substring(0,1);
		var y = point[i].substring(1);
		map[x][y]=9;
		console.log(x+""+y);
	}
	//添加地雷
	for(var i=0;i<row;i++){
		for(var j=0;j<col;j++){
			if(map[i][j]==9){
				//
				
				//设置地雷周围的数字
				//4个角
				if(i==0 && j==0){
					//左上角
					for(var x=0;x<2;x++){
						for(var y=0;y<2;y++){
							if(map[i+x][j+y] != 9){
								if(map[i+x][j+y] == 0){
									map[i+x][j+y] = 1;
								}else{
									map[i+x][j+y] += 1;
								}
							}
						}
					}
				}else if(i==0 && j==col-1){
					//右上角
					for(var x=0;x<2;x++){
						for(var y=0;y<2;y++){
							if(map[i+x][j-1+y] != 9){
								if(map[i+x][j-1+y] == 0){
									map[i+x][j-1+y] = 1;
								}else{
									map[i+x][j-1+y] += 1;
								}
							}
						}
					}
				}else if(i == row-1 && j == 0){
					//左下角
					for(var x=0;x<2;x++){
						for(var y=0;y<2;y++){
							if(map[i-1+x][j+y] != 9){
								if(map[i-1+x][j+y] == 0){
									map[i-1+x][j+y] = 1;
								}else{
									map[i-1+x][j+y] += 1;
								}
							}
						}
					}
				}else if(i == row-1 && j == col-1){
					//右下角
					for(var x=0;x<2;x++){
						for(var y=0;y<2;y++){
							if(map[i-1+x][j-1+y] != 9){
								if(map[i-1+x][j-1+y] == 0){
									map[i-1+x][j-1+y] = 1;
								}else{
									map[i-1+x][j-1+y] += 1;
								}
							}
						}
					}
				}else if(i == 0 && j >= 1 && j<= col-1){
					//上面一道边
					for(var x=0;x<2;x++){
						for(var y=0;y<3;y++){
							if(map[i+x][j-1+y] != 9){
								if(map[i+x][j-1+y] == 0){
									map[i+x][j-1+y] = 1;
								}else{
									map[i+x][j-1+y] += 1;
								}
							}
						}
					}
				}else if(i >= 1 && i <= row-1 && j == col-1){
					//右边一道边
					for(var x=0;x<3;x++){
						for(var y=0;y<2;y++){
							if(map[i-1+x][j+y] != 9){
								if(map[i-1+x][j+y] == 0){
									map[i-1+x][j+y] = 1;
								}else{
									map[i-1+x][j+y] += 1;
								}
							}
						}
					}
				}else if(i == row-1 && j >= 1 && j <= col-1){
					//下边一道边
					for(var x=0;x<2;x++){
						for(var y=0;y<3;y++){
							if(map[i-1+x][j-1+y] != 9){
								if(map[i-1+x][j-1+y] == 0){
									map[i-1+x][j-1+y] = 1;
								}else{
									map[i-1+x][j-1+y] += 1;
								}
							}
						}
					}
				}else if(i >= 1 && i <= row-1 && j == 0){
					//左边一道边
					for(var x=0;x<3;x++){
						for(var y=0;y<2;y++){
							if(map[i-1+x][j+y] != 9){
								if(map[i-1+x][j+y] == 0){
									map[i-1+x][j+y] = 1;
								}else{
									map[i-1+x][j+y] += 1;
								}
							}
						}
					}
				}else if(i >= 1 && i<= row -1 && j>= 1 && j <= col-1){
					//中间
					for(var x=0;x<3;x++){
						for(var y=0;y<3;y++){
							if(map[i-1+x][j-1+y] != 9){
								if(map[i-1+x][j-1+y] == 0){
									map[i-1+x][j-1+y] = 1;
								}else{
									map[i-1+x][j-1+y] += 1;
								}
							}
						}
					}
				}
			}
		}
	}
	//向棋盘填数字
	for(var i=0;i<row;i++){
		for(var j=0;j<col;j++){
			if(map[i][j] == 9){
				$("#down ."+i+""+j).addClass("time");
			}else if(map[i][j] != 0){
				$("#down ."+i+""+j).text(map[i][j]);
			}
		}
	}
}

/**
 * 产生随机整数，包含下限值，但不包括上限值
 * @param {Number} lower 下限
 * @param {Number} upper 上限
 * @return {Number} 返回在下限到上限之间的一个随机整数
 */
function random(lower, upper) {
	return Math.floor(Math.random() * (upper - lower)) + lower;
 }
</script>
<style type="text/css">
*{
padding: 0px;
margin: 0px;
}
#down{
margin-left: 100px;
}

#up{
position: fixed;
top:0px;
left: 100px;
z-index: 10px;
}
#down div{
background-color: #ccc;
line-height: 50px;
text-align: center;
}
table{
width:500px;
height:500px;
}
table tr{
height:50px;
}
table tr td{
width:50px;
}
table tr td div{
width:50px;
height:50px;
cursor: pointer;
}

.addup{
background-color: yellow;
}
.hongqi{
background-image: url("/tool/easyui-1.7/themes/icons/hongqi.png");
}
.time{
background-image: url("/tool/easyui-1.7/themes/icons/timg.jpg");

}
#tip{
width:200px;
height:100px;
float:left;
border: 1px solid #000;
margin-left: 700px;
margin-top: -500px;
}
#tip div{
width:100%;
height:50%;
}
#tip div button{
width:100px;
height:30px;
cursor: pointer;
}
.addtop{
width:520px;
height:520px;
margin-left:100px;
position: fixed;
top:0px;
left:0px;
z-index: 11;
background-color: #ccc;
opacity:0.5;
line-height: 520px;
text-align: center;
color:red;
}
.addtoptip{
width:200px;
height:100px;
margin-left:260px;
margin-top:200px;
position: fixed;
top:0px;
left:0px;
z-index: 11;
background-color: #fff;
/* opacity:0.5; */
line-height: 100px;
text-align: center;
color:red;
}
</style>
</head>
<body>
<div id='down'>
	<table cellpadding="0" cellspacing="0" border="1">
	</table>
</div>
<div id='tip'>
<div class="first"><span>计时器：</span><span>0</span></div>
<div class="secend"><button>开始</button></div>
</div>
<div id='up'>
	<table cellpadding="0" cellspacing="0" border="1">
	</table>
</div>
<div id="top"></div>
<div id="toptip"><span>游戏开始！</span></div>
</body>
</html>