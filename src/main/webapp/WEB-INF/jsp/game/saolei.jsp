<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/tool/easyui-1.7/jquery.min.js"></script>
<script type="text/javascript">
 window.onload = function(){ 
	document.getElementById("up").oncontextmenu=Youji; 
}
function Youji(){
	return false;
}
$(function(){
	load_init();
	$(".space").mousedown(function(e){
		if(e.which == 1){
			$(this).removeClass('addup');
		}else if(e.which == 2){
			alert("zhong");
		}else if(e.which == 3){
			alert("you");
		}
		
	})
})
function load_init(){
	var down = $('#down>table');
	var up = $('#up>table');
	var str='';
	for(var i=0;i<10;i++){
		str += "<tr>";
		for(var j=0;j<10;j++){
			str += "<td><div class='space'></div></td>";
		}
		str += "</tr>";
	}
	down.html(str);
	up.html(str);
	$('#up>table>tbody>tr>td>div').addClass('addup');
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


</style>
</head>
<body>
<div id='down'>
	<table cellpadding="0" cellspacing="0" border="1">
	</table>
</div>
<div id='up'>
	<table cellpadding="0" cellspacing="0" border="1">
	</table>
</div>
</body>
</html>